package ltd.syskaoqin.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.util.Openid;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/login")
public class WeLoginController {

    @PostMapping(value = "")
    @ResponseBody
    public Result login(@RequestParam Map<String, String> param, HttpSession session){
        System.out.println(param);
        String code = param.get("code");
        String openid = Openid.getOpenid(code);
        System.out.println(openid);
        Map<String,String> data = new HashMap<>();
        data.put("roleId","1");
        data.put("session","thisissmocksessionkey");
        data.put("username","张小芳");
        data.put("belong","实验室102");
        data.put("avatarUrl","https://img.yzcdn.cn/vant/cat.jpeg");
        return ResultUtils.success(data);
    }

}
