package yan.samux.ikaros.com.savac4k.pruebas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;

import java.util.ArrayList;

import yan.samux.ikaros.com.savac4k.R;

public class LOOPJprueba extends ActionBarActivity {

    ListView listadoyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loopjprueba);

        listadoyu = (ListView) findViewById(R.id.listausuarios);

        getdata();

    }

    public void getdata() {

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://192.168.56.1/savac4kcon/index.php";

        RequestParams params = new RequestParams();

        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                if (i==200){
                    llenarlista(datosJSON(new String(bytes)));
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                //Toast.makeText(this, "Error en la conexion", Toast.LENGTH_SHORT);
            }
        });

    }

    public void llenarlista(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        listadoyu.setAdapter(adapter);
    }

    public ArrayList<String> datosJSON(String response){

        ArrayList<String> listado = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(response);
            String texto;

            for (int i=0; i<jsonArray.length(); i++){
                texto = jsonArray.getJSONObject(i).getString("_name") + " " +
                        jsonArray.getJSONObject(i).getString("_apellido") + " ";

                listado.add(texto);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return listado;
    }

}
