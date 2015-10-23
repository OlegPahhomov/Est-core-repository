package est.core.repository.rest;

import est.core.repository.service.UserValidationService;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.KeyStoreException;

/**
 * Created by mart on 2.10.15.
 */

@Path("repoMaterialSource")
public class MaterialContentResource {

    @Inject
    private UserValidationService userValidationService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get(@QueryParam("id") String id, @QueryParam("dop_token") @Encoded String signedUserData) throws IOException, SAXException, ParserConfigurationException, KeyStoreException, URISyntaxException {
        signedUserData = URLDecoder.decode(signedUserData, "UTF-8");

        if (!userValidationService.validateUser(signedUserData)) {
            throw new RuntimeException("This user is not permitted to access these materials");
        }
        URI location = new URI("https://en.wikipedia.org/wiki/Star_Wars");

        return Response.temporaryRedirect(location).build();
    }
}
