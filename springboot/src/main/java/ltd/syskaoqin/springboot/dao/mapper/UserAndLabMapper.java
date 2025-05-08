package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserAndLabMapper
 * @Description TODO
 * @createTime 2021年03月07日14:03
 */
@Mapper
public interface UserAndLabMapper {
    /**
     * 获取学生当前加入的实验室
     * @param openid openid
     * @return 当前加入的实验室以及加入时间等
     */
    UserAndLab selectByStuOpenid(@Param("openid") String openid);


    /**
     * 获取加入这个实验室的学生人数，需要减去一个教师人数
     * @param labId
     * @return
     */
    int calculateLabTotal(@Param("labId") String labId);

    /**
     * 添加学生的绑定信息
     * @param userAndLab
     */
    void insertUserLab(UserAndLab userAndLab);

    /**
     * 删除学生和实验的绑定关系
     * @param stuNumber
     */
    void deleteByStuNumber(@Param("stuNumber") String stuNumber);

    /**
     * 学生绑定时确认所在实验
     * @param openid
     */
    void updateOpenid(@Param("openid") String openid,@Param("stuNumber") String stuNumber);

    /**
     * 添加教师的绑定信息
     * @param userAndLab
     */
    void insertUserLabTea(UserAndLab userAndLab) throws DuplicateKeyException;

    /**
     * 删除教师和实验的绑定关系
     * @param teaNumber
     * @param labId
     */
    void deleteByTeaNumber(@Param("teaNumber") String teaNumber,@Param("labId") String labId);

    /**
     * 教师绑定时确认所在实验
     * @param openid
     * @param teaNumber
     */
    void updateTeaOpenid(@Param("openid") String openid,@Param("teaNumber") String teaNumber);

    /**
     * 通过teaNumber查找对应关系
     * @param teaNumber
     * @return
     */
    List<UserAndLab> findByTeaNumber(@Param("teaNumber") String teaNumber);
}
