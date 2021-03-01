package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Record;
import ltd.syskaoqin.springboot.dao.mapper.RecordMapper;
import ltd.syskaoqin.springboot.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RecordService
 * @Description TODO
 * @createTime 2021年02月26日16:39
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordMapper recordMapper;

    @Override
    public List<Record> findByOpenid(String openid) {
        return recordMapper.findByOpenid(openid);
    }

    @Override
    public Record findByOpenidAndDate(String openid, String checkDate) {
        return null;
    }
}
