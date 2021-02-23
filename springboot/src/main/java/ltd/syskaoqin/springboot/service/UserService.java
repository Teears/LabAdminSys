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

    int updateUserLatestTime(String id, String latestTime);
}
