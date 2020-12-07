package json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Model {

    private String string;

    @JsonIgnore
    private String propertyIgnored = "ignored value";

    @JsonProperty("custom")
    private String propertyCustomised;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeSerializer.class)
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
