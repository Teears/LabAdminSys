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
    void updateCheckTime(@Param("labId") String labId,@Param("checkin1") String checkin1,@Param("checkin2") String checkin2,
                         @Param("checkout1") String checkout1,@Param("checkout2") String checkout2);
}
