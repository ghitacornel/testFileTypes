package json.simple;

import java.util.Objects;

public class SimpleModel {

    private int propertyInteger;
    private double propertyDouble;
    private boolean propertyBoolean;
    private String propertyString;
    private Integer propertyIntegerObject;
    private Double propertyDoubleObject;
    private Boolean propertyBooleanObject;

    public int getPropertyInteger() {
        return propertyInteger;
    }

    public void setPropertyInteger(int propertyInteger) {
        this.propertyInteger = propertyInteger;
    }

    public double getPropertyDouble() {
        return propertyDouble;
    }

    public void setPropertyDouble(double propertyDouble) {
        this.propertyDouble = propertyDouble;
    }

    public boolean isPropertyBoolean() {
        return propertyBoolean;
    }

    public void setPropertyBoolean(boolean propertyBoolean) {
        this.propertyBoolean = propertyBoolean;
    }

    public String getPropertyString() {
        return propertyString;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }

    public Integer getPropertyIntegerObject() {
        return propertyIntegerObject;
    }

    public void setPropertyIntegerObject(Integer propertyIntegerObject) {
        this.propertyIntegerObject = propertyIntegerObject;
    }

    public Double getPropertyDoubleObject() {
        return propertyDoubleObject;
    }

    public void setPropertyDoubleObject(Double propertyDoubleObject) {
        this.propertyDoubleObject = propertyDoubleObject;
    }

    public Boolean getPropertyBooleanObject() {
        return propertyBooleanObject;
    }

    public void setPropertyBooleanObject(Boolean propertyBooleanObject) {
        this.propertyBooleanObject = propertyBooleanObject;
    }

    @Override
    public String toString() {
        return "SimpleModel{" +
                "propertyInteger=" + propertyInteger +
                ", propertyDouble=" + propertyDouble +
                ", propertyBoolean=" + propertyBoolean +
                ", propertyString='" + propertyString + '\'' +
                ", propertyIntegerObject=" + propertyIntegerObject +
                ", propertyDoubleObject=" + propertyDoubleObject +
                ", propertyBooleanObject=" + propertyBooleanObject +
                '}';
    }
}
