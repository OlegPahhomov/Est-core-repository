package est.core.repository.rest;

import est.core.repository.service.MaterialService;
import est.core.repository.service.UserValidationService;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.KeyStoreException;

/**
 * Created by mart on 22.09.15.
 */
@Path("OAIHandler")
public class MaterialResource {

    private final static String GET_RECORD = "GetRecord";
    private final static String LIST_IDENTIFIERS = "ListIdentifiers";
    private final static String PATH_MATERIAL = "est_core_test_file.xml";
    private final static String PATH_IDENTIFIERS = "listIdentifiers.xml";

    @Inject
    private MaterialService materialService;

    @Inject
    private UserValidationService userValidationService;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String get(@QueryParam("verb") String verb, @QueryParam("dop_token") String signedUserData) throws IOException, SAXException, ParserConfigurationException, KeyStoreException {

        String response = null;
        System.out.println(signedUserData);
        if (!userValidationService.validateUser(signedUserData)) {
            throw new RuntimeException("This user is not permitted to access these materials");
        }

        if (verb.equals(GET_RECORD)) {
            response = materialService.readXMLfiletoString(PATH_MATERIAL);
        } else if (verb.equals(LIST_IDENTIFIERS)) {
            response = materialService.readXMLfiletoString(PATH_IDENTIFIERS);
        }

        return response;
    }
}
