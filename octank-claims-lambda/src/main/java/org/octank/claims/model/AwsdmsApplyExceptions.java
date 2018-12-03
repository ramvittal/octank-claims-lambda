package org.octank.claims.model;
// Generated Nov 28, 2018 2:11:05 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AwsdmsApplyExceptions generated by hbm2java
 */
@Entity
@Table(name = "awsdms_apply_exceptions", catalog = "awsdms_control")
public class AwsdmsApplyExceptions implements java.io.Serializable {

	private AwsdmsApplyExceptionsId id;

	public AwsdmsApplyExceptions() {
	}

	public AwsdmsApplyExceptions(AwsdmsApplyExceptionsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "taskName", column = @Column(name = "TASK_NAME", nullable = false, length = 128)),
			@AttributeOverride(name = "tableOwner", column = @Column(name = "TABLE_OWNER", nullable = false, length = 128)),
			@AttributeOverride(name = "tableName", column = @Column(name = "TABLE_NAME", nullable = false, length = 128)),
			@AttributeOverride(name = "errorTime", column = @Column(name = "ERROR_TIME", nullable = false, length = 26)),
			@AttributeOverride(name = "statement", column = @Column(name = "STATEMENT", nullable = false, length = 65535)),
			@AttributeOverride(name = "error", column = @Column(name = "ERROR", nullable = false, length = 65535)) })
	public AwsdmsApplyExceptionsId getId() {
		return this.id;
	}

	public void setId(AwsdmsApplyExceptionsId id) {
		this.id = id;
	}

}
