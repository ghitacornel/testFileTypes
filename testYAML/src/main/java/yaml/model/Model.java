package yaml.model;

import java.util.Date;

public class Model {

    private String string;

    private String propertyIgnored = "ignored value";

    private String propertyCustomised;

    private Date date;

    private InnerModel innerModel;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getPropertyIgnored() {
        return propertyIgnored;
    }

    public void setPropertyIgnored(String propertyIgnored) {
        this.propertyIgnored = propertyIgnored;
    }

    public String getPropertyCustomised() {
        return propertyCustomised;
    }

    public void setPropertyCustomised(String propertyCustomised) {
        this.propertyCustomised = propertyCustomised;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public InnerModel getInnerModel() {
        return innerModel;
    }

    public void setInnerModel(InnerModel innerModel) {
        this.innerModel = innerModel;
    }

    @Override
    public String toString() {
        return "Model{" +
                "string='" + string + '\'' +
                ", propertyIgnored='" + propertyIgnored + '\'' +
                ", propertyCustomised='" + propertyCustomised + '\'' +
                ", date=" + date +
                ", innerModel=" + innerModel +
                '}';
    }
}
