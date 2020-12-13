package properties.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.FileUtils;

import java.io.StringWriter;
import java.util.Properties;

public class TestReadWrite {

    @Test
    public void testRead() throws Exception {

        Properties properties = new Properties();
        properties.load(FileUtils.readStream("input.properties"));

        Assert.assertEquals("propertyValue", properties.getProperty("propertyName"));
        Assert.assertEquals("", properties.getProperty("propertyNameWithEmptyValue"));

    }

    @Test
    public void testReadNotPresentProperty() throws Exception {

        Properties properties = new Properties();
        properties.load(FileUtils.readStream("input.properties"));

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

        String actual = writer.toString();
        String expected = FileUtils.read("expected.properties");

        // cannot control order
        // cannot control timestamp
        // hence hack it for testing purpose and remove comments
        actual = actual.substring(actual.indexOf("property"));
        expected = expected.substring(expected.indexOf("property"));

        Assert.assertEquals(expected, actual);

    }

}
