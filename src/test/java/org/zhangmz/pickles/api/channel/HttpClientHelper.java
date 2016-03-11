/**
 * 
 */
package org.zhangmz.pickles.api.channel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.zhangmz.pickles.modules.convert.JsonMapper;
import org.zhangmz.pickles.modules.vo.SimpleResponse;

/**
 * @ClassName:HttpClientHelper.java
 * @Description:
 * @author:张孟志
 * @date:2016年3月11日下午8:32:36
 * @version V1.0
 * 说明：封装一般的HTTP请求
 */
public class HttpClientHelper {
	static JsonMapper binder = JsonMapper.nonDefaultMapper();

	public static SimpleResponse doPost(String url, List<NameValuePair> formparams) {
		SimpleResponse simpleResponse = null;
		// 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost ?groupCode=nogroup&phone=13000000007&password=password
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    String rtnString = EntityUtils.toString(entity, "UTF-8");
                    System.out.println("Response content: " + rtnString);  
                    System.out.println("--------------------------------------");
                    simpleResponse = binder.fromJson(rtnString, SimpleResponse.class);                    
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        
        return simpleResponse;
	};
}
