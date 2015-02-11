package yan.samux.ikaros.com.savac4k.pruebas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import yan.samux.ikaros.com.savac4k.R;

public class PruebaPicasso extends ActionBarActivity {

	//ImageView prueba;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba_picasso);

		ImageView prueba = (ImageView) findViewById(R.id.Pica);

		Picasso.with(this).load("http://www.blogiswar.net/wp-content/uploads/2015/02/Monster-Hunter-4-Ultimate-720x405.jpg").into(prueba);

	}
}
