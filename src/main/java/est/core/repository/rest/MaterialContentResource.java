package est.core.repository.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by mart on 2.10.15.
 */

@Path("materialContent")
public class MaterialContentResource {

    @Context
    private HttpServletResponse response;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public void get() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Star_Wars";
        response.sendRedirect(response.encodeRedirectURL(url));
    }
}
