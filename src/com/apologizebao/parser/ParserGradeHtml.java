package com.apologizebao.parser;

/**
 * Created by apologizebao on 16-12-20.
 */

import com.apologizebao.bean.GradeBean;
import org.htmlparser.util.ParserException;

import java.util.List;

/**
 * 解析 已获取的课程的 HTML
 */
public interface ParserGradeHtml {
    List<GradeBean> parserGradeHtml(String html) throws ParserException;
}
