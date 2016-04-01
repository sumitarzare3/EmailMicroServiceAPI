package com.intershop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Body")
public class Body implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String messageType;
	private String fileName;
	private String locale;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] fileBody;
	private Date creationDate;
	private Date modificationDate;
	private Date templateValidFrom;
	private Date tempalteValidTo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "templateRef", insertable = false, updatable = false)
	private Template template;

	public Body() {
		// TODO Auto-generated constructor stub
	}

	public Body(int id, String messageType, String fileName, String locale, byte[] fileBody, Date creationDate,
			Date modificationDate, Date templateValidFrom, Date tempalteValidTo) {
		super();
		this.id = id;
		this.messageType = messageType;
		this.fileName = fileName;
		this.locale = locale;
		this.fileBody = fileBody;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.templateValidFrom = templateValidFrom;
		this.tempalteValidTo = tempalteValidTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public byte[] getFileBody() {
		return fileBody;
	}

	public void setFileBody(byte[] fileBody) {
		this.fileBody = fileBody;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getTemplateValidFrom() {
		return templateValidFrom;
	}

	public void setTemplateValidFrom(Date templateValidFrom) {
		this.templateValidFrom = templateValidFrom;
	}

	public Date getTempalteValidTo() {
		return tempalteValidTo;
	}

	public void setTempalteValidTo(Date tempalteValidTo) {
		this.tempalteValidTo = tempalteValidTo;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Body [id=" + id + ", messageType=" + messageType + ", fileName=" + fileName + ", locale=" + locale
				+ ", fileBody=" + fileBody + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
				+ ", templateValidFrom=" + templateValidFrom + ", tempalteValidTo=" + tempalteValidTo + "]";
	}

}
