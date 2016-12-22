package com.apologizebao.school;

import com.apologizebao.bean.CourseBean;
import com.apologizebao.bean.GradeBean;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NotFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apologizebao on 16-12-20.
 */
public class AHNU extends AbstractSchool {

    @Override
    public String parserLoginMessage(String html) {
        if (html.contains("fail")) {
            return "fail";
        }
        return "success";
    }

    @Override
    public List<GradeBean> parserGradeHtml(String html) {
        //TODO
        ArrayList<GradeBean> GradeList = new ArrayList<>();
        GradeBean gradeBean;
        try {
            Parser htmlParser = Parser.createParser(html, "utf-8");
            NodeFilter tagFilter = new TagNameFilter("tr");
            NodeFilter attrFilter = new HasAttributeFilter("align", "center");
            NodeFilter matcherFilter = new AndFilter(attrFilter, tagFilter);
            NodeList nodeList = null;

            nodeList = htmlParser.extractAllNodesThatMatch(matcherFilter);

            String value;
            NodeList childNodeList;
            Node node = null;
            for (int i = 0; i < nodeList.size(); i++) {
                childNodeList = nodeList.elementAt(i).getChildren();
                gradeBean = new GradeBean();
                for (int j = 1; j < childNodeList.size(); j += 2) {
                    node = childNodeList.elementAt(j).getLastChild();

                    if (node != null)
                        value = node.getText();
                    else value = "";
                    setGradedata(gradeBean, j, value);
                }
                GradeList.add(gradeBean);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
        return GradeList;
    }
    
    @Override
    public List<CourseBean>[] parserCourseHtml(String html) {
        ArrayList<CourseBean>[] courseList = new ArrayList[7];
        for (int k = 0; k < 7; k++)
            courseList[k] = new ArrayList<>();

        try {
            Parser htmlParser = Parser.createParser(html, "utf-8");
            NodeFilter tagFilter = new TagNameFilter("tr");
            NodeFilter attrFilter = new HasAttributeFilter("class", "thtd");
            //标签名为 tr 且 不含 class=thtd的属性的标签
            NodeFilter matcherFilter = new AndFilter(tagFilter, new NotFilter(attrFilter));
            NodeList nodeList = null;
            nodeList = htmlParser.extractAllNodesThatMatch(matcherFilter);
            NodeList childNodeList;
            Node childNode = null;

            for (int i = 0; i < nodeList.size(); i++) {
                childNodeList = nodeList.elementAt(i).getChildren();

                for (int j = 0; j < childNodeList.size(); j++) {
                    childNode = childNodeList.elementAt(j);
                    setWeekGradeData(courseList, j, childNode.toHtml());
                }
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }
        return courseList;
    }


    private void setGradedata(GradeBean bean, int j, String value) {
        switch (j) {
            case 1:
                bean.setCourseCode(value);
                break;
            case 3:
                bean.setCourseName(value);
                break;
            case 5:
                bean.setCoursePro(value);
                break;
            case 7:
                bean.setCourseType(value);
                break;
            case 9:
                bean.setCredit(value);
                break;
            case 11:
                bean.setFuxiu(value);
                break;
            case 13:
                bean.setGrade(value);
                break;
            case 15:
                bean.setFinalGrade(value);
                break;
            case 17:
                bean.setSecondGrade(value);
                break;
            case 19:
                bean.setReLearnGrade(value);
                break;
        }
    }

    private void setWeekGradeData(ArrayList<CourseBean>[] courseList, int j, String lineHtml) {

        lineHtml = lineHtml.replaceAll("<[\\/]{0,1}td>", "").trim(); //使用正则表达式过滤
        double week = (j - 5) / 2.0;
        if (0 <= week && week < 7 && !String.valueOf(week).contains(".5")) {
            CourseBean bean = new CourseBean("", "", "", "");
            if (!lineHtml.equals("")) {
                System.out.println(lineHtml);
                String[] part = lineHtml.split("<br>");
                if (part.length >= 4) {
                    bean.setCourseName(part[0]);
                    bean.setCourseTime(part[1]);
                    bean.setCourserTeacher(part[2]);
                    bean.setCourseAddr(part[3]);
                }
            }
            courseList[(int) week].add(bean);
        }
    }

}
