package allure.piechart.telegram.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.checkerframework.checker.units.qual.Time;


import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Summary {
	@JsonProperty("reportName")
	private String reportName;
	@JsonProperty("testRuns")
	private List<Object> testRuns = null;
	@JsonProperty("statistic")
	private Statistic statistic;
	@JsonProperty("time")
	private Time time;

	public Summary() {
	}

	@JsonProperty("reportName")
	public String getReportName() {
		return this.reportName;
	}

	@JsonProperty("testRuns")
	public List<Object> getTestRuns() {
		return this.testRuns;
	}

	@JsonProperty("statistic")
	public Statistic getStatistic() {
		return this.statistic;
	}

	@JsonProperty("time")
	public Time getTime() {
		return this.time;
	}
}