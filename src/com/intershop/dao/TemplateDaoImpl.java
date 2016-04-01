package com.intershop.dao;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import com.intershop.model.Body;
import com.intershop.model.Organisation;
import com.intershop.model.TemplateLO;
import com.intershop.model.User;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

@Transactional
@Singleton
public class TemplateDaoImpl implements TemplateDao {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<Organisation> getOrganisationList() {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT * FROM \"Organisation\"", "OrderResults");
		@SuppressWarnings("unchecked")
		List<Organisation> results = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();

		List<Organisation> metaList = new ArrayList<Organisation>();
		for (Organisation orglist : results) {
			Organisation organisation = new Organisation();
			organisation.setId(orglist.getId());
			organisation.setName(orglist.getName());
			organisation.setCreationDate(orglist.getCreationDate());
			organisation.setModificationDate(orglist.getModificationDate());
			metaList.add(organisation);
		}
		return metaList;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT * FROM \"User\"", "Resultset");
		@SuppressWarnings("unchecked")
		List<User> results = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();

		List<User> metaList = new ArrayList<User>();
		for (User usrlist : results) {
			User user = new User();
			user.setId(usrlist.getId());
			user.setName(usrlist.getName());
			user.setCreationDate(usrlist.getCreationDate());
			user.setModificationDate(usrlist.getModificationDate());
			metaList.add(user);
		}
		return metaList;
	}


	@SuppressWarnings("resource")
	@Override
	public Response uploadFile(InputStream uploadedInputStream, FormDataContentDisposition fileDetail) {

		FormDataMultiPart form = new FormDataMultiPart();

		entityManager.getTransaction().begin();
		Body body = new Body();

		File fileToUpload = new File("D:/Intershop Project/Templates/footlocker_cancelMessage_custom_request.vm");
		FormDataMultiPart multiPart = new FormDataMultiPart();
		if (fileToUpload != null) {
			FileDataBodyPart fileDataBodyPart = (new FileDataBodyPart("file", fileToUpload,
					MediaType.APPLICATION_OCTET_STREAM_TYPE));
			multiPart.bodyPart(fileDataBodyPart);
		}

		entityManager.persist(multiPart);

		return null;
		// http://howtodoinjava.com/2013/08/30/hibernate-example-of-insertselect-blob-from-database/
	}

	@Override
	public List<TemplateLO> getTemplateList() throws Exception {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<TemplateLO> templateList = entityManager.createNativeQuery("select * from OrganisationDao")
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return templateList;
	}

	@Override
	public TemplateLO addTemplate(TemplateLO templateLO) throws Exception {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		TemplateLO tlo = new TemplateLO();
		tlo.equals(templateLO);
		entityManager.persist(tlo);
		entityManager.getTransaction().commit();
		entityManager.close();
		return null;
	}

	@Override
	public TemplateLO getTemplateById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTemplate(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organisation getOrganisationById(long id) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		Organisation organisation = null;
		Query query = entityManager.createNativeQuery("SELECT * FROM \"Organisation\" org where org.id=id",
 "OrderResults");
		Organisation  results = (Organisation) query.getSingleResult();
			organisation = new Organisation();
		organisation.getId();
		organisation.getName();
		organisation.getCreationDate();
		organisation.getModificationDate();

		return organisation;
	}


}
