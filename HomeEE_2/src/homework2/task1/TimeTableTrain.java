package homework2.task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "timetable")
public class TimeTableTrain {
    private List<Train> trains;
    private Parser parser;

    public TimeTableTrain(){

    }

    public TimeTableTrain(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }

    @XmlElement
    @XmlElementWrapper
    public void setTrains(List<Train> trains) {
       this.trains = trains;
    }


    public void addNewTrain(Train train){
        trains.add(train);
    }

    @Override
    public String toString() {
        return "TimeTableTrain{" +
                "trains=" + trains +
                ", parser=" + parser +
                '}';
    }
}
