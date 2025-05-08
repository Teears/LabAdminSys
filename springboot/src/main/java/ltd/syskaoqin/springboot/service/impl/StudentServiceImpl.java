package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.dao.mapper.StudentMapper;
import ltd.syskaoqin.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @createTime 2021年02月25日21:49
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByStuNumber(String stuNumber) {
        return studentMapper.findStudentByStuNumber(stuNumber);
    }

    @Override
    public Student findStudentByOpenid(String openid) {
        return studentMapper.findStudentByOpenid(openid);
    }

    @Override
    public int deleteStudent(String stuNum) {
        return studentMapper.deleteStudent(stuNum);
    }

    @Override
    public List<Map<String, String>> getAllStudentList() {
        return studentMapper.getAllStudentList();
    }

    @Override
    public List<Map<String, String>> getStudentListByContent(String content) {
        return studentMapper.getStudentListByContent(content);
    }

    @Override
    public Map<String, String> checkStudent(String num) {
        return studentMapper.checkStudent(num);
    }

    @Override
    public Student findStudentInSys(String num) {
        return studentMapper.findStudentInSys(num);
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }
}
