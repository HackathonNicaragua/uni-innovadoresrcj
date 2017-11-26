package uni.innovadores.uniservicesonline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uni.innovadores.uniservicesonline.adapters.CustomListNotifyAdapter;
import uni.innovadores.uniservicesonline.models.Notify;

public class NotifiActivity extends AppCompatActivity implements View.OnClickListener {

	private Button Bthome, BtCat, BtNotif, BtFav, BtPerfil;
	ConnectivityManager cm;
	JSONArray jsonArray;
	String StringJsonArray;

	private List<Notify> notifyList = new ArrayList<Notify>();
	private ListView listView;
	private CustomListNotifyAdapter adapter;
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	String js;
	String msg;
	String title;
	JSONObject obj;
	JSONObject store;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifi);

		FirebaseMessaging.getInstance().subscribeToTopic("global");

		final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
		View network_CK = findViewById(R.id.network_check);

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

		jsonArray = new JSONArray();
		obj = new JSONObject();

		Intent intent = getIntent();

		msg = intent.getStringExtra("message");
		title = intent.getStringExtra("title");


		listView = findViewById(R.id.list_notifi);

		prefs = getPreferences(MODE_PRIVATE);
		editor = prefs.edit();
		editor.apply();


		//Log.d("Shared Final - ", jsonArray2.toString());



		//Log.d("Shared Final - ", prefs.getString("notifyH", "Notify"));


	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.btn_home){
			Intent it_main = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(it_main);
		}

		if(view.getId() == R.id.btn_cat){
			Intent it_main = new Intent(getApplicationContext(), CategoriasActivity.class);
			startActivity(it_main);
		}

		if(view.getId() == R.id.btn_notif){
//			try {
//				makJsonObject(title, msg);
//				//Log.d("JsonArray Final - ", StringJsonArray);
//
//
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
		}

		if(view.getId() == R.id.btn_favo){
			Intent it_main = new Intent(getApplicationContext(), FavoritosActivity.class);
			startActivity(it_main);
		}

		if(view.getId() == R.id.btn_perfil){
			Intent it_main = new Intent(getApplicationContext(), ContactarActivity.class);
			startActivity(it_main);
		}

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

	public String makJsonObject(String titulo, String cuerpo)
			throws JSONException {

		//try {
			obj.put("titulo", titulo);
			obj.put("cuerpo", cuerpo);

//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//jsonArray.put(store);
		//jsonArray.put(store);
		jsonArray.put(obj);
		Log.d("Final - ", jsonArray.toString());
		StringJsonArray = jsonArray.toString();
		editor.putString("notifyH", StringJsonArray);
		editor.commit();
		Toast.makeText(this,prefs.getString("notifyH", ""),Toast.LENGTH_LONG).show();

		try {
			store = new JSONObject(prefs.getString("notifyH", "Notify"));
			JSONArray jsonArray2 = new JSONArray(store);
			Log.d("Shared Final - ", jsonArray2.toString());

			adapter = new CustomListNotifyAdapter(this, notifyList);
			listView.setAdapter(adapter);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return StringJsonArray;
	}


	public void onBackPressed() {
		//super.onBackPressed();
		//finish();
	}

}
