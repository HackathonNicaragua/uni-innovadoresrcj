package uni.innovadores.uniservicesonline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
import uni.innovadores.uniservicesonline.datos.info;
import uni.innovadores.uniservicesonline.models.Servicios;

public class ServiciosActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Servicios> serviciosList = new ArrayList<>();
    private ServiciosAdapter adapter;
    JSONArray jsonArray;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    RequestQueue queue;
    private GifTextView loader;
    ConnectivityManager cm;
    private String ID_Cat;
    private Button Bthome, BtCat, BtNotif, BtFav, BtPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        View network_CK = findViewById(R.id.network_check);

        Intent intent = getIntent();
        ID_Cat = intent.getStringExtra("idCat");

        //comprobando conexion a internet
        if (isOnline()){
            network_CK.setVisibility(View.GONE);
        }else{
            network_CK.setVisibility(View.VISIBLE);
            network_CK.startAnimation(animationScale);
        }

        Bthome = findViewById(R.id.btn_home);
        BtCat = findViewById(R.id.btn_cat);
        BtNotif = findViewById(R.id.btn_notif);
        BtFav = findViewById(R.id.btn_favo);
        BtPerfil = findViewById(R.id.btn_perfil);

        Bthome.setOnClickListener(this);
        BtCat.setOnClickListener(this);
        BtNotif.setOnClickListener(this);
        BtFav.setOnClickListener(this);
        BtPerfil.setOnClickListener(this);

        ListView listView = findViewById(R.id.list_serv);

        queue = Volley.newRequestQueue(this);

        prefs = this.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.apply();

        loader = findViewById(R.id.Gloader);

        adapter = new ServiciosAdapter(this, serviciosList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                TextView ID_Cat = view.findViewById(R.id.tx_cat_id);

                Intent it_main = new Intent(getApplicationContext(), ContactarActivity.class);
                startActivity(it_main);
            }
        });

        new ConsultarDatos().execute();

    }

    //Cargando lista de servicios (prueba)
    public void CargarServicios(){

        String url = info.Serv_URL+"?idCattegoria="+ID_Cat;

        StringRequest stringRequest = new StringRequest( url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.print("La respuesta es: "+ response);

                        //Gardando datos en las sharedPreferences para disponibilidad sin conexion
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
                                    srv.setDescrServ(obj.getString("DescripcionServicio"));
                                    srv.setIMG(obj.getString("ImagenServicio"));

                                    srv.setPrecioServ(obj.getDouble("PrecioBase"));
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
                            srv.setDescrServ(obj.getString("DescripcionServicio"));
                            srv.setIMG(obj.getString("ImagenServicio"));

                            srv.setPrecioServ(obj.getDouble("PrecioBase"));
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

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_home){
            Intent it_main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it_main);
            finish();
        }

        if(view.getId() == R.id.btn_cat){
            Intent it_main = new Intent(getApplicationContext(), CategoriasActivity.class);
            startActivity(it_main);
            finish();
        }

        if(view.getId() == R.id.btn_notif){
            Intent it_main = new Intent(getApplicationContext(), NotifiActivity.class);
            startActivity(it_main);
            finish();
        }

        if(view.getId() == R.id.btn_favo){
            Intent it_main = new Intent(getApplicationContext(), FavoritosActivity.class);
            startActivity(it_main);
            finish();
        }

        if(view.getId() == R.id.btn_perfil){
            Intent it_main = new Intent(getApplicationContext(), ContactarActivity.class);
            startActivity(it_main);
            finish();
        }
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

    //Metodo para comprobar la conexion a internet
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
