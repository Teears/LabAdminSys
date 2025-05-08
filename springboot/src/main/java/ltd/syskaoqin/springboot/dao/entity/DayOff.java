package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Dayoff
 * @Description TODO
 * @createTime 2021年03月06日23:00
 */
@Data
public class DayOff {
    private String id;
    private String openid;
    private String isPass;
    private String dayOffTime;
    private String passId;
    private String contact;
    private String reason;
    private String type;
    private String applyTime;
    private String passTime;
}
