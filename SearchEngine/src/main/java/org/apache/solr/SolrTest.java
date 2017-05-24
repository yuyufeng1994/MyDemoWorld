package org.apache.solr;

/**
 * Created by yuyufeng on 2017/5/24.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrTest {

    public static void main(String[] args) throws Exception {
        addIndex();
        query();
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
        doc.addField("userName", "testName测试");//_s String类型
        doc.addField("userScore", "103");//_i 整型
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
            System.out.print(results.get(i).getFieldValue("userScore"));
            System.out.println();
        }

    }


}
