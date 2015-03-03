package yan.samux.ikaros.com.savac4k.pruebas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yan.samux.ikaros.com.savac4k.R;

public class BasePrueba extends ActionBarActivity {

	Button pruebas1, pruebas2, pruebas3;
	Intent go;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_prueba);

		pruebas1 = (Button) findViewById(R.id.pruPicasso);
		pruebas2 = (Button) findViewById(R.id.pruCards);
		pruebas3 = (Button) findViewById(R.id.Loop);

		pruebas1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), PruebaPicasso.class);
				startActivity(go);
			}
		});

		pruebas2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), PruebaCards.class);
				startActivity(go);
			}
		});

		pruebas3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), LOOPJprueba.class);
				startActivity(go);
			}
		});

	}
}
