package est.core.repository.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

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
@Path("OAIHandler")
public class MaterialResource {

    @Inject
    private MaterialService materialService;

    @Context
    private HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String OAIrequest() throws IOException, SAXException, ParserConfigurationException {
        String pathMaterial = "est_core_test_file.xml";
        String pathIdentifiers = "listIdentifiers.xml";
        String getRecord = "GetRecord";
        String listIdentifiers = "ListIdentifiers";

        Map<String, String[]> parameters = request.getParameterMap();
        String[] verbValues = parameters.get("verb");

        if (Arrays.asList(verbValues).contains(getRecord)) {
        return materialService.readXMLfiletoString(pathMaterial);

        } else if (Arrays.asList(verbValues).contains(listIdentifiers)) {
            return materialService.readXMLfiletoString(pathIdentifiers);
        }

        return null;
    }
}
