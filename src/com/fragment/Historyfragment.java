package com.fragment;

import java.util.ArrayList;

import org.achartengine.GraphicalView;

import com.Achart.ChartBarSeries;
import com.Achart.ChartLineSeries;
import com.Achart.ChartPieService;
import com.Base.MyApplication;
import com.db.Mydatabase;
import com.db.Mysensor;
import com.example.jiaotong.R;
import MyPagerAdapter.MyPagerAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Historyfragment extends Fragment {

	private View view;
	private ViewPager viewPager;
	private Spinner sensetype,sensetime;
	private Button choosebtn;
	private String[] types = { "temp","humidity","LightIntensity","pm2.5","co2"};
	private String[] times = {"1分钟","5分钟"};
	private String type = "temp";
	private String time = "1分钟";
//	private LinearLayout chart_layout;
	private Activity context = MyApplication.getInstance().context;
	
	
	private static Historyfragment instance = null;
	
	public static Historyfragment getInstance() {
		if(instance == null) {
			instance = new Historyfragment();
		}
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view =inflater.inflate(R.layout.fragment_history, null);
		viewPager = (ViewPager) view.findViewById(R.id.viewPager_chartView_history);
//		chart_layout = (LinearLayout) view.findViewById(R.id.history_chart_layout);
		initView();
		return view;
	}

	/**
	 * 实例化组件
	 */
	private void initView() {
		// TODO Auto-generated method stub
		sensetype = (Spinner) view.findViewById(R.id.history_sptype);
		sensetype.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item,types));
		sensetype.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				type = (String) arg0.getItemAtPosition(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		sensetime  =(Spinner) view .findViewById(R.id.history_sptime);
		sensetime.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item,times));
		sensetime.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				time = (String) arg0.getItemAtPosition(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		choosebtn = (Button) view.findViewById(R.id.history_btn);
		choosebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				searchHistory();
			}
		});
		
	}

	/**
	 * 查询历史数据
	 */
	private void searchHistory() {
		ArrayList<Mysensor> mysensor = null;
		if(time=="1分钟"){
			mysensor = new Mydatabase(context).query60();
		}else{
			System.out.println("五分钟");
			mysensor = new Mydatabase(context).query5();
		}	
		ArrayList<Integer> SensorValuelist = new ArrayList<Integer>();
		if(type.equals(types[3])){
			for(int i=0;i<10;i++){
				Mysensor list = mysensor.get(i);
				SensorValuelist.add(list.getpm25());
			}
		}else if(type.equals(types[4])){
			for(int i=0;i<10;i++){
				Mysensor list = mysensor.get(i);
				SensorValuelist.add(list.getco2());
			}
		}else if(type.equals(types[2])){
			for(int i=0;i<10;i++){
				Mysensor list = mysensor.get(i);
				SensorValuelist.add(list.getLightIntensity());
			}
		}else if(type.equals(types[1])){
			for(int i=0;i<10;i++){
				Mysensor list = mysensor.get(i);
				SensorValuelist.add(list.gethumidity());
			}
		}else if(type.equals(types[0])){
			for(int i=0;i<10;i++){
				Mysensor list = mysensor.get(i);
				SensorValuelist.add(list.gettemp());
			}
		}
		int maxValue = SensorValuelist.get(0);
		for(int i=0;i<SensorValuelist.size();i++){
			if(maxValue<SensorValuelist.get(i)){
				maxValue = SensorValuelist.get(i);
			}
		}
		ArrayList<View> ChartViews = new ArrayList<View>();
		MyPagerAdapter history_pager = new MyPagerAdapter(ChartViews);
		ChartBarSeries BarSeries = new ChartBarSeries(getActivity());
		BarSeries.setDataset(SensorValuelist);
		BarSeries.setRenderer(maxValue+300);
		GraphicalView BarView = BarSeries.getChartBarView();
		ChartViews.add(BarView);
		ChartLineSeries LineSeries = new ChartLineSeries(getActivity());
		LineSeries.setDataSet(SensorValuelist);
		LineSeries.setRendererSet(R.color.blue1);
		GraphicalView LineView = LineSeries.getGraphicalView();
		ChartViews.add(LineView);
		viewPager.setAdapter(history_pager);
		viewPager.setCurrentItem(0);
	}
}
