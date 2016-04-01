package com.intershop.resource;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intershop.business.TemplateService;
import com.intershop.model.Organisation;
import com.intershop.model.TemplateLO;
import com.intershop.model.User;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/template")
@Singleton
public class TemplateResource {

	@Inject
	private TemplateService TSI;

	@GET
	@Path(value = "/Organisationlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Organisation> getOrgansiationList() {
		return TSI.getOrganisationList();
	}

	@GET
	@Path(value = "/userlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() throws Exception {
		return TSI.getUserList();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBuilder uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		TSI.uploadFile(uploadedInputStream, fileDetail);
		return Response.ok();
	}

	@GET
	@Path(value = "/Organisation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Organisation getOrganisation(@PathParam("id") long id) {
		return TSI.getOrganisationById(id);
	}

	@GET
	@Path(value = "/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<TemplateLO> getTemplateList() throws Exception {
		return TSI.getTemplateList();
	}

	@POST
	@Path(value = "/Add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public TemplateLO AddTemplate(TemplateLO templateLO) throws Exception {
		return TSI.addTemplate(templateLO);
	}
}
