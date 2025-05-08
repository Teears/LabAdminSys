package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherService
 * @Description TODO
 * @createTime 2021年03月21日22:03
 */
public interface TeacherService {

    /**
     * 获取某个实验室的负责老师
     * @param labId
     * @return
     */
    Teacher findTeacherByLabId(String labId);

    /**
     * 通过工号查找教师
     * @param teaNumber teaNumber
     * @return teacher
     */
    Teacher findTeacherByTeaNumber(String teaNumber);

    /**
     * 获取教师Name作为补充
     * @param openid openid
     * @return name
     */
    Map<String,String> findTeaName(String openid);

    /**
     * 获取教师个人信息
     * @param openid openid
     * @return
     */
    Map<String,Object> findTeaInfo(String openid);

    /**
     * 管理员获取所有教师列表
     * @return
     */
    List<Map<String,String>> getAllTeacherList();

    /**
     * 管理员根据content搜索教师列表
     * @param content 搜索条件 姓名和学号模糊搜索
     * @return
     */
    List<Map<String,String>> getTeacherListByContent(String content);

    /**
     * 检查教师，teacher_sys表中存在teacher表中不存在的方可添加
     * @param num
     * @param labId
     * @return
     */
    Map<String,String> checkTeacher(String num,String labId);

    /**
     * 向teacher表中添加数据，添加的数据来自于teacher_sys
     * @param teacher teacher
     */
    void insertTeacher(Teacher teacher);

    /**
     * 从teacher_sys中查找Teacher
     * @param num
     * @return
     */
    Teacher findTeacherInSys(String num);

    /**
     * 删除
     * @param num 工号
     */
    void deleteTeacher(String num);

}
