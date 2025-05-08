package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Student
 * @Description TODO 学生实体类，描述学生的基本信息
 * @createTime 2021年02月18日12:57
 */
@Data
public class Student {
    private String stuNumber;
    private String name;
    private String sex;
    private String phone;
    private String department;
    private String major;
    private String secret;
}
