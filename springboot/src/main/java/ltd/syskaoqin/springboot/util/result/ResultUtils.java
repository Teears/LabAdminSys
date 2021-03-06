package ltd.syskaoqin.springboot.util.result;

public class ResultUtils {
    /**
     * 成功时生成result的方法,有返回数据
     */
    public static <T> Result<T> success(T t){
        Result<T> result = new Result<>();
        result.setStatusCode(ResultEnum.SUCCESS.getStatusCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(t);
        return result;
    }

    /**
     * 成功时生成result的方法,无返回数据
     */
    public static <T> Result<T> success(){
        return success(null);
    }

    /**
     * 失败时生成result的方法
     */
    public static <T> Result<T> error(int code, String msg){
        Result<T> result = new Result<>();
        result.setStatusCode(code);
        result.setMsg(msg);
        return result;
    }
}
