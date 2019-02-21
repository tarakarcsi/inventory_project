import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class Store {


    public void saveToXml(Product product) {
        Document dom = new Document();
        TransformerFactory tf = new TransformerFactory.newInstance();
        Transformer t = tf.newInstance();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("pom.xml"));
        t.transform(source, result);
    }

    public void storeProduct(Product product, String xml) throws ParserConfigurationException, SAXException, IOException  {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputStream is = new FileInputStream(xmlFile);
        Document document = db.parse(is);

        return document;
        }

    }

    public Product createProduct(String type, String name, int price, int size) {
        if(type.equals("book")) {
            Product book = new BookProduct();
            return book;
        }
        else if(type.equals("CD")) {
            Product CD = new CDProduct();
            return CD;
        }
    }

    public List<Product> loadProducts() {

    }

    public void store(Product product) {

    }
}
