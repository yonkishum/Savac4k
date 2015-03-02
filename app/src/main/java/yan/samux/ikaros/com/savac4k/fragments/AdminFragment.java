package yan.samux.ikaros.com.savac4k.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import yan.samux.ikaros.com.savac4k.R;

public class AdminFragment extends Fragment {

	public AdminFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_admin, container, false);


		PieChart mPieChart = (PieChart) rootView.findViewById(R.id.piechart);

		mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
		mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#56B7F1")));
		mPieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#CDA67F")));
		mPieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#FED70E")));

		mPieChart.startAnimation();

		return inflater.inflate(R.layout.fragment_admin, container, false);
	}
}
