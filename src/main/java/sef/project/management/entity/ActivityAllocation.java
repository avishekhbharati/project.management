package sef.project.management.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ActivityAllocation.class)
@Table(name = "ACTIVITY_ALLOCATION")
public class ActivityAllocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACTIVITY_ID")
	private Activity activity;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "INVOLVEMENT_RATE", nullable = false)
	private Integer involvementRate;

	@Column(name = "START_WEEK", nullable = true)
	private Integer startWeek;

	@Column(name = "END_WEEK", nullable = true)
	private Integer endWeek;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
