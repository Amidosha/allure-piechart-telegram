package allure.piechart.telegram.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Statistic {
	@JsonProperty("failed")
	private Integer failed;
	@JsonProperty("broken")
	private Integer broken;
	@JsonProperty("skipped")
	private Integer skipped;
	@JsonProperty("passed")
	private Integer passed;
	@JsonProperty("unknown")
	private Integer unknown;
	@JsonProperty("total")
	private Integer total;

	public Statistic() {
	}

	@JsonProperty("failed")
	public Integer getFailed() {
		return this.failed;
	}

	@JsonProperty("broken")
	public Integer getBroken() {
		return this.broken;
	}

	@JsonProperty("skipped")
	public Integer getSkipped() {
		return this.skipped;
	}

	@JsonProperty("passed")
	public Integer getPassed() {
		return this.passed;
	}

	@JsonProperty("unknown")
	public Integer getUnknown() {
		return this.unknown;
	}

	@JsonProperty("total")
	public Integer getTotal() {
		return this.total;
	}
}
