package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 签到时插入一条签到数据
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
    int selectRecordCoundbyLabidAndCheckdate(@Param("labId") String labId, @Param("checkDate") String checkDate);
}
