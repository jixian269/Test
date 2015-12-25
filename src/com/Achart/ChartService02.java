package com.Achart;

import java.util.ArrayList;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.Bean.pmPerson;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class ChartService02 {

	private GraphicalView chartView;
	private XYMultipleSeriesDataset dataSeries;
	private XYMultipleSeriesRenderer rendererSeries;
	private XYSeries xySeries;
	private XYSeriesRenderer xySeriesRenderer;
	private Context context;
	private int x = 0;
	private ArrayList xyList = new ArrayList();
	
	public ChartService02(Context context) {
		this.context = context;
	}
	
	
	public GraphicalView getGraphicalView(){
		chartView = ChartFactory.getLineChartView(context,dataSeries,rendererSeries);
		return chartView;
	}
	
	public void setXYMultipleSeriesDataset(String CurveTitle){
		dataSeries = new XYMultipleSeriesDataset();
		xySeries = new XYSeries(CurveTitle);
		dataSeries.addSeries(xySeries);
	}
	
	public void setXYMultipleSeriesRenderer(double maxX,double maxY,String ChartTitle,
			String xTitle,String yTitle,int xyColor,int labelColor,int curveColor,int gridColor){
		rendererSeries = new XYMultipleSeriesRenderer();
		if(ChartTitle!=null){
			rendererSeries.setChartTitle(ChartTitle);
		}
//		rendererSeries.setXTitle(xTitle);
//		rendererSeries.setYTitle(yTitle);
//		rendererSeries.setRange(new double[]{0,maxX,0,maxY});//XY轴的范围
//		rendererSeries.setLabelsColor(labelColor);
//		rendererSeries.setXLabels(10);//标题大小
//		rendererSeries.setYLabels(10);
//		rendererSeries.setXLabelsAlign(Align.RIGHT);
//		rendererSeries.setXLabelsAlign(Align.RIGHT);
//		rendererSeries.setAxisTitleTextSize(20);
//		rendererSeries.setChartTitleTextSize(20);
//		rendererSeries.setPointSize(5);
//		rendererSeries.setZoomButtonsVisible(false);
//		rendererSeries.setZoomEnabled(true,false);
//		rendererSeries.setPanEnabled(true,false);
//		rendererSeries.setShowGrid(true);
//		rendererSeries.setAxesColor(xyColor);
//		rendererSeries.setLabelsColor(labelColor);
//		rendererSeries.setGridColor(gridColor);
//		rendererSeries.setMargins(new int[] { 20, 30, 15, 20 });//边距
//		rendererSeries.setMarginsColor(Color.WHITE);
//		rendererSeries.setBackgroundColor(Color.WHITE);
//		xySeriesRenderer = new XYSeriesRenderer();
//		xySeriesRenderer.setColor(curveColor);
//		xySeriesRenderer.setPointStyle(PointStyle.CIRCLE);
//		xySeriesRenderer.setDisplayChartValues(true);
//		xySeriesRenderer.setFillPoints(true);
//		xySeriesRenderer.setChartValuesTextSize(20);
//		rendererSeries.addSeriesRenderer(xySeriesRenderer);
		rendererSeries.setXTitle(xTitle);
		rendererSeries.setYTitle(yTitle);
		rendererSeries.setLabelsColor(labelColor);
		rendererSeries.setXLabels(10);
		rendererSeries.setYLabels(10);
		rendererSeries.setXAxisMax(maxX);
		rendererSeries.setXAxisMin(0);
		rendererSeries.setXLabelsAlign(Align.RIGHT);
		rendererSeries.setYLabelsAlign(Align.RIGHT);
        rendererSeries.setAxisTitleTextSize(20);
        rendererSeries.setChartTitleTextSize(20);
        rendererSeries.setLabelsTextSize(25);
        rendererSeries.setYLabelsColor(0, Color.RED);
        rendererSeries.setXLabelsColor(Color.RED);
        rendererSeries.setLegendTextSize(20);
        rendererSeries.setPointSize(10);//曲线描点尺寸
        rendererSeries.setFitLegend(true);
        rendererSeries.setMargins(new int[] { 20, 30, 15, 20 });
        rendererSeries.setShowGrid(true);
        rendererSeries.setPanEnabled(false,true);
        rendererSeries.setAxesColor(xyColor);
        rendererSeries.setGridColor(gridColor);
        rendererSeries.setBackgroundColor(Color.WHITE);//背景色
        rendererSeries.setMarginsColor(Color.WHITE);//边距背景色，默认背景色为黑色，这里修改为白色
        xySeriesRenderer = new XYSeriesRenderer();
        xySeriesRenderer.setLineWidth(5);
        xySeriesRenderer.setColor(curveColor);
        xySeriesRenderer.setDisplayChartValues(true);
        xySeriesRenderer.setChartValuesTextSize(30);
        xySeriesRenderer.setFillPoints(true);
        xySeriesRenderer.setPointStyle(PointStyle.CIRCLE);//描点风格，可以为圆点，方形点等等
        rendererSeries.addSeriesRenderer(xySeriesRenderer);
	}
	
	public void updateChart(double y){
		pmPerson xy = new pmPerson(x,y);
		if(x>10){
			xyList.remove(0);
			xySeries.clear();
		}
		xyList.add(xy);
		x+=1;
		System.out.println(x);
		for(int i=0;i<xyList.size();i++){
			pmPerson pmXY = (pmPerson) xyList.get(i);
			xySeries.add(i,pmXY.getY());
			chartView.invalidate();
		}
	}
	
	
	
}
