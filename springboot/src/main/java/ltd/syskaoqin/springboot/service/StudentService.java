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
}
