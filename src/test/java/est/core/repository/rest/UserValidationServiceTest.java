package est.core.repository.rest;

import est.core.repository.common.test.ResourceIntegrationTestBase;
import est.core.repository.service.UserValidationService;
import org.junit.Test;

import javax.inject.Inject;
import java.security.KeyStoreException;

import static org.junit.Assert.assertTrue;

/**
 * Created by mart on 20.10.15.
 */
public class UserValidationServiceTest extends ResourceIntegrationTestBase {

    @Inject
    private UserValidationService userValidationService;

    @Test
    public void validateUser() throws KeyStoreException {
        //TAAT login
        assertTrue(userValidationService.validateUser("RIBN4P6dnP0D9Q1WE+WDfdGZSyRupXtFwj1Gpj7D/G+CUsbB7v9yuXqm9+Bbw4l0VysOyYKuhT+dGnmf8LLUb2DbsINxxwL48RFDo/ptq/56HnfB7nQHB0Y34d1xmDJCQXudrJllke8myXBD1P9hc3s6KDITh63pOsAJH10UCfHdL9C9tQIOFHwWYTOK8fhNKrVjjxCZaAFh4ecooFWMvlxENm1MIwcK/wxhQE3CyG1mXIZrWK1hX1miEuysrIX7aGJf5sXCY4Oqzzsn0KJK1Lxetp903KXYIsxMUBD1W/LJekukmzUVoblFZPC1KlZmDSbeCZS1uHUWtxCtHOiejA=="));
    }

}
