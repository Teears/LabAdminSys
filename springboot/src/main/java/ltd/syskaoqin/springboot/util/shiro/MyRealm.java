package ltd.syskaoqin.springboot.util.shiro;
import ltd.syskaoqin.springboot.dao.entity.Permission;
import ltd.syskaoqin.springboot.dao.entity.Role;
import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.service.PermissionService;
import ltd.syskaoqin.springboot.service.RoleService;
import ltd.syskaoqin.springboot.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author Teears
 * @version 1.0.0
 * @ClassName MyRealm
 * @Description TODO
 * @createTime 2021年02月22日20:25
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private PermissionService permissionService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    private String tag = "WECHAT";
    private String id;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权 run");
        System.out.println(this.id);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String id = principals.toString();
        List<Permission> permissions = null;
        User user = userService.findUserById(id);
        System.out.println(user.getRoleId());
        Role role = roleService.findByid(user.getRoleId());
        if(role != null){
            simpleAuthorizationInfo.addRole(role.getName());
            System.out.println("授权role"+role.getName());
            permissions = permissionService.findByRoleId(role.getId());
        }else{
            return null;
        }
        Set<String> perms = new HashSet<>();
        for(Permission item: permissions){
            perms.add(item.getUrl());
        }
        simpleAuthorizationInfo.addStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户正确与否验证，错误抛出异常即可
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("wechat认证 run");
        String username = (String)authenticationToken.getPrincipal();
        if (this.tag.equals(username)){
            this.id = "u";
            String openid = new String((char[])authenticationToken.getCredentials());
            User user = userService.findUserByopenid(openid);
            if (user != null){
                return new SimpleAuthenticationInfo(user.getId(), user.getOpenid(), "myRealm");
            }else {
                return null;
            }
        }else {
            this.id = "a";
            //执行管理员登录
            System.out.println("管理员认证");
            return null;
        }
    }
}
