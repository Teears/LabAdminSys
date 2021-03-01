package ltd.syskaoqin.springboot.dao.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName User
 * @Description TODO 微信小程序端用户实体类，主要用于验证登录
 * @createTime 2021年02月18日12:48
 */

@Data
public class User {
    private String id;
    private String openid;
    private String nickname;
    private String avatarUrl;
    private String phone;
    private String bindId;
    private String roleId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String latestTime;
}
