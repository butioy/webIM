package org.butioy.webim.web.controller;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LSL on 2016/2/18.
 */
public class HttpClientDemo {

    public static void main(String[] args) {
        String url = "http://10.16.21.38:8080/pentaho/plugin/cda/api/doQuery?";
        url += "paramstoreNameParam=呼家楼门店&paramproductClassParam=全部&parambeginTimeParam=2016-02-01";
        url += "&paramendTimeParam=2016-03-31&paramlevel2SalesCountMdx=SELECT NON EMPTY { [Measures].[SalesAmount]} ON 0, NON EMPTY Order( [dimProdservType].[typeLevel2].Members, [Measures].[SalesAmount], BDESC ) ON 1 FROM [OrderCube] WHERE {[dimDate].[day].[2016-02-29]: [dimDate].[day].[2016-03-31]}*{[dimStore].[storeName].[呼家楼门店]}";
        url += "&path=/public/PUBLISH/productOrderAnalyze.cda&dataAccessId=sales_count_01_mdx&outputIndexId=1&pageSize=0&pageStart=0&sortBy=&paramsearchBox=";
        HttpClient httpClient = new HttpClient();
        //需要验证
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("butioy", "111111");

        httpClient.getState().setCredentials(AuthScope.ANY, creds);

        //设置http头
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"));
        httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);

        GetMethod method = new GetMethod(url);
        method.setDoAuthentication(true);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
        try {
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed code="+statusCode+": " + method.getStatusLine());
            } else {
                System.out.println(new String(method.getResponseBody(), "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
