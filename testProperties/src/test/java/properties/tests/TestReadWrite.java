package properties.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.Properties;

public class TestReadWrite {

    @Test
    public void testRead() throws Exception {

        Properties properties = new Properties();
        properties.load(TestReadWrite.class.getClassLoader().getResourceAsStream("input.properties"));

        Assert.assertEquals("propertyValue", properties.getProperty("propertyName"));
        Assert.assertNull(properties.getProperty("propertyNameNonExistent"));

    }

    @Test(expected = NullPointerException.class)
    public void testWriteNull() throws Exception {

        Properties properties = new Properties();
        properties.put("propertyNameNull", null);

        StringWriter writer = new StringWriter();
        properties.store(writer, "");

    }

    @Test
    public void testWrite() throws Exception {

        Properties properties = new Properties();
        properties.put("propertyNameString", "stringValue");
        properties.put("propertyNameInteger", String.valueOf(1));
        properties.put("propertyNameBoolean", String.valueOf(false));
        properties.put("propertyNameDouble", String.valueOf(123.456));

        StringWriter writer = new StringWriter();
        properties.store(writer, "comments");

        String value = writer.toString();

        // cannot control order
        // cannot control timestamp
        Assert.assertEquals(new String(TestReadWrite.class.getClassLoader().getResourceAsStream("expected.properties").readAllBytes()), value);

    }

    @Test
    public void testWriteAsXML() throws Exception {

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
        String expected = new String(TestReadWrite.class.getClassLoader().getResourceAsStream("expected.xml").readAllBytes());
        Assert.assertEquals(expected, actual);

    }
}
