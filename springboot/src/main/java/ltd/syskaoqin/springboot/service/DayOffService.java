package ltd.syskaoqin.springboot.service;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName DayOffService
 * @Description TODO
 * @createTime 2021年03月06日23:13
 */
public interface DayOffService {
    /**
     * 某学生在某天是否有请假
     * @param openid openid
     * @param dayOffTime yyyy_MM_dd dayoff_time的子串
     * @return 查询结果条数
     */
    int selectByOpenidAndDate(String openid, String dayOffTime);

}
