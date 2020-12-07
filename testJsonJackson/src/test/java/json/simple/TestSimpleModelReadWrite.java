package json.simple;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSimpleModelReadWrite {

    static SimpleModel build() {
        SimpleModel model = new SimpleModel();
        model.setPropertyBoolean(true);
        model.setPropertyBooleanObject(null);
        model.setPropertyDouble(123.456);
        model.setPropertyDoubleObject(789.123);
        model.setPropertyInteger(1);
        model.setPropertyIntegerObject(2);
        model.setPropertyString("value");
        return model;
    }

    static List<SimpleModel> buildMultiple() {
        SimpleModel model1 = build();
        model1.setPropertyInteger(1);
        SimpleModel model2 = build();
        model2.setPropertyInteger(2);
        List<SimpleModel> models = new ArrayList<>();
        models.add(model1);
        models.add(model2);
        return models;
    }

    @Test
    public void testRead() throws Exception {

        SimpleModel model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModel actual = objectMapper.readValue(new String(TestSimpleModelReadWrite.class.getClassLoader().getResourceAsStream("simple/expectedJson.json").readAllBytes()), SimpleModel.class);

        Assert.assertEquals(model.toString(), actual.toString());
    }

    @Test
    public void testReadMultiple() throws Exception {

        List<SimpleModel> expected = buildMultiple();

        ObjectMapper objectMapper = new ObjectMapper();
        List<SimpleModel> actual = objectMapper.readValue(new String(TestSimpleModelReadWrite.class.getClassLoader().getResourceAsStream("simple/expectedJsons.json").readAllBytes()), new TypeReference<>() {
        });

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testWrite() throws Exception {

        SimpleModel model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(model);

        Assert.assertEquals(new String(TestSimpleModelReadWrite.class.getClassLoader().getResourceAsStream("simple/expectedJson.json").readAllBytes()), string);
    }

    @Test
    public void testWriteMultiple() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(buildMultiple());

        Assert.assertEquals(new String(TestSimpleModelReadWrite.class.getClassLoader().getResourceAsStream("simple/expectedJsons.json").readAllBytes()), string);
    }

}
