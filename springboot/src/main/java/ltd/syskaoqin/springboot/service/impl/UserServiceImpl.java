package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserSericeImpl
 * @Description TODO
 * @createTime 2021年02月18日14:46
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUserLatestTime(String id, String latestTime) {
        return 0;
    }
}
