package sef.project.management.dto;

import java.sql.Timestamp;

public class ActivityAllocationDTO {

	private ActivityDTO allocatedActivity;
	private Integer involvementRate;
	private Timestamp startDate;
	private Timestamp endDate;
	
	public ActivityDTO getAllocatedActivity() {
		return allocatedActivity;
	}
	public void setAllocatedActivity(ActivityDTO allocatedActivity) {
		this.allocatedActivity = allocatedActivity;
	}
	public Integer getInvolvementRate() {
		return involvementRate;
	}
	public void setInvolvementRate(Integer involvementRate) {
		this.involvementRate = involvementRate;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
}