package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserAndLabService
 * @Description TODO 学生和实验室绑定关系
 * @createTime 2021年03月07日14:08
 */
public interface UserAndLabService {

    /**
     * 获取用户当前加入的实验室
     * @param openid openid
     * @return 当前加入的实验室以及加入时间等
     */
    UserAndLab selectByStuOpenid(String openid);

    /**
     * 获取加入这个实验室的学生人数，需要减去一个教师人数
     * @param labId
     * @return
     */
    int calculateLabTotal(String labId);

    /**
     * 添加学生的绑定信息
     * @param userAndLab
     */
    void insertUserLab(UserAndLab userAndLab);

    /**
     * 删除学生和实验的绑定关系
     * @param stuNumber
     */
    void deleteByStuNumber(String stuNumber);

    /**
     * 学生绑定时确认所在实验
     * @param openid
     */
    void updateOpenid(String openid,String stuNumber);

    /**
     * 添加教师的绑定信息
     * @param userAndLab
     */
    void insertUserLabTea(UserAndLab userAndLab);

    /**
     * 删除教师和实验的绑定关系
     * @param teaNumber
     * @param labId
     */
    void deleteByTeaNumber(String teaNumber,String labId);

    /**
     * 教师绑定时确认所在实验
     * @param openid
     * @param teaNumber
     */
    void updateTeaOpenid(String openid,String teaNumber);

    /**
     * 通过teaNumber查找对应关系
     * @param teaNumber
     * @return
     */
    List<UserAndLab> findByTeaNumber(String teaNumber);
}
