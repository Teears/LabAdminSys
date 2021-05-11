package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.DayOff;
import ltd.syskaoqin.springboot.dao.mapper.DayOffMapper;
import ltd.syskaoqin.springboot.service.DayOffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<DayOff> selectFormatDayOffList(String openid) {
        return dayOffMapper.selectDayOffListByOpenid(openid);
    }

    @Override
    public void insertDayOff(DayOff dayOff) {
        dayOffMapper.insertDayOff(dayOff);
    }

    @Override
    public List<Map<String, String>> findTeaDayOffList(String openid) {
        return dayOffMapper.findTeaDayOffList(openid);
    }

    @Override
    public void setAgree(String openid, String id) {
        dayOffMapper.setAgree(openid,id);
    }

    @Override
    public void setRefuse(String openid, String id) {
        dayOffMapper.setRefuse(openid,id);
    }

    @Override
    public void setReverse(String openid, String id) {
        dayOffMapper.setReverse(openid,id);
    }
}
