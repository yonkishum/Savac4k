package yan.samux.ikaros.com.savac4k.clases;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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

import yan.samux.ikaros.com.savac4k.adapters.listas.CustomListActionsClases;
import yan.samux.ikaros.com.savac4k.R;
import yan.samux.ikaros.com.savac4k.app.AppControllerClass;
import yan.samux.ikaros.com.savac4k.models.Acciones;

public class cActions extends ActionBarActivity {

    private static final String TAG = cActions.class.getSimpleName();

    private static final String url = "http://192.168.56.1/savac4kcon/acciones.php";
    private ProgressDialog pDialog;
    private List<Acciones> accionesList = new ArrayList<Acciones>();
    private CustomListActionsClases adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_actions);


        ListView listView = (ListView) findViewById(R.id.csAcciones);

        adapter = new CustomListActionsClases(this, accionesList);

        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);

        pDialog.setMessage("Cargando...");

        pDialog.show();

        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Acciones acciones = new Acciones();
                                acciones.setPalabra(obj.getString("_nombreacciones"));
                                acciones.setThumbnailUrl(obj.getString("_imagen"));
                                acciones.setChinese(obj.getString("_enChino"));
                                acciones.setPro(obj.getString("_pronunciacion"));

                                accionesList.add(acciones);


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
        AppControllerClass.getInstance().addToRequestQueue(movieReq);

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
