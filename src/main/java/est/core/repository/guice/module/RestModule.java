package est.core.repository.guice.module;

import org.opensaml.saml2.binding.encoding.HTTPRedirectDeflateEncoder;

import com.google.inject.servlet.ServletModule;

import est.core.repository.guice.GuiceInjector;
import est.core.repository.service.MaterialService;

@GuiceInjector.Module
public class RestModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(HTTPRedirectDeflateEncoder.class);
        bind(MaterialService.class);
    }
}
