package yaml.model;

import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;

public class TestModel {

    static Model build() {

        Model model = new Model();

        model.setPropertyCustomised("custom value");

        InnerModel innerModel = new InnerModel();
        innerModel.setA(3);
        innerModel.setB("b");
        model.setInnerModel(innerModel);

        LocalDate localDate = LocalDate.of(2010, 10, 23);
        model.setDate(java.util.Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant()));

        return model;
    }

    @Test
    public void writeAsModel() {

        Model model=new Model();

        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(model, writer);
        Assert.assertEquals(
                "!!yaml.simple.SimpleModel {propertyBoolean: true, propertyBooleanObject: false, propertyDouble: 11.22,\n" +
                        "  propertyDoubleObject: 33.44, propertyInteger: 11, propertyIntegerObject: null, propertyString: value}\n",
                writer.toString());
    }
}
