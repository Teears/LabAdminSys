package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Student;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentService
 * @Description TODO 学生服务层
 * @createTime 2021年02月25日21:48
 */
public interface StudentService {

    /**
     * 通过学生学号查找学生
     * @param stuNumber 学生学号
     * @return Student
     */
    Student findStudentByStuNumber(String stuNumber);

    /**
     * 通过openid找到学生基本信息
     * @param openid openid
     * @return Student
     */
    Student findStudentByOpenid(String openid);

    /**
     * 通过学号删除学生，在学生退出实验室时调用
     * @param stuNum
     * @return
     */
    int deleteStudent(String stuNum);

}
