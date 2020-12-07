package json.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class TestFormatterModelReadWrite {

    static FormatterModel build() {
        FormatterModel model = new FormatterModel();
        model.setA(1);
        model.setB("b");
        return model;
    }

    @Test
    public void testReadFormat() throws Exception {

        FormatterModel model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        FormatterModel actual = objectMapper.readValue(new String(TestFormatterModelReadWrite.class.getClassLoader().getResourceAsStream("formatter/expectedFormattedJson.json").readAllBytes()), FormatterModel.class);

        Assert.assertEquals(model.toString(), actual.toString());
    }

    @Test
    public void testWriteFormat() throws Exception {

        FormatterModel model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);

        Assert.assertEquals(new String(TestFormatterModelReadWrite.class.getClassLoader().getResourceAsStream("formatter/expectedFormattedJson.json").readAllBytes()), string);
    }
}
