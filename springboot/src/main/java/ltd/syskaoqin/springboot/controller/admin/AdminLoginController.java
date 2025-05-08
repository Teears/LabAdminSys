package ltd.syskaoqin.springboot.controller.admin;

import ltd.syskaoqin.springboot.dao.entity.Admin;
import ltd.syskaoqin.springboot.service.AdminService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/admin/login")
public class AdminLoginController {

    @Resource
    private AdminService adminService;

    @PostMapping(value = "")
    public Result login(@RequestBody Map<String, String> param){
        String userNumber = param.get("userNumber");
        String password = param.get("password");

        Admin admin = adminService.findAdminByNum(userNumber);
        if(password == null || admin == null || !password.equals(admin.getPassword())){
            return ResultUtils.error(-1,"密码错误！");
        }
        Map<String,String> data = new HashMap<>();
        data.put("token", JWTUtil.sign(userNumber,password));
        data.put("roleId","4");
        return ResultUtils.success(data);
    }
}
