package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Record;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName RecordMapper
 * @Description 学生签到操作
 * @createTime 2021年02月26日16:12
 */
@Mapper
public interface RecordMapper {

    /**
     * 查找学生所有签到
     * @param openid 签到用户
     * @return 签到列表
     */
    List<Record> findByOpenid(@Param("openid") String openid);

    /**
     * 学生今日签到数据
     * @param openid 签到用户
     * @param checkDate 签到日期
     * @return 返回null说明还没签到
     */
    Record findByOpenidAndDate(@Param("openid") String openid,@Param("checkDate") String checkDate);

    /**
     * 签到时插入一条签到数据，可能是在签到时插入也可能是在签退时插入
     * @param record 插入record
     * @return 插入影响行数
     */
    int insertRecord(Record record);

    /**
     * 签到排名
     * @param labId 实验室无意义序列
     * @param checkDate 签到Date
     * @return 签到人数
     */
    int selectRecordCountByLabIdAndCheckDate(@Param("labId") String labId, @Param("checkDate") String checkDate);

    /**
     * 签退更新
     * @param openid openid
     * @param checkDate 当日
     * @param checkoutTime 签退时间
     * @param checkoutLocation 签退定位
     */
    void updateRecordCheckout(@Param("openid") String openid, @Param("checkDate")  String checkDate, @Param("checkoutTime") String checkoutTime,@Param("checkoutLocation") String checkoutLocation);

    /**
     * 插入缺少的数据，缺席或请假的
     * @param record
     * @return
     */
    int insertCalculateRecord(Record record);

    /**
     * 查询出今日未签到的人
     * @param checkDate
     * @return
     */
    List<Record> selectNotCheck(@Param("checkDate") String checkDate);

    /**
     * 根据主键更新签到状态
     * @param openid openid
     * @param checkDate checkDate yyyy-MM-dd
     * @param status 0到勤(正常签到正常签退)，1缺席（未签到未签退），2迟到（未签到正常签退），3未签退（正常签到未签退），4请假
     */
    void updateRecordStatus(@Param("openid") String openid, @Param("checkDate") String checkDate, @Param("status") String status);

    /**
     * 获取某人到目前为止的签到情况
     * @param openid
     * @return
     */
    List<Map<String,Integer>> selectOnesStatus(@Param("openid") String openid);

    /**
     * 计算某个学生的到勤率
     * @param openid
     * @return
     */
    Double calculateFinishRate(@Param("openid") String openid);

    /**
     * 查询该学生在所有学生中的到勤率排行
     * @param openid
     * @param labId
     * @return
     */
    int calculateSurpass(@Param("openid") String openid, @Param("labId") String labId);

    /**
     * 获取某月的签到记录，但只提取date、status
     * @param yearMonthStr
     * @param openid
     * @return
     */
    List<Map<String,Integer>> findDaysInfo(@Param("yearMonthStr") String yearMonthStr,@Param("openid") String openid);

    /**
     * 获取某天某个实验室签到、签退、既签到又签退的数量
     * @param labId labid
     * @param checkDate checkDate
     * @return checkin checkout both
     */
    Map<String,Integer> checkinCheckoutBoth(@Param("labId") String labId, @Param("checkDate") String checkDate);

    /**
     * 获取某个实验室当天的签到列表
     * @param labId labId
     * @param checkDate checkDate
     * @return List
     */
    List<Map<String,Integer>> getCheckList(@Param("labId") String labId,@Param("checkDate") String checkDate);
}
