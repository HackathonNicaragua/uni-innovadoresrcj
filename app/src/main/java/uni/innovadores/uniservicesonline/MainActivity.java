package uni.innovadores.uniservicesonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String token = FirebaseInstanceId.getInstance().getToken();

		//Toast.makeText(this,token,Toast.LENGTH_LONG).show();
	}
}
