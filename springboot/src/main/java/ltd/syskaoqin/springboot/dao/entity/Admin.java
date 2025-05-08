package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/10日18:41
 */
@Data
public class Admin {
    private String userNumber;
    private String roleId;
    private String appointTime;
    private String password;
}
