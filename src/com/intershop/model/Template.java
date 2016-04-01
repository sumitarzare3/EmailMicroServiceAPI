package com.intershop.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Template")
public class Template {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	private String version;

	@Column
	private String name;

	@Column
	private Date creationDate;

	@Column
	private Date modificationDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "organisationRef", insertable = false, updatable = false)
	private Organisation organisation;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "template", cascade = CascadeType.ALL)
	private Body body;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "template", cascade = CascadeType.ALL)
	private Subject subject;

	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Template(int id, String version, String name, Date creationDate, Date modificationDate) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Template [id=" + id + ", version=" + version + ", name=" + name + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + "]";
	}



}
