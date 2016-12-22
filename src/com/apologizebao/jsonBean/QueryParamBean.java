package com.apologizebao.jsonBean;

import java.util.List;

/**
 * Created by apologizebao on 16-12-20.
 */
public class QueryParamBean {

    /**
     * loginParames : [{"value":"","key":"user"},{"value":"","key":"pass"},{"value":"","key":"usertype"}]
     * gradeParames : [{"value":"ok","key":"action"},{"value":"0000-0000","key":"xkxn"},{"value":"0","key":"xkxq"}]
     * courseParames : [{"value":"ok","key":"action"},{"value":"0000-0000","key":"xkxn"},{"value":"0","key":"xkxq"}]
     */
    public List<ParamesEntity> loginParames;
    public List<ParamesEntity> gradeParames;
    public List<ParamesEntity> courseParames;

    public class ParamesEntity {
        /**
         * value : 
         * key : user
         */
        public String value;
        public String key;

        @Override
        public String toString() {
            return "ParamesEntity{" +
                    "value='" + value + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }
}
