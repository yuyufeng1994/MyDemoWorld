package org.apache.solr;

/**
 * Created by yuyufeng on 2017/5/24.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.bean.TestBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrBean {

    /**
     * 按Bean  添加/修改 索引
     * @author xuye
     * Date: 2017年5月22日 下午3:10:53
     * @throws Exception
     */
    public static void addIndex() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        //添加多个
        List<TestBean> docs = new ArrayList();
        for (int i = 6; i < 10; i++) {
            TestBean bean = new TestBean();
            bean.setId(i + "");
            bean.setUserName("test" + i);
            docs.add(bean);
        }
        server.addBeans(docs);
        server.commit();
    }

    /**
     * 删除索引 按查询
     * @author xuye
     * Date: 2017年5月22日 下午3:11:18
     * @throws Exception
     */
    public static void deleteByQuery(String query) throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        query = "*:*";
        server.deleteByQuery(query);
        server.commit();
    }

    //查询索引
    public static void query() throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
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
//        deleteByQuery(null);
        addIndex();
        query();
    }

}