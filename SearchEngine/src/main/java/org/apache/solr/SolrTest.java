package org.apache.solr;

/**
 * Created by yuyufeng on 2017/5/24.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;

public class SolrTest {

    public static void main(String[] args) throws Exception {
//        addIndex();
//        query();
        queryHighlighter("互联网客运公司");
    }



    /**
     * 添加/修改 索引
     *
     * @throws Exception
     * @author xuye
     * Date: 2017年5月22日 下午3:10:53
     */
    public static void addIndex() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "1003");
        doc.addField("userName", "测试");//_s String类型
        doc.addField("userContent", "今天天气好吗");//_i 整型
        server.add(doc);
        server.commit();
        //添加多个
       /* Collection<SolrInputDocument> docs = new ArrayList();
        for (int i = 0; i < 10; i++) {
            SolrInputDocument doc2 = new SolrInputDocument();
            doc2.addField("id", i);
            doc2.addField("userName", "test" + i);//_s String类型
            doc2.addField("userScore", i);//_i 整型
            docs.add(doc2);
        }
        server.add(docs);
        server.commit();*/
    }

    /**
     * 删除索引 按id
     *
     * @throws Exception
     * @author xuye
     * Date: 2017年5月22日 下午3:11:18
     */
    public static void deleteById() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        server.deleteById("1002");//按id删除
        server.commit();
    }

    /**
     * 删除索引 按list
     *
     * @throws Exception
     * @author xuye
     * Date: 2017年5月22日 下午3:11:40
     */
    public static void deleteByList() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        List<String> ids = new ArrayList();
        ids.add("1001");
        ids.add("1002");
        server.deleteById(ids);//按list删除
        server.commit();
    }

    public  static  void queryHighlighter(String kw){
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("userContent:"+kw); //设置查询关键字
        solrQuery.setHighlight(true); //开启高亮
        solrQuery.addHighlightField("userContent"); //高亮字段
        solrQuery.setHighlightSimplePre("<font color='red'>"); //高亮单词的前缀
        solrQuery.setHighlightSimplePost("</font>"); //高亮单词的后缀
        solrQuery.setHighlightFragsize(1);
        /**
         hl.snippets
         hl.snippets参数是返回高亮摘要的段数，因为我们的文本一般都比较长，含有搜索关键字的地方有多处，如果hl.snippets的值大于1的话，
         会返回多个摘要信息，即文本中含有关键字的几段话，默认值为1，返回含关键字最多的一段描述。solr会对多个段进行排序。
         hl.fragsize
         hl.fragsize参数是摘要信息的长度。默认值是100，这个长度是出现关键字的位置向前移6个字符，再往后100个字符，取这一段文本。*/

        solrQuery.setHighlightFragsize(100);

        try {
            QueryResponse query = SolrServer.getServer().query(solrQuery);
            SolrDocumentList results = query.getResults();
            NamedList<Object> response = query.getResponse();
            NamedList highlighting = (NamedList) response.get("highlighting");
            for (int i = 0; i <highlighting.size() ; i++) {
                System.out.println(highlighting.getName(i)+"："+highlighting.getVal(i));
            }



            for (SolrDocument result : results) {
                System.out.println(result.toString());
            }

        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查询索引
     *
     * @throws Exception
     * @author xuye
     * Date: 2017年5月22日 下午3:11:49
     */
    public static void query() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(0);//开始记录数
        query.setRows(10000);//总条数

        QueryResponse queryResponse = server.query(query);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println("总条数为：" + results.getNumFound());
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i).getFieldNames());
            System.out.print(results.get(i).getFieldValue("id"));
            System.out.print(results.get(i).getFieldValue("userName"));
            System.out.print(results.get(i).getFieldValue("userContent"));
            System.out.println();
        }

    }


}
