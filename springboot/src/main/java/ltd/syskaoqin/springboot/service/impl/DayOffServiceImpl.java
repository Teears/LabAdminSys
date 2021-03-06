package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.mapper.DayOffMapper;
import ltd.syskaoqin.springboot.service.DayOffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName DayOffServiceImpl
 * @Description TODO
 * @createTime 2021年03月06日23:14
 */
@Service
public class DayOffServiceImpl implements DayOffService {
    @Resource
    private DayOffMapper dayOffMapper;

    @Override
    public int selectByOpenidAndDate(String openid, String dayOffTime) {
        String newDayOffTime = '%'+dayOffTime+'%';
        return dayOffMapper.selectByOpenidAndDate(openid,newDayOffTime);
    }
}
