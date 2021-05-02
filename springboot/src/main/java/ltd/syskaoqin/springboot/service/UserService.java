package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.User;

import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserService
 * @Description TODO User相关服务
 * @createTime 2021年02月18日14:40
 */
public interface UserService {

//    List<User> findAllUser();
//
//    int updateBindId(String id, String bindId);
//
//    int updateRoleId(String id, String roleId);

    /**
     * 通过openid查找User服务
     * @param openid openid
     * @return User
     */
    User findUserByopenid(String openid);

    /**
     * 通过id查找User服务
     * @param id id
     * @return User
     */
    User findUserById(String id);

    /**
     * 新用户注册
     * @param user user
     * @return 1插入成功
     */
    int insertUser(User user);

    /**
     * 更新最近登录
     * @param openid openid
     */
    void updateUserLatestTime(String openid);

    /**
     * 身份绑定
     * @param openid openid
     * @param bindId 学生或教师学号工号
     * @param roleId 未绑定0，学生1，教师2
     */
    void updateBindAndRole(String openid, String bindId, String roleId);

    /**
     * 获取学生用户的头像和姓名
     * @param openid openid
     * @return map
     */
    Map<String,String> findAvatarName(String openid);
}
