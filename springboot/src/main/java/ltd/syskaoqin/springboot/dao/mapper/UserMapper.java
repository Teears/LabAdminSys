package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserMapper
 * @Description TODO 用户Mapper，用于身份认证
 * @createTime 2021年02月18日13:32
 */
@Mapper
public interface UserMapper {

//    List<User> findAllUser();

    /**
     * 通过无意义自增序列id查找User
     * @param id id
     * @return User
     */
    User findUserById(@Param("id") String id);

    /**
     * 通过Openid查找学生
     * @param openid openid
     * @return User
     */
    User findUserByopenid(@Param("openid") String openid);

    /**
     * 在通过openid查找结果为null时
     * 插入一条用户数据，等于注册步骤
     * @param user user
     * @return 返回1则查找成功
     */
    int insertUser(User user);

    /**
     * 更新用户最近登录时间
     * @param openid openid
     * @param latestTime 当前登录时间
     * @return 返回1则更新成功
     */
    int updateUserLatestTime(@Param("openid") String openid,@Param("latestTime") String latestTime);

//    int updateBindId(@Param("id") String id, @Param("bindId") String bindId);
//
//    int updateRoleId(@Param("id") String id, @Param("roleId") String roleId);

    /**
     * 用户绑定学生或教师身份时填入绑定的学生学号或教师工号
     * @param openid openid
     * @param bindId 对应数据库中stu_tea_id学生或教师的学号和工号
     * @param roleId 未绑定0，学生1，教师2
     * @return 返回1则绑定成功
     */
    int updateBindAndRole(@Param("openid") String openid, @Param("bindId") String bindId,@Param("roleId") String roleId);

    /**
     * 获取学生用户的头像和姓名
     * @param openid openid
     * @return map
     */
    Map<String,String> findAvatarName(@Param("openid") String openid);
}
