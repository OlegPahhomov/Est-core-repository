package est.core.repository.service;

import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import est.core.repository.utils.FileUtils;

/**
 * Created by mart on 22.09.15.
 */
public class MaterialService {


    public String readXMLfiletoString(String credentialPath)
            throws ParserConfigurationException, SAXException, IOException {
        InputStream inputStream;
        DocumentBuilder docBuilder = getDocumentBuilder();

        inputStream = FileUtils.getFileAsStream(credentialPath);
        if (inputStream == null) {
            throw new RuntimeException(format("Failed to load material in path: %s", credentialPath));
        }

        Document document = docBuilder.parse(inputStream);

        return XMLtoString(document);
    }

    private static String XMLtoString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting material to String", ex);
        }
    }

    private static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        return documentBuilderFactory.newDocumentBuilder();
    }

}
