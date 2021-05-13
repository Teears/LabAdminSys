package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherMapper
 * @Description TODO 教师Mapper
 * @createTime 2021年03月21日22:00
 */
@Mapper
public interface TeacherMapper {

    /**
     * 获取某个实验室的负责老师
     * @param labId labId
     * @return Teacher
     */
    Teacher findTeacherByLabId(@Param("labId") String labId);

    /**
     * 通过工号查找教师
     * @param teaNumber teaNumber
     * @return teacher
     */
    Teacher findTeacherByTeaNumber(@Param("teaNumber") String teaNumber);

    /**
     * 获取教师Name作为补充
     * @param openid openid
     * @return name
     */
    Map<String,String> findTeaName(@Param("openid") String openid);

    /**
     * 获取教师个人信息
     * @param openid openid
     * @return
     */
    Map<String,Object> findTeaInfo(@Param("openid") String openid);

    /**
     * 获取所有教师列表
     * @return
     */
    List<Map<String,String>> getAllTeacherList();

    /**
     * 根据content搜索教师列表
     * @param content 搜索条件 姓名和学号模糊搜索
     * @return
     */
    List<Map<String,String>> getTeacherListByContent(@Param("content") String content);

    /**
     * 检查教师，teacher_sys表中存在teacher表中不存在的方可添加
     * @param num
     * @param labId
     * @return
     */
    Map<String,String> checkTeacher(@Param("num") String num,@Param("labId") String labId);

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
    Teacher findTeacherInSys(@Param("num") String num);

    /**
     * 删除
     * @param num 工号
     */
    void deleteTeacher(@Param("num") String num);
}
