package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Record;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RecordService
 * @Description TODO
 * @createTime 2021年02月26日16:40
 */
public interface RecordService {

    List<Record> findByOpenid(String openid);

    Record findByOpenidAndDate(String openid, String checkDate);

}
