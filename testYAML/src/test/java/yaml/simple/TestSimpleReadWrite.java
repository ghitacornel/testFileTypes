package yaml.simple;

import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestSimpleReadWrite {

    @Test
    public void testReadAsMap() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("simple_model.yaml");
        Map<String, Object> map = new Yaml().load(inputStream);
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
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("simple_model.yaml");
        Yaml yaml = new Yaml(new Constructor(SimpleModel.class));
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

        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(model, writer);
        Assert.assertEquals(
                "{propertyInteger: 10, propertyDouble: 11.22, propertyBoolean: true, propertyString: value,\n" +
                        "  propertyIntegerObject: 11, propertyDoubleObject: 33.44, propertyBooleanObject: false}\n",
                writer.toString());
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

        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(model, writer);
        Assert.assertEquals(
                "!!yaml.simple.SimpleModel {propertyBoolean: true, propertyBooleanObject: false, propertyDouble: 11.22,\n" +
                        "  propertyDoubleObject: 33.44, propertyInteger: 11, propertyIntegerObject: null, propertyString: value}\n",
                writer.toString());
    }
}
