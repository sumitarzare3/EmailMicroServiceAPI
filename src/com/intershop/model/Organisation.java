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
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Organisation")
@SqlResultSetMapping(name = "OrderResults", entities = { @EntityResult(entityClass = Organisation.class) })
// , fields = {
// @FieldResult(name = "id", column = "id"), @FieldResult(name = "name", column
// = "name"),
// @FieldResult(name = "creationDate", column = "creationDate"),
// @FieldResult(name = "modificationDate", column = "modificationDate") }) })
public class Organisation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String name;
	private Date creationDate;
	private Date modificationDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organisation", cascade = CascadeType.ALL)
	private Set<User> user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organisation", cascade = CascadeType.ALL)
	private Set<TemplateType> templateType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organisation", cascade = CascadeType.ALL)
	private Set<Template> template;

	public Organisation() {
		// TODO Auto-generated constructor stub
	}

	public Organisation(int id, String name, Date creationDate, Date modificationDate) {
		super();
		this.id = id;
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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<TemplateType> getTemplateType() {
		return templateType;
	}

	public void setTemplateType(Set<TemplateType> templateType) {
		this.templateType = templateType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organisation other = (Organisation) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate + "]";
	}

}
