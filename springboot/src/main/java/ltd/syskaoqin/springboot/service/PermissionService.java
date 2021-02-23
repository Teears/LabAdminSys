package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Permission;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName PermissionService
 * @Description TODO
 * @createTime 2021年02月23日11:24
 */
public interface PermissionService {

    Permission findByid(String id);

    List<Permission> findByRoleId(String roleId);
}
