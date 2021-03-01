package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Record;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RecordService
 * @Description TODO 学生签到记录
 * @createTime 2021年02月26日16:40
 */
public interface RecordService {
    /**
     * 获取某学生的所有签到记录，包括已退出的实验室
     * @param openid openid
     * @return 签到记录列表
     */
    List<Record> findByOpenid(String openid);

    /**
     * 获取该学生今天的签到记录，只有一条
     * @param openid openid
     * @param checkDate 当前时间yyyy-MM-dd
     * @return 今日签到记录
     */
    Record findByOpenidAndDate(String openid, String checkDate);

    /**
     * 签到
     * @param record 包括openid,labId,checkinLocation,nowDate,noeTime
     * @return 返回1则签到成功
     */
    int insertRecord(Record record);

    /**
     * 签到名次，同一实验室同一天内当前已有的签到条数
     * @param labId 实验自增id
     * @param checkDate 当前日期
     * @return 已签到数
     */
    int selectRecordCoundbyLabidAndCheckdate(String labId, String checkDate);

}
