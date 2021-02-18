package ltd.syskaoqin.springboot.util.result;

public enum ResultEnum {

    UNKNOWN_ERROR(-200, "未知错误"),
    SUCCESS(200, "成功"),
    BASIC_INFO_ID_IS_EMPTY(600, "基本信息中BasicInfoId为空"),
    BASIC_INFO_ADD_TO_DATABASE_FAILURE(601, "向数据库添加基本信息失败"),
    DETAILS_DATA_BASIC_INFO_ID_IS_EMPTY(602, "测试数据中BasicInfoId为空"),
    DETAILS_DATA_ADD_TO_DATABASE_FAILURE(603, "向数据库添加测试数据失败");

    ResultEnum(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    private int statusCode;

    private String msg;

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

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code=" + statusCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}