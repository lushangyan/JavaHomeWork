package work;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class HttpClientWork {



    public static String get(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpUriRequest build = RequestBuilder.get(url).build();
        CloseableHttpResponse execute = client.execute(build);
        HttpEntity entity = execute.getEntity();
        String returnStr = EntityUtils.toString(entity);
        return returnStr;
    }


}
