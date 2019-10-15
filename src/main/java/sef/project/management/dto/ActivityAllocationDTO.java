package sef.project.management.dto;

public class ActivityAllocationDTO {

	private ActivityDTO activity;
	private Integer involvementRate;
	private Integer startWeek;
	private Integer endWeek;

	public ActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}

	public Integer getInvolvementRate() {
		return involvementRate;
	}

	public void setInvolvementRate(Integer involvementRate) {
		this.involvementRate = involvementRate;
	}

	public Integer getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(Integer startWeek) {
		this.startWeek = startWeek;
	}

	public Integer getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

}