package com.apologizebao.parser;

/**
 * Created by apologizebao on 16-12-20.
 */

import com.apologizebao.HttpMonitor.HttpHelper;
import com.apologizebao.jsonBean.ConfigBean;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 特定请求信息配置类
 */
public class ConfigHelper {
    private String URL;
    private String Referer;
    private String method="";
    protected String param="";
    protected File configFile;
    private ConfigBean jsonbean;
    private int cmd = 0;

    public ConfigHelper()  {
    }
    
    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public void setFile(File path){
        this.configFile = path; //配置文件路径
    }
    
    /**
     * 从配置文件读取
     * 根据参数的不同载入不同的信息给字段
     *
     * @param cmd
     */
    public void loadConfig(int cmd) throws FileNotFoundException {
        //TODO 从配置文件读取信息
        //根据实际更改此处路径
        String type = ""; //匹配的类型 login grade course
        switch (cmd) {
            case HttpHelper.CMD_LOGIN:
                type = "login";
                break;
            case HttpHelper.CMD_QUERY_COURSE:
                type = "course";
                break;
            case HttpHelper.CMD_QUERY_GRADE:
                type = "grade";
                break;
        }
        Gson gson = new Gson();
        try {
            jsonbean = gson.fromJson(new FileReader(configFile), ConfigBean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (jsonbean != null && jsonbean.config != null) {
            for (ConfigBean.ConfigEntity entity : jsonbean.config) {
                if (entity.type.equals(type)){
                    this.URL = entity.url;
                    this.method = entity.method;
                    this.Referer = entity.Referer;
                }
            }
        }
    }
    
    public ConfigHelper(String URL, String referer, String method, String param) {
        this.URL = URL;
        Referer = referer;
        this.method = method;
        this.param = param;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setReferer(String referer) {
        Referer = referer;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getURL() {
        return URL;
    }

    public String getReferer() {
        return Referer;
    }

    public String getMethod() {
        return method;
    }

    public String getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "ConfigHelper{" +
                "URL='" + URL + '\'' +
                ", Referer='" + Referer + '\'' +
                ", method='" + method + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
