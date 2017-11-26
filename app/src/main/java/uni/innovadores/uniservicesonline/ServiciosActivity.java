package uni.innovadores.uniservicesonline;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifTextView;
import uni.innovadores.uniservicesonline.adapters.ServiciosAdapter;
import uni.innovadores.uniservicesonline.models.Servicios;

public class ServiciosActivity extends AppCompatActivity {
    private List<Servicios> serviciosList = new ArrayList<>();
    private ServiciosAdapter adapter;
    JSONArray jsonArray;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    RequestQueue queue;
    private GifTextView loader;
    ConnectivityManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        View network_CK = findViewById(R.id.network_check);

        if (isOnline()){
            network_CK.setVisibility(View.GONE);
        }else{
            network_CK.setVisibility(View.VISIBLE);
            network_CK.startAnimation(animationScale);
        }

        ListView listView = findViewById(R.id.list_serv);

        queue = Volley.newRequestQueue(this);

        prefs = this.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.apply();

        loader = findViewById(R.id.Gloader);

        adapter = new ServiciosAdapter(this, serviciosList);
        listView.setAdapter(adapter);

        new ConsultarDatos().execute();

    }

    public void CargarServicios(){

        String url ="http://hostingnica.net/apps/uniservices/test/funciones.php?run=ObtenerServicios";

        StringRequest stringRequest = new StringRequest( url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.print("La respuesta es: "+ response);

                        editor.putString("Serviciosjson", response);
                        editor.commit();
                        String js = prefs.getString("Serviciosjson", "Servicios");

                        try {
                            jsonArray = new JSONArray(js);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        loader.setVisibility(View.GONE);

                        try {

                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {

                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    Servicios srv = new Servicios();
                                    srv.setNombreServ(obj.getString("NombreServicio"));
                                    srv.setDescrServ(obj.getString("DescrServ"));
                                    srv.setCategoriaServ(obj.getString("Categoria"));

                                    srv.setPrecioServ(obj.getDouble("CostoServ"));
                                    srv.setPuntuacion(obj.getDouble("puntuacion"));

                                    serviciosList.add(srv);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                            adapter.notifyDataSetChanged();
                        }

                        catch(Exception e){
                            System.out.print(e);
                        }
                        finally{
                            Log.i("Error: ","Carga de datos fallida");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("Error en la solicitud.");

                String js = prefs.getString("Serviciosjson", "Servicios");

                try {
                    jsonArray = new JSONArray(js);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                loader.setVisibility(View.GONE);

                try {

                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {

                            JSONObject obj = jsonArray.getJSONObject(i);
                            Servicios srv = new Servicios();
                            srv.setNombreServ(obj.getString("NombreServicio"));
                            srv.setDescrServ(obj.getString("DescrServ"));
                            srv.setCategoriaServ(obj.getString("Categoria"));

                            srv.setPrecioServ(obj.getDouble("CostoServ"));
                            srv.setPuntuacion(obj.getDouble("puntuacion"));

                            serviciosList.add(srv);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    adapter.notifyDataSetChanged();
                }

                catch(Exception e){
                    System.out.print(e);
                }
                finally{
                    Log.i("Error LOCAL: ","Carga de datos fallida");
                }

            }
        });
        queue.add(stringRequest);
    }

    private  class ConsultarDatos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            CargarServicios();
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

    public boolean isOnline() {
        cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm != null) {
            if (cm.getActiveNetworkInfo() != null
					&& cm.getActiveNetworkInfo().isAvailable()
					&& cm.getActiveNetworkInfo().isConnected()) {

				return true;
			} else {

				Log.i("Estado de red: ", "Conexion a internet fallida");

			}
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy: ","Actividad Destruida correctamente.");
    }

}
