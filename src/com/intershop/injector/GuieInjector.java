package com.intershop.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuieInjector extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(new MyModule());
		injector.getInstance(JPAInitializer.class);
		return injector;
	}

}
