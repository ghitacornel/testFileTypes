package properties.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

public class TestWithXML {

    @Test
    public void testRead() throws Exception {

        Properties properties = new Properties();
        properties.loadFromXML(TestWithXML.class.getClassLoader().getResourceAsStream("expected.xml"));

        Assert.assertEquals("1", properties.getProperty("propertyNameInteger"));
        Assert.assertEquals("false", properties.getProperty("propertyNameBoolean"));
        Assert.assertEquals("123.456", properties.getProperty("propertyNameDouble"));
        Assert.assertEquals("stringValue", properties.getProperty("propertyNameString"));

    }

    @Test
    public void testWrite() throws Exception {

        Properties properties = new Properties();
        properties.put("propertyNameString", "stringValue");
        properties.put("propertyNameInteger", String.valueOf(1));
        properties.put("propertyNameBoolean", String.valueOf(false));
        properties.put("propertyNameDouble", String.valueOf(123.456));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        properties.storeToXML(byteArrayOutputStream, "comments");

        String actual = byteArrayOutputStream.toString();

        // cannot control order
        // cannot control timestamp
        String expected = new String(TestWithXML.class.getClassLoader().getResourceAsStream("expected.xml").readAllBytes());
        Assert.assertEquals(expected, actual);

    }
}
