package ltd.syskaoqin.springboot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.dao.entity.DayOff;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    /**
     * 获取某个学生的请假记录
     * @param openid
     * @return
     */
    List<DayOff> selectFormatDayOffList(String openid);

    /**
     * 添加一条请假信息
     * @param dayOff
     */
    void insertDayOff(DayOff dayOff);
}

