package yan.samux.ikaros.com.savac4k.adapters.listas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import yan.samux.ikaros.com.savac4k.R;
import yan.samux.ikaros.com.savac4k.app.AppControllerClass;
import yan.samux.ikaros.com.savac4k.models.Basico;
import yan.samux.ikaros.com.savac4k.models.Paises;

/**
 * Created by Yonkishum on 06-03-2015.
 */
public class CustomListCountryAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Paises> elementos;
    ImageLoader imageLoader = AppControllerClass.getInstance().getImageLoader();

    public CustomListCountryAdapter(Activity activity, List<Paises> elementos){
        this.activity = activity;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)

            convertView = inflater.inflate(R.layout.list_elements, null);

        if (imageLoader == null)

            imageLoader = AppControllerClass.getInstance().getImageLoader();

        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbnailVolley);
        TextView palabrotas = (TextView) convertView.findViewById(R.id.palabra);
        TextView palachina  = (TextView) convertView.findViewById(R.id.enChino);
        TextView pronuncia  = (TextView) convertView.findViewById(R.id.pronuncia);

        Paises m = elementos.get(position);

        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        palabrotas.setText(m.getPalabra());
        palachina.setText(m.getChinese());
        pronuncia.setText("(" + m.getPro() + ")");

        return convertView;
    }

}
