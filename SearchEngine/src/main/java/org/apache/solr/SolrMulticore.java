package org.apache.solr;

/**
 * Created by yuyufeng on 2017/5/24.
 */
import java.util.List;

import org.apache.solr.bean.TestBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrMulticore {

    public static void query(String queryStr) throws Exception {
        HttpSolrClient server = SolrServer.getServer();
        SolrQuery query = new SolrQuery();
        query.setQuery(queryStr);
        //query.setStart(0);//开始记录数
        //query.setRows(30);//总条数
        query.set("start", 0);
        query.set("rows", 20);
        query.set("shards", "localhost:8081/solr/test"
                + ",localhost:8081/solr/core1"
                + ",localhost:8081/solr/core2");
        //shards可以关联多个core，用逗号分隔. id 是唯一主键，多个核的id要不一样
        QueryResponse queryResponse = server.query(query);
        List<TestBean> results = queryResponse.getBeans(TestBean.class);
        System.out.println("总条数为：" + results.size());
        for (TestBean testBean : results) {
            System.out.println(testBean.toString());
        }

    }

    public static void main(String[] args) throws Exception {
        query("*:*");
    }

}