package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Role
 * @Description TODO 角色实体类，shiro用
 * @createTime 2021年02月23日10:59
 */
@Data
public class Role {
    private String id;
    private String name;
    private String desc;
    private String status;
}
