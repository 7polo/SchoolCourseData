package com.apologizebao.school;

import com.apologizebao.HttpMonitor.HttpHelper;
import com.apologizebao.jsonBean.QueryParamBean;
import com.apologizebao.parser.ConfigHelper;
import com.apologizebao.parser.ParserCourseHtml;
import com.apologizebao.parser.ParserGradeHtml;
import com.apologizebao.parser.ParserLoginMessage;
import com.google.gson.Gson;
import org.htmlparser.util.ParserException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 抽象的学校类。不同的学校只要继承自该类，实现接口方法即可
 * queryParamBean 是请求的配置的实体，通过更改其中的信息即可改变访问参数
 * Created by apologizebao on 16-12-20.
 */

public abstract class AbstractSchool extends ConfigHelper
        implements ParserLoginMessage, ParserCourseHtml, ParserGradeHtml {

    // 三种配置list ：登录 查询成绩 查询课表 
    private QueryParamBean queryParamBean; //保存了动态的参数值的 的访问参数名

    /**
     * 将配置文件路劲传入
     */
    protected AbstractSchool() {
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File(System.getProperty("user.dir")+"/config.json");
            setFile(file);
            Gson gson = new Gson();
            queryParamBean = gson.fromJson(new FileReader(file), QueryParamBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createParam(int cmd) {
        List<QueryParamBean.ParamesEntity> list = null;
        this.setCmd(cmd); //获取指令
        if (queryParamBean != null) {
            switch (cmd) {
                case HttpHelper.CMD_LOGIN:
                    list = queryParamBean.loginParames;
                    break;

                case HttpHelper.CMD_QUERY_COURSE:
                    list = queryParamBean.courseParames;
                    break;
                case HttpHelper.CMD_QUERY_GRADE:
                    list = queryParamBean.gradeParames;
                    break;
            }
            if (list != null) {
                //构建参数格式
                StringBuilder stringBuilder = new StringBuilder();
                if (list != null && list.size() > 0) {
                    for (QueryParamBean.ParamesEntity entity : list) {
                        stringBuilder.append(entity.key + "=" + entity.value + "&");
                    }
                }
                int index = stringBuilder.lastIndexOf("&");
                stringBuilder.delete(index, index + 1);
                this.setParam(stringBuilder.toString());
            }
        }
    }

    /**
     * 返回html解析生成对的对象
     *
     * @param cmd
     * @param html
     * @return 生成的对象，如果为 null，解析失败
     */
    public Object paresrHtml(int cmd, String html) throws ParserException {
        switch (cmd) {
            case HttpHelper.CMD_LOGIN:
                return parserLoginMessage(html);

            case HttpHelper.CMD_QUERY_COURSE:
                return parserCourseHtml(html);

            case HttpHelper.CMD_QUERY_GRADE:
                return parserGradeHtml(html);
        }
        return null;
    }
}
