package est.core.repository.utils;

public interface ConfigurationProperties {

    // Server
    String SERVER_PORT = "server.port";
    String COMMAND_LISTENER_PORT = "command.listener.port";

    // Keystore
    String KEYSTORE_FILENAME = "keystore.filename";
    String KEYSTORE_PASSWORD = "keystore.password";
    String KEYSTORE_SIGNING_ENTITY_ID = "keystore.signingEntityID";
    String KEYSTORE_SIGNING_ENTITY_PASSWORD = "keystore.signingEntityPassword";
}
