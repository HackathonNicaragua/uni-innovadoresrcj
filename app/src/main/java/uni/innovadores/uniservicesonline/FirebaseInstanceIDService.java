package uni.innovadores.uniservicesonline;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import uni.innovadores.uniservicesonline.datos.info;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token",token);
        registerToken(token);
    }

    private void registerToken(String token) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("token",token)
                .build();
        Request request = new Request.Builder()
                .url(info.RegisterURL) //aqui se envia el token y se registra en la base de datos
                .post(requestBody)
                .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}