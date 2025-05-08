package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Lab
 * @Description TODO 实验室实体类，描述一个实验室的位置信息，基本描述，开放关闭时间和管理规定
 * @createTime 2021年02月18日13:00
 */
@Data
public class Lab {
    private String id;
    private String labNumber;
    private String name;
    private String room;
    private String address;
    private String seat;
    private String openTime;
    private String closeTime;
    private String checkinStart;
    private String checkinEnd;
    private String checkoutStart;
    private String checkoutEnd;
    private String basicDesc;
    private String picUrl;
    private String ruleDesc;
    private String reviseTime;
}
