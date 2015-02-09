package yan.samux.ikaros.com.savac4k.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yan.samux.ikaros.com.savac4k.R;

public class GraphicFragment extends Fragment {

    public GraphicFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_graphic, container, false);


        return rootView;
    }
}
