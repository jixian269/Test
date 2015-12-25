package com.Achart;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.graphics.Color;

public class ChartPieService {

	private GraphicalView graphicalView;
	private CategorySeries categorySeries;
	private DefaultRenderer defaultRenderer;
	private Context context;
	private SimpleSeriesRenderer simpleSeriesRenderer;
	private int[] colors = {Color.RED,Color.GREEN,Color.YELLOW,Color.CYAN,Color.MAGENTA};
	
	public ChartPieService(Context context){
		this.context = context;
	}
	
	public GraphicalView getGraphicalView() {
		graphicalView = ChartFactory.getPieChartView(context, categorySeries, defaultRenderer);
		return graphicalView;
	}
	
	public CategorySeries setCategorySeries(String ChartTitle,int pmValue,int coValue,int lightValue,int humidityValue,int tempValue){
		categorySeries = new CategorySeries(ChartTitle);
		categorySeries.add("PM2.5",pmValue);
		categorySeries.add("Co2",coValue);
		categorySeries.add("����ǿ��",lightValue);
		categorySeries.add("����ʪ��",humidityValue);
		categorySeries.add("�¶�",tempValue);
		return categorySeries;
	}
	
	public void setDefaultRenderer(){
		defaultRenderer = new DefaultRenderer();
		defaultRenderer.setChartTitle("��ʷ--������ֵ");
		defaultRenderer.setShowLegend(false);
		defaultRenderer.setZoomButtonsVisible(false);
		defaultRenderer.setPanEnabled(false);
		defaultRenderer.setChartTitleTextSize(30);
		defaultRenderer.setDisplayValues(true);
		defaultRenderer.setClickEnabled(true);
		defaultRenderer.setLabelsColor(Color.BLACK);
		defaultRenderer.setLabelsTextSize(25);
		for(int color:colors){
			simpleSeriesRenderer = new SimpleSeriesRenderer();
			simpleSeriesRenderer.setColor(color);
			defaultRenderer.addSeriesRenderer(simpleSeriesRenderer);
		}
	}
	
}
