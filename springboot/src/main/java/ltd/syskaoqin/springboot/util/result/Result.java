package ltd.syskaoqin.springboot.util.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果的实体
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private int statusCode;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 返回的数据体
     */
    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}