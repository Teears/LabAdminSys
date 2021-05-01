package ltd.syskaoqin.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.service.UserService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.WechatUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName WeLoginController
 * @Description TODO 微信端登录接口
 * @createTime 2021年02月18日17:00
 */
@RestController
@RequestMapping("/welogin")
public class WeLoginController {
    @Resource
    private UserService userService;

    @PostMapping(value = "")
    @ResponseBody
    public Result login(@RequestParam Map<String, String> param){
        String code = param.get("code");
        JSONObject weJson = WechatUtil.getOpenid(code);
        String openid = weJson.getString("openid");
        Map<String,String> data = new HashMap<>();
        if(userService.findUserByopenid(openid) == null){
            User user = new User();
            String nickName = param.get("nickName");
            String avatarUrl = param.get("avatarUrl");
            user.setAvatarUrl(avatarUrl);
            user.setOpenid(openid);
            user.setNickname(nickName);
            user.setRoleId("0");
            if(userService.insertUser(user) == 0){
                return ResultUtils.error(500,"系统错误");
            }
            data.put("avatarUrl",avatarUrl);
        }else {
            data.put("avatarUrl",userService.findUserByopenid(openid).getAvatarUrl());
        }
        UsernamePasswordToken token = new UsernamePasswordToken("WECHAT",openid);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        if(subject.hasRole("Student")){
            data.put("roleId","1");
        }else if(subject.hasRole("Teacher")){
            data.put("roleId","2");
        }else if(subject.hasRole("NotBind")){
            data.put("roleId","0");
        }
        data.put("token",JWTUtil.sign(openid,openid));
        userService.updateUserLatestTime(openid);
        System.out.println(data);
        return ResultUtils.success(data);
    }

}
