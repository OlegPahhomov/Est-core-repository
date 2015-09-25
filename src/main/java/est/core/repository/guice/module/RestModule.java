package est.core.repository.guice.module;

import com.google.inject.servlet.ServletModule;

import est.core.repository.guice.GuiceInjector;
import est.core.repository.service.MaterialService;

@GuiceInjector.Module
public class RestModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(MaterialService.class);
    }
}
