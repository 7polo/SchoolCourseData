# SchoolCourseData <br>
<h2>根据config.json中的配置信息来获取学校教务系统的成绩和课表</h2>
<b>使用步骤</b>
<ol>
<li> 通过抓包查看从学校的教务系统访问的 url等信息，定制个性化的config.json</li>
<li> 继承AbstracSchool，实现接口中方法，完成对html的解析</li>
<li> 操作命令有 login queryGrade queryCourse</li>
<li> 对应的操作会返回一个 Object 类，包含了信息</li>
   login: 字符串<br>
   queryGrade: List<GradeBean><br>
   queryCourse：List<CourseBean>[] //包含一周的课表信息<br>
</ol>
<p>案例代码</p>
<pre>
 AbstractSchool school = new AHNU();
 HttpHelper httpHelper = new HttpHelper();
 //模拟登录
 school.createParam(HttpHelper.CMD_LOGIN);
 Object object = httpHelper.doService(school); 
 
 //查询成绩
 school.createParam(HttpHelper.CMD_QUERY_GRADE);
 object = httpHelper.doService(school);
</pre>
