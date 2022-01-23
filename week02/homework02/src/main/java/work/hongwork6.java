package work;

import java.io.IOException;

public class hongwork6 {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        String httpClientResponse = new HttpClientWork().get(url);
        System.out.println("httpClientResponse" + httpClientResponse);

        String okHttpResponse = new OkHttpWork().get(url);
        System.out.println("okHttpResponse:" + okHttpResponse);


    }

}
