package ltd.syskaoqin.springboot.service.impl;

import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.dao.mapper.StudentMapper;
import ltd.syskaoqin.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
