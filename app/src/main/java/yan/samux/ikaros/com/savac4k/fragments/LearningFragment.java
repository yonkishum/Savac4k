package yan.samux.ikaros.com.savac4k.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import yan.samux.ikaros.com.savac4k.Activity_Learn;
import yan.samux.ikaros.com.savac4k.R;

public class LearningFragment extends Fragment {

	Button mbt_learning;

    public LearningFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

	    View rootView = inflater.inflate(R.layout.fragment_learning, container, false);

	    mbt_learning = (Button) rootView.findViewById(R.id.bt_learning);

	    mbt_learning.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
			    Intent z = new Intent(getActivity(), Activity_Learn.class);
			    startActivity(z);
		    }
	    });

	    return rootView;

    }

}
