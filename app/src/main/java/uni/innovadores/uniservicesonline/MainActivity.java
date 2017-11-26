package uni.innovadores.uniservicesonline;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
	ConnectivityManager cm;
	private Button Bthome, BtCat, BtNotif, BtFav, BtPerfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String token = FirebaseInstanceId.getInstance().getToken();

		//Toast.makeText(this,token,Toast.LENGTH_LONG).show();

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

	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.btn_home){
//			Intent it_main = new Intent(getApplicationContext(), MainActivity.class);
//			startActivity(it_main);
		}

		if(view.getId() == R.id.btn_cat){
			Intent it_main = new Intent(getApplicationContext(), CategoriasActivity.class);
			startActivity(it_main);
		}

		if(view.getId() == R.id.btn_notif){
			Intent it_main = new Intent(getApplicationContext(), NotifiActivity.class);
			startActivity(it_main);
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

}
