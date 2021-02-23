package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName PermissionMapper
 * @Description TODO
 * @createTime 2021年02月23日11:05
 */
@Mapper
public interface PermissionMapper {

    Permission findByid(@Param("id") String id);

    List<Permission> findByRoleId(@Param("roleId") String roleId);
}
