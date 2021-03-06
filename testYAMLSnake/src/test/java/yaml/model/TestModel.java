package yaml.model;

import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import utils.FileUtils;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;

public class TestModel {

    Yaml yaml = new Yaml();

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

        Model model = new Model();

        String expected = FileUtils.read("writeAsModel.yaml");
        String actual = yaml.dumpAs(model, Tag.MAP, DumperOptions.FlowStyle.BLOCK);// do not write class info

        expected = expected.replaceAll("\\n|\\r\\n", "");
        actual = actual.replaceAll("\\n|\\r\\n", "");
        Assert.assertEquals(expected, actual);
    }
}
