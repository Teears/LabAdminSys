package ltd.syskaoqin.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import ltd.syskaoqin.springboot.config.InitGlobalData;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName getOpenid
 * @Description TODO 微信工具类
 * @createTime 2021年02月18日14:53
 */
public class WechatUtil {

    public static JSONObject getOpenid(String code){
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
        return resJson;
    }

}
