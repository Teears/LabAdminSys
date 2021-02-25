package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Student;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentService
 * @Description TODO
 * @createTime 2021年02月25日21:48
 */
public interface StudentService {

    Student findStudentByStuNumber(String stuNumber);
}
