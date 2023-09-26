package lk.ijse.dep11.shared;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    //private  String ItemID;
    private String itemName;
    private String qty;
    private BigDecimal itemPrice;
    private BigDecimal total;

    public Item(String itemName,String qty,BigDecimal itemPrice){
        this.itemName = itemName;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }
}
