package ltd.syskaoqin.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.syskaoqin.springboot.config.InitGlobalData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName getOpenid
 * @Description TODO
 * @createTime 2021年02月18日14:53
 */
public class WechatUtil {

    public static String getOpenid(String code){
        String url = InitGlobalData.globalDataMap.get("code2Session");
        String appid = InitGlobalData.globalDataMap.get("appid");
        String appsecret = InitGlobalData.globalDataMap.get("appsecret");
        url += "?appid="+ appid;
        url += "&secret="+ appsecret;
        url += "&js_code="+code;
        url += "&grant_type=authorization_code&connect_redirect=1&useSSL=false";
        System.out.println("url-----"+url);
        String res = HttpUtil.httpRequest(url,"GET", null);
        JSONObject resJson = JSON.parseObject(res);
        System.out.println(resJson.getString("openid"));
        return resJson.getString("openid");
    }

}
