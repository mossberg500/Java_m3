package homework2.task3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class Row {

    private Exchangerate exchangerate;
    public Row() {
    }

    @XmlElement
    public Exchangerate getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Exchangerate exchangerate) {
        this.exchangerate = exchangerate;
    }

    public String print() {
        return "Exchangerate{" + "ccy=" + getExchangerate().getCcy() + ", baseCcy=" + getExchangerate().getBaseCcy() +
                ", buy=" + getExchangerate().getBuy() + ", sale=" + getExchangerate().getSale() + '}';
    }

    @XmlType(propOrder = {"ccy", "baseCcy", "buy", "sale"})
    private static class Exchangerate {

        private String ccy;
        private String baseCcy;
        private double buy;
        private double sale;

        public Exchangerate() {
        }

        public Exchangerate(String ccy, String baseCcy, double buy, double sale) {
            this.ccy = ccy;
            this.baseCcy = baseCcy;
            this.buy = buy;
            this.sale = sale;
        }

        @XmlAttribute
        public String getCcy() {
            return ccy;
        }

        public void setCcy(String ccy) {
            this.ccy = ccy;
        }

        @XmlAttribute(name = "base_ccy")
        public String getBaseCcy() {
            return baseCcy;
        }

        public void setBaseCcy(String baseCcy) {
            this.baseCcy = baseCcy;
        }

        @XmlAttribute
        public double getBuy() {
            return buy;
        }

        public void setBuy(double buy) {
            this.buy = buy;
        }

        @XmlAttribute
        public double getSale() {
            return sale;
        }

        public void setSale(double sale) {
            this.sale = sale;
        }
    }
}