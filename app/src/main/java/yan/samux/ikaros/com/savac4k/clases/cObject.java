package yan.samux.ikaros.com.savac4k.clases;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import yan.samux.ikaros.com.savac4k.R;
import yan.samux.ikaros.com.savac4k.adapters.listas.CustomListObjetosAdapter;
import yan.samux.ikaros.com.savac4k.app.AppControllerClass;
import yan.samux.ikaros.com.savac4k.models.Objetos;

public class cObject extends ActionBarActivity {

    private static final String TAG = cObject.class.getSimpleName();
    private static final String url = "http://192.168.56.1/savac4k/objetos.php";
    private ProgressDialog pDialog;
    private List<Objetos> objetosList = new ArrayList<Objetos>();
    private CustomListObjetosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_object);

        ListView listView = (ListView) findViewById(R.id.csObjetos);
        adapter = new CustomListObjetosAdapter(this, objetosList);
        listView.setAdapter(adapter);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        JsonArrayRequest objetoReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Objetos objetos = new Objetos();
                                objetos.setPalabra(obj.getString("_nameobjectos"));
                                objetos.setThumbnailUrl(obj.getString("_imagen"));
                                objetos.setChinese(obj.getString("_enChino"));
                                objetos.setPro(obj.getString("_pronunciacion"));

                                objetosList.add(objetos);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getBaseContext(), "Se obtuvo un Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppControllerClass.getInstance().addToRequestQueue(objetoReq);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
