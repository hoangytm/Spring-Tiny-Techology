package hoangytm.Spring_Techology.jackSon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

import java.io.IOException;

/**
 * @author PhanHoang
 * 3/12/2020
 */
public class MainClassTestJackSon {

    public static String whenUseJsonViewToSerialize_thenCorrect()
            throws JsonProcessingException {

        User user = new User(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper
                .writerWithView(View.Public.class)
                .writeValueAsString(user);
        return result;
    }

    public static String whenUsePublicView_thenOnlyPublicSerialized()
            throws JsonProcessingException {

        Item item = new Item(2, "book", "John");

        ObjectMapper mapper = new ObjectMapper();

        String result = mapper
                .writerWithView(View.Internal.class)
                .writeValueAsString(item);

        return result;

    }

    public static void whenUseJsonViewToDeserialize_thenCorrect(String json)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper
                .readerWithView(View.Public.class)
                .forType(User.class)
                .readValue(json);


    }

    public static String whenUseCustomJsonViewToSerialize_thenCorrect()
            throws JsonProcessingException {
        User user = new User(1, "John");
        SerializerFactory serializerFactory = BeanSerializerFactory.instance
                .withSerializerModifier(new MyBeanSerializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializerFactory(serializerFactory);

        String result = mapper
                .writerWithView(View.Public.class)
                .writeValueAsString(user);

        return result;
    }

    public static void main(String[] args) throws IOException {
        String test1 = whenUseJsonViewToSerialize_thenCorrect();
        String test = whenUsePublicView_thenOnlyPublicSerialized();
        whenUseJsonViewToDeserialize_thenCorrect(test1);
        String test3 = whenUseCustomJsonViewToSerialize_thenCorrect();
//        System.out.println(test1);
        System.out.println(test3);

    }
}
