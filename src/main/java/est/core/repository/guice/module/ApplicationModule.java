package est.core.repository.guice.module;

import com.google.inject.AbstractModule;

import est.core.repository.ApplicationLauncher;
import est.core.repository.ApplicationManager;
import est.core.repository.guice.GuiceInjector.Module;

@Module
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(ApplicationLauncher.class);
        requestStaticInjection(ApplicationManager.class);
    }
}
