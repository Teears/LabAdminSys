package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.dao.mapper.UserMapper;
import ltd.syskaoqin.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserSericeImpl
 * @Description TODO
 * @createTime 2021年02月18日14:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

//    @Override
//    public List<User> findAllUser() {
//        return null;
//    }

    @Override
    public User findUserByopenid(String openid) {
        return userMapper.findUserByopenid(openid);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public void updateUserLatestTime(String openid) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String latestTime = df.format(date);
        userMapper.updateUserLatestTime(openid, latestTime);
    }

    @Override
    public void updateBindAndRole(String openid, String bindId, String roleId) {
        userMapper.updateBindAndRole(openid, bindId, roleId);
    }

    @Override
    public Map<String, String> findAvatarName(String openid) {
        return userMapper.findAvatarName(openid);
    }

//    @Override
//    public int updateBindId(String id, String bindId) {
//        return userMapper.updateBindId(id,bindId);
//    }
//
//    @Override
//    public int updateRoleId(String id, String roleId) {
//        return userMapper.updateRoleId(id,roleId);
//    }

}
