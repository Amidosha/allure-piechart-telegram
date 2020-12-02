package allure.piechart.telegram;

import allure.piechart.telegram.models.Summary;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler.LegendLayout;
import org.knowm.xchart.style.Styler.LegendPosition;

public class PieChartBuilder {
    public PieChartBuilder() {
    }

    public static PieChart getChart(Summary summaryResults, String title) {
        long failedResult = (long)summaryResults.getStatistic().getFailed();
        long brokenResult = (long)summaryResults.getStatistic().getBroken();
        long passedResult = (long)summaryResults.getStatistic().getPassed();
        long skippedResult = (long)summaryResults.getStatistic().getSkipped();
        long unknownResult = (long)summaryResults.getStatistic().getUnknown();
        PieChart chart = ((org.knowm.xchart.PieChartBuilder)((org.knowm.xchart.PieChartBuilder)((org.knowm.xchart.PieChartBuilder)(new org.knowm.xchart.PieChartBuilder()).title(title)).width(500)).height(250)).build();
        ((PieStyler)chart.getStyler()).setLegendVisible(true);
        ((PieStyler)chart.getStyler()).setLegendPosition(LegendPosition.OutsideE);
        ((PieStyler)chart.getStyler()).setLegendLayout(LegendLayout.Vertical);
        ((PieStyler)chart.getStyler()).setLegendPadding(4);
        ((PieStyler)chart.getStyler()).setLegendBorderColor(Color.WHITE);
        ((PieStyler)chart.getStyler()).setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
        ((PieStyler)chart.getStyler()).setDonutThickness(0.2D);
        ((PieStyler)chart.getStyler()).setChartPadding(0);
        ((PieStyler)chart.getStyler()).setCircular(true);
        ((PieStyler)chart.getStyler()).setPlotContentSize(0.9D);
        ((PieStyler)chart.getStyler()).setPlotBorderColor(Color.WHITE);
        ((PieStyler)chart.getStyler()).setChartBackgroundColor(Color.WHITE);
        ((PieStyler)chart.getStyler()).setSumVisible(true);
        ((PieStyler)chart.getStyler()).setSumFontSize(30.0F);
        ((PieStyler)chart.getStyler()).setDecimalPattern("#");
        List<int[]> colors = new ArrayList();
        if (passedResult != 0L) {
            chart.addSeries(passedResult + " passed", passedResult);
            colors.add(new int[]{148, 202, 102});
        }

        if (failedResult != 0L) {
            chart.addSeries(failedResult + " failed", failedResult);
            colors.add(new int[]{255, 87, 68});
        }

        if (skippedResult != 0L) {
            chart.addSeries(skippedResult + " skipped", skippedResult);
            colors.add(new int[]{170, 170, 170});
        }

        if (brokenResult != 0L) {
            chart.addSeries(brokenResult + " broken", brokenResult);
            colors.add(new int[]{255, 206, 87});
        }

        if (unknownResult != 0L) {
            chart.addSeries(unknownResult + " unknown", unknownResult);
            colors.add(new int[]{216, 97, 190});
        }

        colors.add(new int[]{0, 0, 0});
        colors.add(new int[]{0, 0, 0});
        colors.add(new int[]{0, 0, 0});
        colors.add(new int[]{0, 0, 0});
        colors.add(new int[]{0, 0, 0});
        Color[] sliceColors = new Color[]{new Color(((int[])colors.get(0))[0], ((int[])colors.get(0))[1], ((int[])colors.get(0))[2]), new Color(((int[])colors.get(1))[0], ((int[])colors.get(1))[1], ((int[])colors.get(1))[2]), new Color(((int[])colors.get(2))[0], ((int[])colors.get(2))[1], ((int[])colors.get(2))[2]), new Color(((int[])colors.get(3))[0], ((int[])colors.get(3))[1], ((int[])colors.get(3))[2]), new Color(((int[])colors.get(4))[0], ((int[])colors.get(4))[1], ((int[])colors.get(4))[2])};
        ((PieStyler)chart.getStyler()).setSeriesColors(sliceColors);
        return chart;
    }
}
