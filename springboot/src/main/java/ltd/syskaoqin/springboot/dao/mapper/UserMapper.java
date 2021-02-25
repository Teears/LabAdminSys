package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserMapper
 * @Description TODO
 * @createTime 2021年02月18日13:32
 */
@Mapper
public interface UserMapper {

//    List<User> findAllUser();

    User findUserById(@Param("id") String id);

    User findUserByopenid(@Param("openid") String openid);

    int insertUser(User user);

    int updateUserLatestTime(@Param("id") String id,@Param("latestTime") Long latestTime);

//    int updateBindId(@Param("id") String id, @Param("bindId") String bindId);
//
//    int updateRoleId(@Param("id") String id, @Param("roleId") String roleId);

    int updateBindAndRole(@Param("openid") String openid, @Param("bindId") String bindId,@Param("roleId") String roleId);


}
