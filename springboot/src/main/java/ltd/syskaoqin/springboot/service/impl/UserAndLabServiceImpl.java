package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.dao.mapper.UserAndLabMapper;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public UserAndLab selectByOpenid(String openid) {
        return userAndLabMapper.selectByOpenid(openid);
    }

    @Override
    public int calculateLabTotal(String labId) {
        int total = userAndLabMapper.calculateLabTotal(labId);
        if(total > 0){
            total -= 1;
        }
        return total;
    }
}
