package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Role;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RoleService
 * @Description TODO
 * @createTime 2021年02月23日11:56
 */
public interface RoleService {

    Role findByid(String id);
}
