package org.octank.claims.model;
// Generated Nov 28, 2018 2:11:05 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AwsdmsApplyExceptionsId generated by hbm2java
 */
@Embeddable
public class AwsdmsApplyExceptionsId implements java.io.Serializable {

	private String taskName;
	private String tableOwner;
	private String tableName;
	private Date errorTime;
	private String statement;
	private String error;

	public AwsdmsApplyExceptionsId() {
	}

	public AwsdmsApplyExceptionsId(String taskName, String tableOwner, String tableName, Date errorTime,
			String statement, String error) {
		this.taskName = taskName;
		this.tableOwner = tableOwner;
		this.tableName = tableName;
		this.errorTime = errorTime;
		this.statement = statement;
		this.error = error;
	}

	@Column(name = "TASK_NAME", nullable = false, length = 128)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "TABLE_OWNER", nullable = false, length = 128)
	public String getTableOwner() {
		return this.tableOwner;
	}

	public void setTableOwner(String tableOwner) {
		this.tableOwner = tableOwner;
	}

	@Column(name = "TABLE_NAME", nullable = false, length = 128)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "ERROR_TIME", nullable = false, length = 26)
	public Date getErrorTime() {
		return this.errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	@Column(name = "STATEMENT", nullable = false, length = 65535)
	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Column(name = "ERROR", nullable = false, length = 65535)
	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AwsdmsApplyExceptionsId))
			return false;
		AwsdmsApplyExceptionsId castOther = (AwsdmsApplyExceptionsId) other;

		return ((this.getTaskName() == castOther.getTaskName()) || (this.getTaskName() != null
				&& castOther.getTaskName() != null && this.getTaskName().equals(castOther.getTaskName())))
				&& ((this.getTableOwner() == castOther.getTableOwner()) || (this.getTableOwner() != null
						&& castOther.getTableOwner() != null && this.getTableOwner().equals(castOther.getTableOwner())))
				&& ((this.getTableName() == castOther.getTableName()) || (this.getTableName() != null
						&& castOther.getTableName() != null && this.getTableName().equals(castOther.getTableName())))
				&& ((this.getErrorTime() == castOther.getErrorTime()) || (this.getErrorTime() != null
						&& castOther.getErrorTime() != null && this.getErrorTime().equals(castOther.getErrorTime())))
				&& ((this.getStatement() == castOther.getStatement()) || (this.getStatement() != null
						&& castOther.getStatement() != null && this.getStatement().equals(castOther.getStatement())))
				&& ((this.getError() == castOther.getError()) || (this.getError() != null
						&& castOther.getError() != null && this.getError().equals(castOther.getError())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTaskName() == null ? 0 : this.getTaskName().hashCode());
		result = 37 * result + (getTableOwner() == null ? 0 : this.getTableOwner().hashCode());
		result = 37 * result + (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result + (getErrorTime() == null ? 0 : this.getErrorTime().hashCode());
		result = 37 * result + (getStatement() == null ? 0 : this.getStatement().hashCode());
		result = 37 * result + (getError() == null ? 0 : this.getError().hashCode());
		return result;
	}

}