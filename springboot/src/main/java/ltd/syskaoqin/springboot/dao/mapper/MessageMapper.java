package ltd.syskaoqin.springboot.dao.mapper;

import ltd.syskaoqin.springboot.dao.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName MessageMapper
 * @Description TODO Message
 * @createTime 2021年03月22日14:18
 */
@Mapper
public interface MessageMapper {

    /**
     * 学生获取消息列表
     * @param openid openid
     * @param date yyyy-MM-dd 默认展示最近15天内容
     * @return List
     */
    List<Message> stuGetMessageList(@Param("openid") String openid,@Param("date") String date);

    /**
     * 获取某个用户的已读列表
     * @param openid 学生或教师openid
     * @return 已读信息的message_id列表
     */
    List<String> readedList(@Param("openid") String openid);

    /**
     * 已读信息插入到message_tag表中
     * @param openid openid
     * @param messageId id
     */
    void insertMessageTag(@Param("openid") String openid,@Param("messageId") String messageId);

    /**
     * 添加消息
     * @param message
     */
    void insertMessage(Message message);

    /**
     * 获取发送者自己已发布的消息列表
     * @param sendId sendId
     * @return Message
     */
    List<Message> selectMessageBySendId(@Param("sendId") String sendId);
}
