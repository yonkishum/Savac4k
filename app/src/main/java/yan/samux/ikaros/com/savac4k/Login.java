package yan.samux.ikaros.com.savac4k;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yan.samux.ikaros.com.savac4k.pruebas.BasePrueba;


public class Login extends ActionBarActivity {

	TextView mRegister, trylibs;
	Button mLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mRegister = (TextView) findViewById(R.id.registrar);
		trylibs = (TextView) findViewById(R.id.textView5);

		mLogin = (Button) findViewById(R.id.login);

		mLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent login = new Intent(getApplicationContext(), Main.class);
				startActivity(login);
			}
		});

		mRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent start = new Intent(getApplicationContext(), Register.class);
				startActivity(start);
			}
		});

		trylibs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent start = new Intent(getApplicationContext(), BasePrueba.class);
				startActivity(start);
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
