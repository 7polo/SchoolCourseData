package com.apologizebao.parser;

import com.apologizebao.bean.CourseBean;

import java.util.List;

/**
 * Created by apologizebao on 16-12-20.
 */

/**
 * 解析 课表页面的html，将其转化成 集合结构
 */
public interface ParserCourseHtml {
    
    List<CourseBean>[] parserCourseHtml(String html);
}
