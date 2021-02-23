package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Permission
 * @Description TODO
 * @createTime 2021年02月23日10:56
 */
@Data
public class Permission {
    private String id;
    private String name;
    private String url;
    private String type;
    private String status;
}
