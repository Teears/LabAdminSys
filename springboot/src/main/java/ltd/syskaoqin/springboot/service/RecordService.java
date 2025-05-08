package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Record;

import java.util.List;
import java.util.Map;

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
    int selectRecordCountByLabIdAndCheckDate(String labId, String checkDate);

    /**
     * 签退更新
     * @param openid openid
     * @param checkDate 当日
     * @param checkoutTime 签退时间
     * @param checkoutLocation 签退定位
     */
    void updateRecordCheckout(String openid, String checkDate, String checkoutTime, String checkoutLocation);

    /**
     * 清理请假和缺席的
     * @param record
     * @return
     */
    int insertCalculateRecord(Record record);

    /**
     * 找到为签到的
     * @param checkDate
     * @return
     */
    List<Record> selectNotCheck(String checkDate);

    /**
     * 根据主键更新签到状态
     * @param openid openid
     * @param checkDate checkDate yyyy-MM-dd
     * @param status 0到勤(正常签到正常签退)，1缺席（未签到未签退），2迟到（未签到正常签退），3未签退（正常签到未签退），4请假
     */
    void updateRecordStatus(String openid, String checkDate, String status);

    /**
     * 获取某人到目前为止的签到情况
     * @param openid
     * @return
     */
    List<Map<String,Integer>> selectOnesStatus(String openid);

    /**
     * 计算某个学生的到勤率
     * @param openid
     * @return
     */
    Double calculateFinishRate(String openid);

    /**
     * 查询该学生在所有学生中的到勤率排行
     * @param openid
     * @param labId
     * @return
     */
    int calculateSurpass(String openid, String labId);

    /**
     * 获取某月的签到记录，但只提取date、status
     * @param currentMonth
     * @param currentYear
     * @param openid
     * @return
     */
    List<Map<String,Integer>> findDaysInfo(String currentMonth,String currentYear,String openid);

    /**
     * 获取某天某个实验室签到、签退、既签到又签退的数量
     * @param labId 实验室编号
     * @param checkDate 签到日期
     * @return checkin checkout both
     */
    Map<String,Integer> checkinCheckoutBoth(String labId, String checkDate);

    /**
     * 获取某个实验室当天的签到列表
     * @param labId labId
     * @param checkDate checkDate
     * @return List
     */
    List<Map<String,Integer>> getCheckList(String labId,String checkDate);
}
