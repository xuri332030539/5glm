package com.st.smartsecurity.util.qichacha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpHead;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * 企查查UTIL
 * @author xuri
 *@date 2019/12/27
 */
@Service
public class QichachaUtil {
    private static final String appkey = "ba42a3d305db46d2b7a13937f800d9bf";
    private static final String seckey = "E7C73509B610FF1576084DD17CFE4E36";

    public String qichachaCheck(String reqInterNme,String paramStr){
        String status = "";
        String tokenJson="";
        try {
            // auth header setting
            HttpHead reqHeader = new HttpHead();
            String[] autherHeader = RandomAuthentHeader();
            reqHeader.setHeader("Token", autherHeader[0]);
            reqHeader.setHeader("Timespan", autherHeader[1]);
            final String reqUri = reqInterNme.concat("?key=").concat(appkey).concat("&").concat(paramStr);
            tokenJson = HttpHelper.httpGet(reqUri, reqHeader.getAllHeaders());
//            out.println(String.format("==========================>this is response:{%s}", tokenJson));
            // parse status from json
            status = FormartJson(tokenJson, "Status");
//            out.println(String.format("==========================>Status:{%s}", status));
//            if (!HttpCodeRegex.isAbnornalRequest(status)) {
//                PrettyPrintJson(tokenJson);
//            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return tokenJson;
    }

    // 获取返回码 Res Code
    static class HttpCodeRegex {
        private static final String ABNORMAL_REGIX = "(101)|(102)";
        private static final Pattern pattern = Pattern.compile(ABNORMAL_REGIX);
        protected static boolean isAbnornalRequest(final String status) {
            return pattern.matcher(status).matches();
        }
    }

    // 获取Auth Code
    protected static final String[] RandomAuthentHeader() {
        String timeSpan = String.valueOf(System.currentTimeMillis() / 1000);
        String[] authentHeaders = new String[] { DigestUtils.md5Hex(appkey.concat(timeSpan).concat(seckey)).toUpperCase(), timeSpan };
        return authentHeaders;
    }

    // 解析JSON
    public static String FormartJson(String jsonString, String key) throws JSONException {
        JSONObject jObject = new JSONObject(jsonString);
        return (String) jObject.get(key);
    }

    // pretty print 返回值
    protected static void PrettyPrintJson(String jsonString) throws JSONException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(jsonString, Object.class);
            String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            out.println(indented);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
