package uni.innovadores.uniservicesonline;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ContactarActivity extends AppCompatActivity implements View.OnClickListener {
	ConnectivityManager cm;
	private Button BtSMS, BtCall, BtShare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactar);

		final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
		View network_CK = findViewById(R.id.network_check);

		//comprobando conexion a internet
		if (isOnline()){
			network_CK.setVisibility(View.GONE);
		}else{
			network_CK.setVisibility(View.VISIBLE);
			network_CK.startAnimation(animationScale);
		}

		BtSMS = findViewById(R.id.btn_sms);
		BtCall = findViewById(R.id.btn_call);
		BtShare = findViewById(R.id.btn_share);

		BtSMS.setOnClickListener(this);
		BtCall.setOnClickListener(this);
		BtShare.setOnClickListener(this);


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


	public void enviarsms(){

		Intent message = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + "" ) );
		message.putExtra( "sms_body", "Hola mi nombre es...\nEstoy interezado en su servicio...");

		startActivity(message);
	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.btn_sms){
			enviarsms();
		}
		if(view.getId() == R.id.btn_call){

		}
		if(view.getId() == R.id.btn_share){
			Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pomares Al Bat");
			sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
			startActivity(Intent.createChooser(sharingIntent, "Compartir via"));

		}

	}
}
