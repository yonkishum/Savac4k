package yan.samux.ikaros.com.savac4k.pruebas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yan.samux.ikaros.com.savac4k.R;

public class BasePrueba extends ActionBarActivity {

	Button Picasso, Cards, LOOPJ, Volley;
	Intent go;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_prueba);

		Picasso = (Button) findViewById(R.id.pruPicasso);
		Cards = (Button) findViewById(R.id.pruCards);
		LOOPJ = (Button) findViewById(R.id.Loop);
        Volley = (Button) findViewById(R.id.VolleyP);

		Picasso.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), PruebaPicasso.class);
				startActivity(go);
			}
		});

		Cards.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), PruebaCards.class);
				startActivity(go);
			}
		});

		LOOPJ.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go = new Intent(getApplicationContext(), LOOPJprueba.class);
				startActivity(go);
			}
		});

        Volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go = new Intent(getApplicationContext(), VolleyPrueba.class);
                startActivity(go);
            }
        });

	}
}
