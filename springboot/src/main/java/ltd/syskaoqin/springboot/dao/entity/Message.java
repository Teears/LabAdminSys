package ltd.syskaoqin.springboot.dao.entity;

import lombok.Data;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName Message
 * @Description TODO
 * @createTime 2021年03月22日14:19
 */
@Data
public class Message {
    private String id;
    private String sendId;
    private String labId;
    private String title;
    private String content;
    private String type;
    private String createTime;
}
