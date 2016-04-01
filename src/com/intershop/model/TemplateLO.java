package com.intershop.model;

public class TemplateLO {

	private int organisationid;
	private int templateid;
	private String templateversion;
	private String templatename;
	private String templatetypename;

	public int getOrganisationid() {
		return organisationid;
	}

	public void setOrganisationid(int organisationid) {
		this.organisationid = organisationid;
	}

	public int getTemplateid() {
		return templateid;
	}

	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}

	public String getTemplateversion() {
		return templateversion;
	}

	public void setTemplateversion(String templateversion) {
		this.templateversion = templateversion;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getTemplatetypename() {
		return templatetypename;
	}

	public void setTemplatetypename(String templatetypename) {
		this.templatetypename = templatetypename;
	}

	public TemplateLO(int organisationid, int templateid, String templateversion, String templatename,
			String templatetypename) {
		super();
		this.organisationid = organisationid;
		this.templateid = templateid;
		this.templateversion = templateversion;
		this.templatename = templatename;
		this.templatetypename = templatetypename;
	}

	public TemplateLO() {
	}

}
