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

    /**
     * 更新实验室基本信息
     * @param labId 实验室id
     * @param desc 实验室介绍
     * @param rule 实验室守则
     * @param picUrl 图片地址
     */
    void updateLabInfo(String labId, String desc,String rule,String picUrl);

    /**
     * 获取某个实验室的学生列表
     * @param labId labId
     * @return List<openid>
     */
    List<String> findStuListInLab(String labId);

    /**
     * 获取教师所管理实验室
     * @param openid
     * @return
     */
    List<Map<String,String>> selectTeaLab(String openid);

    /**
     * 获取所有lab列表
     * @return
     */
    List<Map<String,String>> getAllLabList();

    /**
     * 通过lab_number和name模糊查询
     * @param content
     * @return
     */
    List<Map<String,String>> getLabListByContent(String content);

    /**
     * 管理员更新Lab
     * @param lab
     */
    void updateLabAdminInfo(Lab lab);

    /**
     * 管理员添加Lab
     * @param lab
     */
    void addLab(Lab lab);

    /**
     * 删除
     * @param id
     */
    void deleteLab(String id);
}
