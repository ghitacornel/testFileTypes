package yaml.simple;

import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import utils.FileUtils;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestSimpleReadWrite {

    Yaml yaml = new Yaml();

    @Test
    public void testReadAsMap() {
        InputStream inputStream = FileUtils.readStream("simple_model.yaml");
        Map<String, Object> map = yaml.load(inputStream);
        Assert.assertEquals(10, map.get("propertyInteger"));
        Assert.assertEquals(11.22, map.get("propertyDouble"));
        Assert.assertEquals(true, map.get("propertyBoolean"));
        Assert.assertEquals("value", map.get("propertyString"));
        Assert.assertEquals(11, map.get("propertyIntegerObject"));
        Assert.assertEquals(33.44, map.get("propertyDoubleObject"));
        Assert.assertEquals(false, map.get("propertyBooleanObject"));
    }

    @Test
    public void testReadAsObject() {
        InputStream inputStream = FileUtils.readStream("simple_model.yaml");
        Yaml yaml = new Yaml(new Constructor(SimpleModel.class, new LoaderOptions()));
        SimpleModel model = yaml.load(inputStream);

        Assert.assertEquals(10, model.getPropertyInteger());
        Assert.assertEquals(11.22, model.getPropertyDouble(), 0.0);
        Assert.assertTrue(model.isPropertyBoolean());
        Assert.assertEquals("value", model.getPropertyString());
        Assert.assertEquals(11, model.getPropertyIntegerObject().intValue());
        Assert.assertEquals(33.44, model.getPropertyDoubleObject(), 0.0);
        Assert.assertEquals(false, model.getPropertyBooleanObject());
    }

    @Test
    public void testWriteAsMap() {

        Map<String, Object> model = new LinkedHashMap<>();
        model.put("propertyInteger", 10);
        model.put("propertyDouble", 11.22);
        model.put("propertyBoolean", true);
        model.put("propertyString", "value");
        model.put("propertyIntegerObject", 11);
        model.put("propertyDoubleObject", 33.44);
        model.put("propertyBooleanObject", false);

        String expected = FileUtils.read("testWriteAsMap.yaml");
        String actual = yaml.dumpAs(model, Tag.MAP, DumperOptions.FlowStyle.BLOCK);

        expected = expected.replaceAll("\\n|\\r\\n", "");
        actual = actual.replaceAll("\\n|\\r\\n", "");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteAsObject() {

        SimpleModel model = new SimpleModel();
        model.setPropertyInteger(10);
        model.setPropertyDouble(11.22);
        model.setPropertyBoolean(true);
        model.setPropertyString("value");
        model.setPropertyInteger(11);
        model.setPropertyDoubleObject(33.44);
        model.setPropertyBooleanObject(false);

        String expected = FileUtils.read("testWriteAsObject.yaml");
        String actual = yaml.dumpAs(model, Tag.MAP, DumperOptions.FlowStyle.BLOCK);// do not write class info

        expected = expected.replaceAll("\\n|\\r\\n", "");
        actual = actual.replaceAll("\\n|\\r\\n", "");
        Assert.assertEquals(expected, actual);
    }
}
