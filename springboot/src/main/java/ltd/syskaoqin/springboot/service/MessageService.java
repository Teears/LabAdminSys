package ltd.syskaoqin.springboot.service;

import ltd.syskaoqin.springboot.dao.entity.Message;

import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName MessageService
 * @Description TODO
 * @createTime 2021年03月22日14:26
 */
public interface MessageService {

    /**
     * 学生获取消息列表
     * @param openid openid
     * @param day 展示近几天内容，默认day=15展示最近15天内容
     * @return List
     */
    List<Message> stuGetMessageList(String openid, int day);

    /**
     * 获取某个用户的已读列表
     * @param openid 学生或教师openid
     * @return 已读信息的message_id列表
     */
    List<String> readedList(String openid);

    /**
     * 已读信息插入到message_tag表中
     * @param openid openid
     * @param messageId id
     */
    void insertMessageTag(String openid,String messageId);

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
    List<Message> selectMessageBySendId(String sendId);
}
