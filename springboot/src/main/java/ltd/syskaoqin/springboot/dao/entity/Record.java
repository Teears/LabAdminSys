package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Record
 * @Description TODO 签到记录实体类
 * @createTime 2021年02月18日13:22
 */
@Data
public class Record {
    private String openid;
    private String labId;
    private String checkDate;
    private String checkinTime;
    private String checkoutTime;
    private String checkinLocation;
    private String checkoutLocation;
    private String status;
}
