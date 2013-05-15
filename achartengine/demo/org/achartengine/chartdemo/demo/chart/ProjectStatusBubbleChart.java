/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.achartengine.chartdemo.demo.chart;

import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

/**
 * Project status demo bubble chart.
 */
public class ProjectStatusBubbleChart extends AbstractDemoChart {
  /**
   * Returns the chart name.
   * 
   * @return the chart name
   */
  public String getName() {
    return "Project tickets status";
  }

  /**
   * Returns the chart description.
   * 
   * @return the chart description
   */
  public String getDesc() {
    return "The opened tickets and the fixed tickets (bubble chart)";
  }

  /**
   * Executes the chart demo.
   * 
   * @param context the context
   * @return the built intent
   */
  public Intent execute(Context context) {
    XYMultipleSeriesDataset series = new XYMultipleSeriesDataset();
    XYValueSeries newTicketSeries = new XYValueSeries("New Tickets");
    newTicketSeries.add(1f, 2, 14);
    newTicketSeries.add(2f, 2, 12);
    newTicketSeries.add(3f, 2, 18);
    newTicketSeries.add(4f, 2, 5);
    newTicketSeries.add(5f, 2, 1);
    series.addSeries(newTicketSeries);
    XYValueSeries fixedTicketSeries = new XYValueSeries("Fixed Tickets");
    fixedTicketSeries.add(1f, 1, 7);
    fixedTicketSeries.add(2f, 1, 4);
    fixedTicketSeries.add(3f, 1, 18);
    fixedTicketSeries.add(4f, 1, 3);
    fixedTicketSeries.add(5f, 1, 1);
    series.addSeries(fixedTicketSeries);

    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
    renderer.setAxisTitleTextSize(16);
    renderer.setChartTitleTextSize(20);
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[] { 20, 30, 15, 0 });
    XYSeriesRenderer newTicketRenderer = new XYSeriesRenderer();
    newTicketRenderer.setColor(Color.BLUE);
    renderer.addSeriesRenderer(newTicketRenderer);
    XYSeriesRenderer fixedTicketRenderer = new XYSeriesRenderer();
    fixedTicketRenderer.setColor(Color.GREEN);
    renderer.addSeriesRenderer(fixedTicketRenderer);

    setChartSettings(renderer, "Project work status", "Priority", "", 0.5, 5.5, 0, 5, Color.GRAY,
        Color.LTGRAY);
    renderer.setXLabels(7);
    renderer.setYLabels(0);
    renderer.setShowGrid(false);
    return ChartFactory.getBubbleChartIntent(context, series, renderer, "Project tickets");
  }

}
