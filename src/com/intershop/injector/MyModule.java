package com.intershop.injector;

import com.google.inject.persist.jpa.JpaPersistModule;
import com.intershop.business.TemplateService;
import com.intershop.business.TemplateServiceImpl;
import com.intershop.dao.TemplateDao;
import com.intershop.dao.TemplateDaoImpl;
import com.intershop.resource.TemplateResource;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class MyModule extends JerseyServletModule {

	@Override
	protected void configureServlets() {
		install(new JpaPersistModule("EmailMicroServiceAPI"));
		bind(TemplateResource.class);
		bind(TemplateDao.class).to(TemplateDaoImpl.class);
		bind(TemplateService.class).to(TemplateServiceImpl.class);
		serve("/*").with(GuiceContainer.class);
	}
}
