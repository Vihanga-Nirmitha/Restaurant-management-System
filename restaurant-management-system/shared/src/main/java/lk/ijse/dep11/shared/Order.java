package lk.ijse.dep11.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private String OderId;
    private String CustomerName;
    private ArrayList<Item> CartItem;
}
