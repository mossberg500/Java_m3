package homework2.task3;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;


public class Main {
    public static void main(String[] args) throws MalformedURLException, JAXBException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

        Exchangerates exchangerates = JAXBWorker.getXml(url);
        exchangerates.getRows().forEach((Row r) -> {
        System.out.println(r.print());
        });

    }

}
