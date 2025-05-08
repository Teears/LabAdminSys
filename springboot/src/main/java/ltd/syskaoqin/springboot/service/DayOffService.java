package ltd.syskaoqin.springboot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.dao.entity.DayOff;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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

    /**
     * 教师获取学生请假列表
     * @param openid 教师openid
     * @return
     */
    List<Map<String,String>> findTeaDayOffList(String openid);

    /**
     * 教师批准请假
     * @param openid openid
     * @param id id
     */
    void setAgree(String openid,String id);

    /**
     * 教师拒绝请假
     * @param openid openid
     * @param id id
     */
    void setRefuse(String openid,String id);

    /**
     * 教师撤回请假
     * @param openid openid
     * @param id id
     */
    void setReverse(String openid,String id);
}

