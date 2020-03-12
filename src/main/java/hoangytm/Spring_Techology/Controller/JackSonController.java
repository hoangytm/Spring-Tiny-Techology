package hoangytm.Spring_Techology.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import hoangytm.Spring_Techology.jackSon.Item;
import hoangytm.Spring_Techology.jackSon.View;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PhanHoang
 * 3/12/2020
 */
@RestController
public class JackSonController {
    @JsonView(View.Public.class)
    @RequestMapping("/items")
    public Item getItemPublic() {
        Item item = new Item(2, "book", "John");

        return item;
    }

    @JsonView(View.Internal.class)
    @RequestMapping("/items/internal")
    public Item getItemInternal() {
        Item item = new Item(2, "book", "John");
        return item;
    }
}
