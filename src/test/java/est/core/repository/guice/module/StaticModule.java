package est.core.repository.guice.module;

import com.google.inject.AbstractModule;

import est.core.repository.guice.GuiceInjector.Module;
import est.core.repository.server.EmbeddedJettyTest;

@Module
public class StaticModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(EmbeddedJettyTest.class);
    }
}
