package est.core.repository.service;

import static est.core.repository.utils.ConfigurationProperties.KEYSTORE_FILENAME;
import static est.core.repository.utils.ConfigurationProperties.KEYSTORE_PASSWORD;
import static est.core.repository.utils.ConfigurationProperties.KEYSTORE_SIGNING_ENTITY_ID;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;

import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.json.JSONObject;

import est.core.repository.security.KeyStoreUtils;
import est.core.repository.utils.EncryptionUtils;


/**
 * Created by mart on 20.10.15.
 */

public class UserValidationService {

    @Inject
    private Configuration configuration;

    public boolean validateUser(String signedUserData) throws KeyStoreException {
        byte[] bytes = Base64.decodeBase64(signedUserData);
        KeyStore keyStore = KeyStoreUtils.loadKeystore(configuration.getString(KEYSTORE_FILENAME), configuration.getString(KEYSTORE_PASSWORD));
        Certificate certificate = keyStore.getCertificate(configuration.getString(KEYSTORE_SIGNING_ENTITY_ID));

        String userData = EncryptionUtils.decrypt(bytes, certificate.getPublicKey());

        try {
            JSONObject userDataObject = new JSONObject(userData);
            String createdAt = userDataObject.getString("createdAt");

            //validating if the json object has a date
            return createdAt.length() > 0;

        } catch (Exception e) {
            //object has no creation date or is broken
            throw new RuntimeException("The user data is not a valid json object.");
        }
    }
}
