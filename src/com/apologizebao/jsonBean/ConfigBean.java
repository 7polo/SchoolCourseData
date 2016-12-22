package com.apologizebao.jsonBean;

import java.util.List;

/**
 * Created by apologizebao on 16-12-20.
 */
public class ConfigBean {

    /**
     * config : [{"method":"POST","Referer":"","type":"login","url":"http://jwgl.ahnu.edu.cn/login/check.shtml"},{"method":"GET","Referer":"http://jwgl.ahnu.edu.cn/query/cjquery","type":"grade","url":"http://jwgl.ahnu.edu.cn/query/cjquery/index"},{"method":"GET","Referer":"http://jwgl.ahnu.edu.cn/kcb/main","type":"course","url":"http://jwgl.ahnu.edu.cn/kcb/main"}]
     */
    public List<ConfigEntity> config;

    public class ConfigEntity {
        /**
         * method : POST
         * Referer : 
         * type : login
         * url : http://jwgl.ahnu.edu.cn/login/check.shtml
         */
        public String method;
        public String Referer;
        public String type;
        public String url;
    }
}
