package ltd.syskaoqin.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.service.UserService;
import ltd.syskaoqin.springboot.util.WechatUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
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
 * @Description TODO
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
        System.out.println(param);
        String code = param.get("code");
        JSONObject weJson = WechatUtil.getOpenid(code);
        String openid = weJson.getString("openid");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("WECHAT",openid);
        try {
            subject.login(token);
            Boolean b = subject.hasRole("NotBind");
            System.out.println("role"+b);
        }catch (AuthenticationException e){

        }

//        String nickName = param.get("nickName");
//        String avatarUrl = param.get("avatarUrl");
//        System.out.println(nickName);
//        System.out.println(avatarUrl);

        Map<String,String> data = new HashMap<>();
        data.put("roleId","1");
        data.put("session","thisissmocksessionkey");
        data.put("username","张小芳");
        data.put("belong","实验室102");
        data.put("avatarUrl","https://img.yzcdn.cn/vant/cat.jpeg");
        return ResultUtils.success(data);
    }

}
