package com.Achart;

import java.util.ArrayList;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Style;

public class ChartLineSeries {

	private GraphicalView graphicalView;
	private XYMultipleSeriesDataset dataset;
	private XYMultipleSeriesRenderer renderer;
	private XYSeries xySeries;
	private XYSeriesRenderer xySeriesRenderer;
	private Context context;
	
	public ChartLineSeries(Context context) {
		this.context = context;
	}
	
	public GraphicalView getGraphicalView() {
		graphicalView = ChartFactory.getLineChartView(context, dataset, renderer);
		return graphicalView;
	}
	
	public XYMultipleSeriesDataset setDataSet(ArrayList<Integer> list){
		dataset = new XYMultipleSeriesDataset();
		xySeries = new XYSeries("历史数据");
		for(int i=0;i<list.size();i++){
			xySeries.add(i,list.get(i));
		}
		dataset.addSeries(xySeries);
		return dataset;
	}
	
	public XYMultipleSeriesRenderer setRendererSet(int color){
		renderer = new XYMultipleSeriesRenderer();
		renderer.setBackgroundColor(color);
		renderer.setXTitle("时间");
		renderer.setYTitle("历史数据");
		renderer.setAxesColor(Color.RED);
		renderer.setMarginsColor(Color.GRAY);
		renderer.setLabelsColor(Color.GREEN);
		renderer.setXLabelsColor(Color.BLACK);
		renderer.setYLabelsColor(0,Color.BLACK);
		renderer.setLabelsTextSize(20);
		renderer.setXAxisMax(10);
		renderer.setXAxisMin(0);
		renderer.setYAxisMin(0);
		renderer.setPointSize(11);
		renderer.setZoomEnabled(false, false);
		xySeriesRenderer = new XYSeriesRenderer();
		xySeriesRenderer.setColor(Color.GREEN);
		xySeriesRenderer.setDisplayChartValues(true);
		xySeriesRenderer.setPointStyle(PointStyle.CIRCLE);
		xySeriesRenderer.setChartValuesTextSize(25);
		xySeriesRenderer.setFillPoints(true);
		renderer.addSeriesRenderer(xySeriesRenderer);
		return renderer;
	}
}
