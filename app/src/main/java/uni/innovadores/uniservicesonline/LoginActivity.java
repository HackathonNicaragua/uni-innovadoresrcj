package uni.innovadores.uniservicesonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import uni.innovadores.uniservicesonline.datos.info;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

	//Declarando Variables y controles

	public static final String KEY_USERNAME = "username";
	public static final String KEY_PASSWORD = "password";
	private EditText EdtUser, EdtPass;
	private Button BtLogin, BtReg;
	private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		//Referenciando los controles desde el layout

		EdtUser = findViewById(R.id.edt_user);
		EdtPass = findViewById(R.id.edt_pass);
		BtLogin = findViewById(R.id.btn_login);
		//BtReg = findViewById(R.id.btn_reg);
		BtLogin.setOnClickListener(this);

	}


	//Metodo para inicio de secion usando la libreria volley
	private void LoginUser(){
		//Se muestra un ProgressDialog y se declaran las variables username y password
		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Cargando...");
		pDialog.show();
		final String username = EdtUser.getText().toString().trim();
		final String password = EdtPass .getText().toString().trim();

		//Enviando solicitud http post para obtener resultado del login segun los parametos de los editext
		StringRequest stringRequest = new StringRequest(Request.Method.POST, info.LOGIN_URL+"?username="+username+"&passwd="+password,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {

						if(response.contentEquals("Inicio Correcto")){
							OcultarPDialog();
							Toast.makeText(LoginActivity.this,"Bienvenido!",Toast.LENGTH_LONG).show();
							Intent it_main = new Intent(getApplicationContext(), ServiciosActivity.class);
							startActivity(it_main);
							EdtPass.setText("");
							EdtUser.setText("");
						}

						if(response.contentEquals("Datos no Validos")){
							OcultarPDialog();
							Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
							EdtPass.setText("");
							EdtUser.setText("");

						}

						Log.i("Repuesta: ", response);
						OcultarPDialog();

					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
						OcultarPDialog();
						Log.i("Error: ", error.toString());
					}
				}){
			@Override
			protected Map<String,String> getParams(){
				Map<String,String> params = new HashMap<String, String>();
				params.put(KEY_USERNAME,username);
				params.put(KEY_PASSWORD,password);
				return params;
			}

		};

		RequestQueue requestQueue = Volley.newRequestQueue(this);
		requestQueue.add(stringRequest);
	}


	@Override
	public void onClick(View view) {
		//COndicionando click de botones y links
		if(view.getId() == R.id.btn_login){

			//Controlando si los editex estan vacios
			if(TextUtils.isEmpty(EdtUser.getText().toString()) && TextUtils.isEmpty(EdtPass.getText().toString())) {
				EdtUser.setError("Este campo es requerido.");
				EdtPass.setError("Este campo es requerido.");
				return;
			}else{
				//Ejecuta el metodo de inicio de sesion
				LoginUser();
			}


		}
	}

	//Funcion para ocultar el proggressDialog de login.
	private void OcultarPDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}
}
