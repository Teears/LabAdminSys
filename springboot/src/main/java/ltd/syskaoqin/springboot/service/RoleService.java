package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Role;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RoleService
 * @Description TODO 用于权限管理
 * @createTime 2021年02月23日11:56
 */
public interface RoleService {

    /**
     * 通过id查找Role
     * @param id id
     * @return Role
     */
    Role findByid(String id);
}
