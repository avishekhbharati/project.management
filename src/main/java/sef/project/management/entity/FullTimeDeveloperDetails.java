package sef.project.management.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(FullTimeDeveloperDetails.class)
@Table(name = "FULL_TIME_DEVELOPER_DETAILS")
public class FullTimeDeveloperDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Id
	@Column(name = "BLOCKED_WEEK", nullable = false)
	private Integer blockedWeek;

	@Id
	@Column(name = "BLOCK_TYPE", nullable = false)
	private Integer blockType;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBlockedWeek() {
		return blockedWeek;
	}

	public void setBlockedWeek(Integer blockedWeek) {
		this.blockedWeek = blockedWeek;
	}

	public Integer getBlockType() {
		return blockType;
	}

	public void setBlockType(Integer blockType) {
		this.blockType = blockType;
	}

}
