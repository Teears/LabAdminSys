package ltd.syskaoqin.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName getOpenid
 * @Description TODO
 * @createTime 2021年02月18日14:53
 */
public class WechatUtil {

    private static String appid = "wxf0b3f4d6592571a9";
    private static String appsecret = "4153df76de8f96ea71cd951263504f1b";
    private static String code2Session = "https://api.weixin.qq.com/sns/jscode2session";

    public static String getOpenid(String code){

        String url = code2Session;
        url += "?appid="+ appid;
        url += "&secret="+ appsecret;
        url += "&js_code="+code;
        url += "&grant_type=authorization_code&connect_redirect=1&useSSL=false";
        System.out.println(url);
        String res = HttpUtil.httpRequest(url,"GET", null);
        JSONObject resJson = JSON.parseObject(res);
        System.out.println(resJson.getString("openid"));
        return resJson.getString("openid");
    }

}
