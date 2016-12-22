package com.apologizebao.school;

import com.apologizebao.HttpMonitor.HttpHelper;

/**
 * Created by apologizebao on 16-12-22.
 */
public class Main {
    public static void main(String[] agrs) {
        AbstractSchool school = new AHNU();
        HttpHelper httpHelper = new HttpHelper();
        school.createParam(HttpHelper.CMD_LOGIN);
        try {
            Object object = httpHelper.doService(school);
            System.out.println(object.toString());
            school.createParam(HttpHelper.CMD_QUERY_GRADE);
            object = httpHelper.doService(school);
            System.out.println(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
