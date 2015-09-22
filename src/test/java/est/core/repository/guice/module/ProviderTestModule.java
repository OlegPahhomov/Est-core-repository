package est.core.repository.guice.module;

import javax.persistence.EntityManagerFactory;
import javax.xml.soap.SOAPConnection;

import org.apache.commons.configuration.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;

import est.core.repository.guice.GuiceInjector.Module;
import est.core.repository.guice.provider.ConfigurationTestProvider;
import est.core.repository.guice.provider.EntityManagerFactoryTestProvider;
import est.core.repository.guice.provider.ObjectMapperGuiceProvider;
import est.core.repository.guice.provider.SOAPConnectionTestProvider;

@Module(override = ProviderModule.class)
public class ProviderTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EntityManagerFactory.class).toProvider(EntityManagerFactoryTestProvider.class);
        bind(Configuration.class).toProvider(ConfigurationTestProvider.class);
        bind(ObjectMapper.class).toProvider(ObjectMapperGuiceProvider.class);
        bind(SOAPConnection.class).toProvider(SOAPConnectionTestProvider.class);
    }
}
