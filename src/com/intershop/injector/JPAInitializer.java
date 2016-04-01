package com.intershop.injector;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

@Singleton
public class JPAInitializer {

	@Inject
	JPAInitializer(PersistService service) {
		service.start();
	}
}