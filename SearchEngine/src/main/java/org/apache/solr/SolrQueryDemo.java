package org.apache.solr;

/**
 * Created by yuyufeng on 2017/5/24.
 */
import java.util.List;

import org.apache.solr.bean.TestBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrQueryDemo {

    //查询索引
    public static void query() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        SolrQuery query = new SolrQuery();
        //query.setQuery("*:*");
        //query.set("q", "*:*");
        //query.set("q", "userName:test1?");//?通配单个字符
        query.set("q", "userName:tes*");//*通配多个字符
        //query.set("q", "userName:test~0.5");// ~ 模糊查询 可以直接用test~   test~0.5表示相似0.5以上的
        //如检索相隔10个单词的“apache”和”“akarta”，“jakarta apache”~10
//        query.set("q", "userName:test15 or userName:test5");

        /*布尔操作符AND、||
                                布尔操作符OR、&&
                                布尔操作符NOT、!、-（排除操作符不能单独与项使用构成查询）
           “+” 存在操作符，要求符号“+”后的项必须在文档相应的域中存在
         ( ) 用于构成子查询
                [ ] 包含范围检索，如检索某时间段记录，包含头尾，date:[200707 TO 200710]
                { }不包含范围检索，如检索某时间段记录，不包含头尾
                date:{200707 TO 200710}
                " 转义操作符，特殊字符包括+ - && || ! ( ) { } [ ] ^ ” ~ * ? : " */

        /*查询某个字段非空的记录 比如：fq=FieldName:[‘’ TO *] 查询FieldName非空的数据。
                            查询某个字段为空的记录 比如：查询公司名称为空的记录可以采用如下语法实现(似乎目前为止只有此方法可行):
                -company:[* TO *]
                            取反实例：fq=!fstate:1*/

        //“^”控制相关度检索，如检索jakarta apache，同时希望去让“jakarta”的相关度更加好，那么在其后加上”^”符号和增量值，即jakarta^4 apache
        query.set("fl", "id,userScore,userName");//fl 查询字段
        query.set("sort", "userScore desc");//sort 排序方式,正序用asc
        //wt 输出格式：json xml等

        query.set("fq", "userScore:[0 TO *]");//分数>=15  fq 过滤条件：在q查询符合结果中同时是fq查询符合的
        query.setStart(0);//开始记录数
        query.setRows(10000);//总条数
        QueryResponse queryResponse = server.query(query);
        List<TestBean> results = queryResponse.getBeans(TestBean.class);
        System.out.println("总条数为：" + results.size());
        for (TestBean testBean : results) {
            System.out.println(testBean.toString());
        }

    }

    public static void main(String[] args) throws Exception {
        query();
    }

}