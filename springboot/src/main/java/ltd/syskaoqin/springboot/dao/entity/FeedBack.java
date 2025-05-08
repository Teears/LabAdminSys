package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName FeedBack
 * @Description TODO
 * @createTime 2021年03月22日22:45
 */
@Data
public class FeedBack {
    private String id;
    private String openid;
    private String content;
    private String createTime;
}
