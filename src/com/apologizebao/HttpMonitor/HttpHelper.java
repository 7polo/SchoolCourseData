package com.apologizebao.HttpMonitor;

import com.apologizebao.school.AbstractSchool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by apologizebao on 16-12-20.
 * 该类完成Http请求动作
 */

public class HttpHelper {

    public static final int CMD_LOGIN = 0x77;
    public static final int CMD_QUERY_GRADE = 0x78;
    public static final int CMD_QUERY_COURSE = 0x79;

    private String cookie = "";
    //
    private URL url;
    private HttpURLConnection httpURLConnection;
    private OutputStream outputStream;
    private StringBuffer stringBuffer;


    /**
     * 完成一些成员变量的初始化动作，只在该类实例化时调用
     */
    public void init() {
        if (stringBuffer == null)
            stringBuffer = new StringBuffer();
        stringBuffer.delete(0, stringBuffer.length());
    }

    /**
     * @param school
     * @return 返回查询对象
     */
    public Object doService(AbstractSchool school) throws Exception {
        init();
        school.loadConfig(school.getCmd());

        String param = school.getParam();
        String Referer = school.getReferer();
        if (school.getMethod().equals("GET")) {
            url = new URL(school.getURL() + "?" + param);
        } else url = new URL(school.getURL());
        httpURLConnection = (HttpURLConnection) this.url.openConnection();
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(8000);
        httpURLConnection.setRequestMethod(school.getMethod());
        httpURLConnection.setRequestProperty("User-Agent", " Mozilla/5.0 (X11; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpURLConnection.setRequestProperty("Connection", "keep-alive");

        if (cookie != null && cookie.length() > 0)
            httpURLConnection.setRequestProperty("Cookie", cookie);

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);

        //写入Referer
        if (Referer != null && !Referer.trim().equals("")) {
            httpURLConnection.setRequestProperty("Referer", school.getReferer());
        }

        //开始连接
        outputStream = httpURLConnection.getOutputStream();
        if (school.getMethod().equals("POST"))
            outputStream.write(param.getBytes());
        outputStream.flush();
        outputStream.close();
        if (httpURLConnection.getResponseCode() == 200) {

            String readLine = new String();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((readLine = responseReader.readLine()) != null) {
                stringBuffer.append(readLine).append("\n");
            }
            responseReader.close();
        }

        //设置cookie，解决认证问题
        if (cookie == null || cookie.length() == 0) {
            setCookie(httpURLConnection.getHeaderFields());
        }
        
        //将得到的html页面发给school去解析
        return school.paresrHtml(school.getCmd(), stringBuffer.toString());
    }

    /**
     * 获取html头中的 cookie信息
     * @param map html 信息header部分
     */
    private void setCookie(Map<String, List<String>> map) {
        Set set = map.keySet();
        Iterator<String> iterator = set.iterator(); //迭代Set集合
        while (iterator.hasNext()) {
            String filed = iterator.next();
            if (filed != null && filed.equals("Set-Cookie")) {
                List<String> list = map.get(filed);
                for (String s : list) {
                    cookie += s + ";";
                }
                cookie.substring(0, cookie.length() - 2);
                break;
            }
        }
    }

    /**
     * 一些参数的重置动作
     */
    public void reset() {
        //TODO 

    }

}
