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
        return recordMapper.findByOpenidAndDate(openid,checkDate);
    }

    @Override
    public int insertRecord(Record record) {
        return recordMapper.insertRecord(record);
    }

    @Override
    public int selectRecordCountByLabIdAndCheckDate(String labId, String checkDate) {
        return recordMapper.selectRecordCountByLabIdAndCheckDate(labId,checkDate);
    }

    @Override
    public void updateRecordCheckout(String openid, String checkDate, String checkoutTime, String checkoutLocation) {
        recordMapper.updateRecordCheckout(openid,checkDate,checkoutTime,checkoutLocation);
    }

    @Override
    public int insertCalculateRecord(Record record) {
        return recordMapper.insertCalculateRecord(record);
    }

    @Override
    public List<Record> selectNotCheck(String checkDate) {
        return recordMapper.selectNotCheck(checkDate);
    }

    @Override
    public void updateRecordStatus(String openid, String checkDate, String status) {
        recordMapper.updateRecordStatus(openid,checkDate,status);
    }
}
