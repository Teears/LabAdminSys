package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName LabMapper
 * @Description TODO Lab映射Mapper
 * @createTime 2021年02月26日14:32
 */
@Mapper
public interface LabMapper {

    /**
     * 查找该用户目前关联的实验室，查找过程中只筛选user_lab中status=1的数据
     * @param openid openid
     * @return 返回实验室
     */
    Lab findLabByStuOpenid(@Param("openid") String openid);

    /**
     * 通过labId查找Lab
     * @param labId labId
     * @return Lab
     */
    Lab findLabByLabId(@Param("labId") String labId);

    /**
     * 获取教师所管理的实验室
     * @param openid openid
     * @return Lab
     */
    List<Lab> findLabByTeaOpenid(@Param("openid") String openid);

    /**
     * 计算某个实验室的学生人数
     * @param labId
     * @return
     */
    int countStuInLab(@Param("labId") String labId);

    /**
     * 设置实验室签到签退时间
     * @param labId 实验室编号
     * @param checkin1 签到开始时间
     * @param checkin2 签到结束时间
     * @param checkout1 签退开始时间
     * @param checkout2 签退结束时间
     */
    void updateCheckTime(@Param("labId") String labId,@Param("checkin1") String checkin1,
                         @Param("checkin2") String checkin2, @Param("checkout1") String checkout1,
                         @Param("checkout2") String checkout2);

    /**
     * 更新实验室基本信息
     * @param labId 实验室id
     * @param desc 实验室介绍
     * @param rule 实验室守则
     * @param picUrl 图片地址
     */
    void updateLabInfo(@Param("labId") String labId,@Param("desc") String desc,
                       @Param("rule") String rule,@Param("picUrl") String picUrl);
    /**
     * 获取某个实验室的学生列表
     * @param labId labId
     * @return List<openid>
     */
    List<String> findStuListInLab(@Param("labId") String labId);

    /**
     * 获取教师所管理实验室
     * @param openid
     * @return
     */
    List<Map<String,String>> selectTeaLab(@Param("openid") String openid);

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
    List<Map<String,String>> getLabListByContent(@Param("content") String content);

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
    void deleteLab(@Param("id") String id);
}
