package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName UserAndLab
 * @Description TODO
 * @createTime 2021年03月07日14:02
 */
@Data
public class UserAndLab {
    private String id;
    private String openid;
    private String stuNumber;
    private String labId;
    private String createTime;
    private String status;
}
