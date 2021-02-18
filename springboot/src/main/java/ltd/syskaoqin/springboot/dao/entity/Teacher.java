package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Teacher
 * @Description 教师实体类，描述了教师的基本信息
 * @createTime 2021年02月18日12:50
 */
@Data
public class Teacher {
    private String id;
    private String teaNumber;
    private String name;
    private String sex;
    private String phone;
    private String secret;
}
