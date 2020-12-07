package json.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;

public class TestModelReadWrite {

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
    public void testRead() throws Exception {

        Model model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        Model actual = objectMapper.readValue(new String(TestModelReadWrite.class.getClassLoader().getResourceAsStream("model/expectedJson.json").readAllBytes()), Model.class);

        Assert.assertEquals(model.toString(), actual.toString());
    }


    @Test
    public void testWrite() throws Exception {

        Model model = build();

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(model);

        Assert.assertEquals(new String(TestModelReadWrite.class.getClassLoader().getResourceAsStream("model/expectedJson.json").readAllBytes()), string);
    }

}
