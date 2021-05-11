package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/10日18:45
 */
@Mapper
public interface AdminMapper {

    /**
     * 用于管理员Check
     * @param userNumber userNumber
     * @param password password
     * @return Admin
     */
    Admin findAdminByNum(@Param("userNumber") String userNumber);
}
