package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Lab;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabService
 * @Description TODO 实验室相关操作
 * @createTime 2021年02月26日14:33
 */
public interface LabService {

    /**
     * 获取学生用户目前关联的实验室
     * @param openid openid
     * @return 实验室对象列表
     */
    Lab findLabByStuOpenid(String openid);

    /**
     * 通过labId查找Lab
     * @param labId labId
     * @return Lab
     */
    Lab findLabByLabId(String labId);

    /**
     * 获取教师所管理的实验室
     * @param openid openid
     * @return Lab
     */
    List<Lab> findLabByTeaOpenid(String openid);

    /**
     * 计算某个实验室的学生人数
     * @param labId
     * @return
     */
    int countStuInLab(String labId);

    /**
     * 设置实验室签到签退时间
     * @param labId 实验室编号
     * @param checkin1 签到开始时间
     * @param checkin2 签到结束时间
     * @param checkout1 签退开始时间
     * @param checkout2 签退结束时间
     */
    void updateCheckTime(String labId,String checkin1,String checkin2, String checkout1,String checkout2);
}
