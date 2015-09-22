package est.core.repository.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import est.core.repository.service.MaterialService;

/**
 * Created by mart on 22.09.15.
 */
@Path("material")
public class MaterialResource {

    @Inject
    private MaterialService materialService;

    @Context
    private HttpServletRequest request;

    @GET
    @Path("GetRecord")
    @Produces(MediaType.APPLICATION_XML)
    public String GetRecord() throws IOException, SAXException, ParserConfigurationException {
        String credentialPath = "est_core_test_file.xml";

        return materialService.readXMLfiletoString(credentialPath);
    }

    @GET
    @Path("listIdentifiers")
    @Produces(MediaType.APPLICATION_XML)
    public String listIdentifiers() throws IOException, SAXException, ParserConfigurationException {
        String credentialPath = "listIdentifiers.xml";

        return materialService.readXMLfiletoString(credentialPath);
    }

}
