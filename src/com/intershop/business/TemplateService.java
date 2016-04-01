package com.intershop.business;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Response;

import com.intershop.model.Organisation;
import com.intershop.model.TemplateLO;
import com.intershop.model.User;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

public interface TemplateService {

	public List<Organisation> getOrganisationList();

	public List<User> getUserList();

	public List<TemplateLO> getTemplateList() throws Exception;

	public TemplateLO addTemplate(TemplateLO templateLO) throws Exception;

	public TemplateLO getTemplateById(long id) throws Exception;

	public boolean deleteTemplate(long id) throws Exception;

	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail);

	public Organisation getOrganisationById(long id);
}
