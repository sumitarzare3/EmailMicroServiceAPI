package com.intershop.business;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intershop.dao.TemplateDao;
import com.intershop.model.Organisation;
import com.intershop.model.TemplateLO;
import com.intershop.model.User;
import com.sun.jersey.core.header.FormDataContentDisposition;

@Singleton
public class TemplateServiceImpl implements TemplateService {

	private TemplateDao templateDao;
	@Inject
	public TemplateServiceImpl(TemplateDao templateDao) {

		this.templateDao = templateDao;
	}

	@Override
	public List<Organisation> getOrganisationList() {
		// TODO Auto-generated method stub
		return templateDao.getOrganisationList();
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return templateDao.getUserList();
	}

	@Override
	public List<TemplateLO> getTemplateList() throws Exception {
		// TODO Auto-generated method stub
		return templateDao.getTemplateList();
	}

	@Override
	public TemplateLO addTemplate(TemplateLO templateLO) throws Exception {
		// TODO Auto-generated method stub
		return templateDao.addTemplate(templateLO);
	}

	@Override
	public TemplateLO getTemplateById(long id) throws Exception {
		// TODO Auto-generated method stub
		return templateDao.getTemplateById(id);
	}

	@Override
	public boolean deleteTemplate(long id) throws Exception {
		// TODO Auto-generated method stub
		return templateDao.deleteTemplate(id);
	}

	@Override
	public Response uploadFile(InputStream uploadedInputStream, FormDataContentDisposition fileDetail) {
		// TODO Auto-generated method stub
		return templateDao.uploadFile(uploadedInputStream, fileDetail);
	}

	@Override
	public Organisation getOrganisationById(long id) {
		// TODO Auto-generated method stub
		return templateDao.getOrganisationById(id);
	}


}


