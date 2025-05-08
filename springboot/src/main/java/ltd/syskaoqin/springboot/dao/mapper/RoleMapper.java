package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RoleMapper
 * @Description TODO Role映射Mapper
 * @createTime 2021年02月23日11:37
 */
@Mapper
public interface RoleMapper {
    /**
     * 查找角色，shiro授权时用
     * @param id roleId
     * @return role对象
     */
    Role findByid(@Param("id") String id);
}
