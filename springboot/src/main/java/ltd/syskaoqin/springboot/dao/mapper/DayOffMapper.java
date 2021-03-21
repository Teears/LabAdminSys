package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.DayOff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName DayOffMapper
 * @Description TODO
 * @createTime 2021年03月06日23:07
 */
@Mapper
public interface DayOffMapper {
    /**
     * 某学生在某天是否有请假
     * @param openid openid
     * @param dayOffTime yyyy_MM_dd dayoff_time的子串
     * @return 查询结果条数
     */
    int selectByOpenidAndDate(@Param("openid") String openid, @Param("dayOffTime") String dayOffTime);

    /**
     * 获取某个学生的请假记录
     * @param openid openid
     * @return 请假记录列表
     */
    List<DayOff> selectDayOffListByOpenid(@Param("openid") String openid);

    /**
     * 添加一条请假信息
     * @param dayOff
     * @throws DuplicateKeyException 主键重复，重复请假
     */
    void insertDayOff(DayOff dayOff)  throws DuplicateKeyException;
}
