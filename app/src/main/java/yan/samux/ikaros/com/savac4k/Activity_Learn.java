package yan.samux.ikaros.com.savac4k;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import yan.samux.ikaros.com.savac4k.clases.*;


public class Activity_Learn extends ActionBarActivity {

	ListView mlista;
	String[] nClass;
	int[] iClass = {
			R.drawable.ic_learning_basic,
			R.drawable.ic_learning_numbers,
			R.drawable.ic_learning_animals,
			R.drawable.ic_learning_object,
			R.drawable.ic_learning_country,
			R.drawable.ic_learning_gesture,
			R.drawable.ic_learning_run
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__learn);

		Resources resources = getResources();

		nClass = resources.getStringArray(R.array.clases);
		//iClass = resources.getIntArray(R.array.pic_clases);

		mlista = (ListView) findViewById(R.id.list_class);

		classAdapter adapter = new classAdapter(this, nClass, iClass);

		mlista.setAdapter(adapter);

		mlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			Intent start;

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 1:
						start = new Intent(getApplicationContext(), cBasico.class);
						startActivity(start);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
				}
			}
		});


	}
}

class classAdapter extends ArrayAdapter<String> {

	Context context;
	int[] ico_class;
	String[] name_class;

	classAdapter(Context c, String[] nmClass, int[] imClass) {
		super(c, R.layout.list_class_room, R.id.classname, nmClass);
		this.context = c;
		this.name_class = nmClass;
		this.ico_class = imClass;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.list_class_room, parent, false);

		ImageView icotype = (ImageView) row.findViewById(R.id.classicons);
		TextView nametype = (TextView) row.findViewById(R.id.classname);

		icotype.setImageResource(ico_class[position]);
		nametype.setText(name_class[position]);

		return row;
	}
}
