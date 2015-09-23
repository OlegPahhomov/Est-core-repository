package est.core.repository.guice.module;

import javax.ws.rs.client.Client;

import org.apache.commons.configuration.Configuration;

import com.google.inject.AbstractModule;

import est.core.repository.guice.GuiceInjector.Module;
import est.core.repository.guice.provider.ConfigurationProvider;
import est.core.repository.guice.provider.HttpClientProvider;

@Module
public class ProviderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Configuration.class).toProvider(ConfigurationProvider.class);
        bind(Client.class).toProvider(HttpClientProvider.class);
    }
}
