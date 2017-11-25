package uni.innovadores.uniservicesonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

	private static final String LOGIN_URL = "http://uniservices.online/servApp/appFunc.php";

	public static final String KEY_USERNAME = "username";
	public static final String KEY_PASSWORD = "password";
	private EditText EdtUser, EdtPass;
	private Button BtLogin, BtReg;
	private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		EdtUser = findViewById(R.id.edt_user);
		EdtPass = findViewById(R.id.edt_pass);
		BtLogin = findViewById(R.id.btn_login);
		//BtReg = findViewById(R.id.btn_reg);
		BtLogin.setOnClickListener(this);

	}


	private void LoginUser(){
		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Cargando...");
		pDialog.show();
		final String username = EdtUser.getText().toString().trim();
		final String password = EdtPass .getText().toString().trim();

		StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL+"?username="+username+"&passwd="+password,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						if(response.isEmpty()){
							Toast.makeText(LoginActivity.this,"No hay datos.",Toast.LENGTH_LONG).show();
						}
						if(response.contentEquals("Inicio Correcto")){
							OcultarPDialog();
							Toast.makeText(LoginActivity.this,"Bienvenido!",Toast.LENGTH_LONG).show();
							Intent it_main = new Intent(getApplicationContext(), MainActivity.class);
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
						//hidePDialog();

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
		if(view.getId() == R.id.btn_login){
			LoginUser();
		}
	}

	private void OcultarPDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}
}
