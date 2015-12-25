package com.Achart;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import android.R.integer;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class ChartBarSeries {

	private GraphicalView chartBarView;
	private XYMultipleSeriesDataset dataset;
	private XYMultipleSeriesRenderer renderer;
	private CategorySeries categorySeries;
	private XYSeries xySeries;
	private SimpleSeriesRenderer simpleSeriesRenderer;
	private Context context;
	
	public ChartBarSeries(Context context) {
		this.context = context;
	}
	
	public GraphicalView getChartBarView() {
		chartBarView = ChartFactory.getBarChartView(context, dataset, renderer,Type.DEFAULT);
		return chartBarView;
	}
	
	public XYMultipleSeriesDataset setDataset(ArrayList<Integer> list) {
		Random r = new Random();
		dataset = new XYMultipleSeriesDataset();
		xySeries = new XYSeries("柱状图单例");
		for(int i=0;i<list.size()-1;i++){
			xySeries.add(i+1,list.get(i));
		}
		dataset.addSeries(xySeries);
//		categorySeries = new CategorySeries("示例：");
//		for(int i=0;i<10;i++){
//			categorySeries.add(100+r.nextInt()%100);
//		}
//		dataset.addSeries(categorySeries.toXYSeries());
		return dataset;
	}
	
	public XYMultipleSeriesRenderer setRenderer(int YAxisMax) {
		renderer = new XYMultipleSeriesRenderer();
		renderer.setChartTitle("柱状图示例");
		renderer.setXTitle("时间");
		renderer.setYTitle("历史数据");
		renderer.setXAxisMin(0);
        renderer.setXAxisMax(10);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(YAxisMax);
        renderer.setZoomButtonsVisible(false);
        renderer.setPanEnabled(false);
        renderer.setBarSpacing(0.5);
        renderer.setBarWidth(30);
        renderer.setLabelsColor(Color.RED);
        renderer.setLabelsTextSize(25);
        renderer.setAxesColor(Color.RED);
        renderer.setMarginsColor(Color.GRAY);
		simpleSeriesRenderer = new SimpleSeriesRenderer();
		simpleSeriesRenderer.setDisplayChartValues(true);
		simpleSeriesRenderer.setChartValuesTextSize(20);
		simpleSeriesRenderer.setChartValuesTextAlign(Align.RIGHT);
		simpleSeriesRenderer.setColor(Color.GREEN);
		renderer.addSeriesRenderer(simpleSeriesRenderer);
		return renderer;
	}
	
}
