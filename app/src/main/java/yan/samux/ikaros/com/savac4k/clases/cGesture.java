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

import yan.samux.ikaros.com.savac4k.R;
import yan.samux.ikaros.com.savac4k.adapters.listas.CustomListCountryAdapter;
import yan.samux.ikaros.com.savac4k.adapters.listas.CustomListGestureAdapter;
import yan.samux.ikaros.com.savac4k.app.AppControllerClass;
import yan.samux.ikaros.com.savac4k.models.Gestos;
import yan.samux.ikaros.com.savac4k.models.Paises;

public class cGesture extends ActionBarActivity {

    private static final String TAG = cGesture.class.getSimpleName();
    private static final String url = "http://192.168.56.1/savac4kcon/gestos.php";
    private ProgressDialog pDialog;
    private List<Gestos> gestosList = new ArrayList<Gestos>();
    private CustomListGestureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_gesture);

        ListView listView = (ListView) findViewById(R.id.csGestos);
        adapter = new CustomListGestureAdapter(this, gestosList);
        listView.setAdapter(adapter);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        JsonArrayRequest gestosReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Gestos gestos = new Gestos();
                                gestos.setPalabra(obj.getString("_namegesture"));
                                gestos.setThumbnailUrl(obj.getString("_imagen"));
                                gestos.setChinese(obj.getString("_enChino"));
                                gestos.setPro(obj.getString("_pronunciacion"));

                                gestosList.add(gestos);


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
        AppControllerClass.getInstance().addToRequestQueue(gestosReq);

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
