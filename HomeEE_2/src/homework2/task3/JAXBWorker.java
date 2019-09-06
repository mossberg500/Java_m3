package homework2.task3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class JAXBWorker  {
    public static Exchangerates getXml(String urlPath) {
        Exchangerates exchangerates = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JAXBContext context = JAXBContext.newInstance(Exchangerates.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            exchangerates = (Exchangerates) unmarshaller.unmarshal(connection.getInputStream());
            connection.disconnect();

        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return exchangerates;
    }


    /*
     public static Dependencies loadFromXML(File file){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Dependencies.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Dependencies dependencies = (Dependencies) unmarshaller.unmarshal(file);
            return dependencies;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
     */

}
