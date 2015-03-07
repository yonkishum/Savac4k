package yan.samux.ikaros.com.savac4k.clases;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import yan.samux.ikaros.com.savac4k.adapters.listas.CustomListActionsClases;
import yan.samux.ikaros.com.savac4k.R;
import yan.samux.ikaros.com.savac4k.models.Animales;

public class cNumbers extends ActionBarActivity {

    private static final String TAG = cActions.class.getSimpleName();

    private static final String url = "http://192.168.56.1/savac4kcon/animales.php";
    private ProgressDialog pDialog;
    private List<Animales> accionesList = new ArrayList<Animales>();
    private CustomListActionsClases adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_numbers);



    }
}
