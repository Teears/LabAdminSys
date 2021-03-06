package ltd.syskaoqin.springboot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
