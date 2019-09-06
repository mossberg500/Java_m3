package homework2.task1;

import java.time.LocalTime;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "from", "to", "date", "departure"})
public class Train {

    private int id;
    private String from;
    private String to;
    private Date date;
    private LocalTime departure;

    public Train() {
    }

    public Train(int id, String from, String to, Date date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = LocalTime.parse(departure);
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure.toString();
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = LocalTime.parse(departure);
    }

    @Override
    public String toString() {
        return "Train{" + "id=" + id + ", from=" + from + ", to=" + to + ", date=" + date + ", departure=" + departure + "}";
    }

}