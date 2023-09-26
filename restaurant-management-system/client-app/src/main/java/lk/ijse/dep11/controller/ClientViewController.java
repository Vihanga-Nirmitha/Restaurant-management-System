package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.shared.Item;
import lk.ijse.dep11.shared.Order;

import java.util.List;

public class ClientViewController {
    public AnchorPane rootMain;
    public TextField txtOrderID;
    public TextField txtOrderName;
    public TextField txtContactNo;
    public TextField txtItemName;
    public TableView<Item> tblOrder;
    public TableView<Order> tblStatus;
    public ImageView imvBurger;
    public ImageView imvPizza;
    public ImageView imvSub;
    public ImageView imvBurrito;
    public Spinner<Integer> txtQty;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnPlaceOrder;
    public void initialize(){
        txtQty.setDisable(true);
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1,1));
        txtOrderID.setText(generateOrderId());

    }

    private String generateOrderId() {
        if(getAllOrders().isEmpty()) return "ODR-0001";
        else {
            int nextOrder = Integer.parseInt(tblStatus.getItems().get(getAllOrders().size()-1).getOderId().substring(4)) +1; 
            return String.format("ODR-%04d",nextOrder);
        }
    }

    public void imvBurgerOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText("Burger");
        System.out.println("Clicked");
        mouseEvent.consume();
    }

    public void imvPizzaOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText("Pizza");
        System.out.println("Clicked");
        mouseEvent.consume();
    }

    public void imvSubOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText("Submerine");
        System.out.println("Clicked");
        mouseEvent.consume();
    }

    public void imvBurritoOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText("Burrito");
        System.out.println("Clicked");
        mouseEvent.consume();
    }

    public void btnAddOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnPlaceOrderOnAction(ActionEvent event) {
    }
    public List<Order> getAllOrders(){
        return tblStatus.getItems();
    }
}
