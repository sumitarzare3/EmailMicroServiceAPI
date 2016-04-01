package com.intershop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@SqlResultSetMapping(name = "Resultset", entities = { @EntityResult(entityClass = User.class) })
//}, fields = {
//		@FieldResult(name = "id", column = "id"), @FieldResult(name = "name", column = "name"),
//		@FieldResult(name = "creationDate", column = "creationDate"),
//		@FieldResult(name = "modificationDate", column = "modificationDate"),
//		@FieldResult(name = "password", column = "password") }) })
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "creationDate")
	private Date creationDate;

	@Column(name = "modificationDate")
	private Date modificationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organisationRef", insertable = false, updatable = false, nullable = false)
	private Organisation organisation;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<TemplateType> templateType;


	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String password, Date creationDate, Date modificationDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + "]";
	}

	// public Set<TemplateType> getTemplateType() {
	// return templateType;
	// }
	//
	// public void setTemplateType(Set<TemplateType> templateType) {
	// this.templateType = templateType;
	// }


}
