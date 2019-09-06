package homework2.task1;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("folderProject\\Timetable.xml");
        Parser parserXML = new Parser(file);
        TimeTableTrain newTimeTable = (TimeTableTrain) parserXML.getObject(TimeTableTrain.class);
        for (Train trains : newTimeTable.getTrains())
            System.out.println(trains);
        System.out.println("---------------------------");

        String timeAfter = "18:00";
        System.out.println(" Trains after " + timeAfter);
        List<Train> byDate = parserXML.parsByTime(timeAfter);
        byDate.forEach((d) -> {
            System.out.println(d.toString());
        });
    }

}