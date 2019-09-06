package homework2.task1;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Parser {
    private TimeTableTrain timeTableTrain;
    private File file;

    public Parser(File file,TimeTableTrain timeTableTrain) {
        this.file = file;
        this.timeTableTrain = timeTableTrain;
    }

    public Parser(File file) {
        this.file = file;
    }


    public Object getObject(Class c) {
        Object object = null;
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return object;
    }

    public void saveObject() {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(timeTableTrain.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(timeTableTrain, file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public List<Train> parsByTime(String after) {
        List<Train> list = new ArrayList<>();
        TimeTableTrain newTimeTable = (TimeTableTrain) getObject(TimeTableTrain.class);
        List<Train> timeTablelist = newTimeTable.getTrains();
        timeTablelist.stream().filter((t)->((t.getDeparture().compareTo(after)>=0))).forEachOrdered((t)->{
            list.add(t);
        });
        return list;
    }
}
