package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName PermissionMapper
 * @Description TODO Permission映射Mapper
 * @createTime 2021年02月23日11:05
 */
@Mapper
public interface PermissionMapper {

    /**
     * 通过id查找
     * @param id 权限id
     * @return Permission对象
     */
    Permission findByid(@Param("id") String id);

    /**
     * 查找某种角色拥有的所有权限
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Permission> findByRoleId(@Param("roleId") String roleId);
}
