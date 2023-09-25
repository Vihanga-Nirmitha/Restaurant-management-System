package lk.ijse.dep11.shared;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    private  String ItemID;
    private String ItemName;
    private int qty;
    private double ItemPrice;



}
