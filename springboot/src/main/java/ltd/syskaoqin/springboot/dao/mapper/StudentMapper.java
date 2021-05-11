package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentMapper
 * @Description TODO 学生Mapper
 * @createTime 2021年02月25日21:46
 */
@Mapper
public interface StudentMapper {
    /**
     * 通过学生学号找到学生
     * @param stuNumber 学生学号
     * @return Student
     */
    Student findStudentByStuNumber(@Param("stuNumber") String stuNumber);

    /**
     * 通过openid找到学生基本信息
     * @param openid openid
     * @return Student
     */
    Student findStudentByOpenid(@Param("openid") String openid);

    /**
     * 通过学号删除学生，在学生退出实验室时调用
     * @param stuNum
     * @return
     */
    int deleteStudent(@Param("stuNum") String stuNum);

    /**
     * 获取所有学生列表
     * @return
     */
    List<Map<String,String>> getAllStudentList();

    /**
     * 根据content搜索学生列表
     * @param content 搜索条件 姓名和学号模糊搜索
     * @return
     */
    List<Map<String,String>> getStudentListByContent(@Param("content") String content);

    /**
     * 检查教师，student_sys表中存在student表中不存在的方可添加
     * @param num stu_number
     * @return
     */
    Map<String,String> checkStudent(@Param("num") String num);

    /**
     * 从student_sys中查找Student
     * @param num
     * @return
     */
    Student findStudentInSys(@Param("num") String num);

    /**
     * 向teacher表中添加数据，添加的数据来自于student_sys
     * @param student  student
     */
    void insertStudent(Student student);

}
