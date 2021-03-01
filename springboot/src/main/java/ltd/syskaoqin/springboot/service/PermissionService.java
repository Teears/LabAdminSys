package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Permission;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName PermissionService
 * @Description TODO 用于权限管理
 * @createTime 2021年02月23日11:24
 */
public interface PermissionService {

    /**
     * 通过id查找权限
     * @param id id
     * @return Permission
     */
    Permission findByid(String id);

    /**
     * 获取一个角色具有的所有权限
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Permission> findByRoleId(String roleId);
}
