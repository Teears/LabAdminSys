package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.User;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserService
 * @Description TODO
 * @createTime 2021年02月18日14:40
 */
public interface UserService {

    List<User> findAllUser();

    User findUserByopenid(String openid);

    User findUserById(String id);

    int insertUser(User user);

    int updateUserLatestTime(String id);
//
//    int updateBindId(String id, String bindId);
//
//    int updateRoleId(String id, String roleId);

    int updateBindAndRole(String openid, String bindId, String roleId);
}
