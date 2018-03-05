package de.codeboje.springbootbook.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "comments_model", indexes = { @Index(name = "idx_pageId", columnList = "pageId") })
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3803809968249868734L;

	@Id
	@Column(length = 36)
	private String id;

	@Version
	private Integer version;

	private Instant lastModificationDate;

	private Instant creationDate;

	@Column(length = 32)
	private String pageId;

	@Column(length = 32)
	private String userName;

	@Column(length = 32)
	private String emailAddress;

	@Column
	private boolean spam;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isSpam() {
		return spam;
	}

	public void setSpam(boolean spam) {
		this.spam = spam;
	}

	public Instant getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Instant lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

}
