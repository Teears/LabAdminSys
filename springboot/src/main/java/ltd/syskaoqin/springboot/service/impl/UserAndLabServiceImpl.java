package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.dao.mapper.UserAndLabMapper;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserAndLabServiceImpl
 * @Description TODO
 * @createTime 2021年03月07日14:09
 */
@Service
public class UserAndLabServiceImpl implements UserAndLabService {
    @Resource
    private UserAndLabMapper userAndLabMapper;

    @Override
    public UserAndLab selectByStuOpenid(String openid) {
        return userAndLabMapper.selectByStuOpenid(openid);
    }

    @Override
    public int calculateLabTotal(String labId) {
        int total = userAndLabMapper.calculateLabTotal(labId);
        if(total > 0){
            total -= 1;
        }
        return total;
    }

    @Override
    public void insertUserLab(UserAndLab userAndLab) {
        userAndLabMapper.insertUserLab(userAndLab);
    }

    @Override
    public void deleteByStuNumber(String stuNumber) {
        userAndLabMapper.deleteByStuNumber(stuNumber);
    }

    @Override
    public void updateOpenid(String openid, String stuNumber) {
        userAndLabMapper.updateOpenid(openid,stuNumber);
    }

    @Override
    public void insertUserLabTea(UserAndLab userAndLab) throws DuplicateKeyException {
        userAndLabMapper.insertUserLabTea(userAndLab);
    }

    @Override
    public void deleteByTeaNumber(String teaNumber,String labId) {
        userAndLabMapper.deleteByTeaNumber(teaNumber,labId);
    }

    @Override
    public void updateTeaOpenid(String openid, String teaNumber) {
        userAndLabMapper.updateTeaOpenid(openid,teaNumber);
    }

    @Override
    public List<UserAndLab> findByTeaNumber(String teaNumber) {
        return userAndLabMapper.findByTeaNumber(teaNumber);
    }
}
