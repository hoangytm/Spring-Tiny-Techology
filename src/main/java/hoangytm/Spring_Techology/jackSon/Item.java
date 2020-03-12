package hoangytm.Spring_Techology.jackSon;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 3/12/2020
 */
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    private String itemName;

    @JsonView(View.Internal.class)
    private String ownerName;
}
