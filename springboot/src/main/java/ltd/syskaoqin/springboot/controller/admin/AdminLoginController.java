package ltd.syskaoqin.springboot.controller.admin;


import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.WechatUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName BindRole
 * @Description TODO Admin登录
 * @createTime 2021年04月22日20:22
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestParam Map<String, String> param){
        String userNumber = param.get("userNumber");
        String password = param.get("password");
        System.out.println(userNumber);

        Map<String,String> data = new HashMap<>();
        data.put("token", JWTUtil.sign(userNumber,password));
        data.put("roleId","4");
        System.out.println(data);
        return ResultUtils.success();
    }
}
