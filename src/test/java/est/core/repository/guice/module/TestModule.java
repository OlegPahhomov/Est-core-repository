package est.core.repository.guice.module;

import com.google.inject.AbstractModule;

import est.core.repository.common.test.ResourceIntegrationTestBase;
import est.core.repository.guice.GuiceInjector.Module;

@Module()
public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(ResourceIntegrationTestBase.class);
    }
}
