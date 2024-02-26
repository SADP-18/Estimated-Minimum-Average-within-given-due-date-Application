package gui;
import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import constants.CommonConstants;

public class LineGraphGUI extends JFrame {
    public LineGraphGUI() {
        super("Line Graph Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addChartPanel();
    }

    private void addChartPanel() {
        // Sample data
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {10, 7, 5, 2, 8};

        // Create a dataset
        XYSeries series = new XYSeries("Line 1");
        for (int i = 0; i < x.length; i++) {
            series.add(x[i], y[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Line",
                "Time Progression",
                "Goal Progression",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        // Customize the chart
        chart.getXYPlot().getRenderer().setSeriesPaint(0, Color.BLUE);

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));

        // Add the chart panel to the frame
        add(chartPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LineGraphGUI().setVisible(true);
            }
        });
    }
}
