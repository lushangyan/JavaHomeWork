package work;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class OkHttpWork {

    public static String get(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (response.isSuccessful()) {
                return body.string();
            } else {
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
