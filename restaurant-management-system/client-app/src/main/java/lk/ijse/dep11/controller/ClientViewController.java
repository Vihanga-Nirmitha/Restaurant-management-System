package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.Food;
import lk.ijse.dep11.shared.Item;
import lk.ijse.dep11.shared.Order;

import java.math.BigDecimal;
import java.util.List;

public class ClientViewController {
    public TextField txtOrderID;
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
    public AnchorPane rootClient;
    public TextField txtUnitPrice;
    final Food burger = new Food("Burger", BigDecimal.valueOf(500.00));
    final Food submarine = new Food("Submarine", BigDecimal.valueOf(850.00));
    final Food pizza = new Food("pizza", BigDecimal.valueOf(1490.00));
    final Food burrito = new Food("Burrito", BigDecimal.valueOf(1150.00));
    public TextField txtCustomerName;

    public void initialize(){
        /*txtQty.setDisable(true);
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);*/
        for (Control control : new Control[] {btnAdd,btnDelete,btnPlaceOrder,txtQty}) {
            control.setDisable(true);
            
        }
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1,1));
        txtOrderID.setText(generateOrderId());
        //foods


        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("total"));

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
        txtItemName.setText(burger.getName());
        txtUnitPrice.setText(burger.getUnitPrice().toString());
        btnAdd.setDisable(false);
        mouseEvent.consume();
    }

    public void imvPizzaOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText(pizza.getName());
        txtUnitPrice.setText(pizza.getUnitPrice().toString());
        btnAdd.setDisable(false);
        mouseEvent.consume();
    }

    public void imvSubOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText(submarine.getName());
        txtUnitPrice.setText(submarine.getUnitPrice().toString());
        btnAdd.setDisable(false);
        mouseEvent.consume();
    }

    public void imvBurritoOnMouseClicked(MouseEvent mouseEvent) {
        txtQty.setDisable(false);
        txtItemName.setText(burrito.getName());
        txtUnitPrice.setText(burrito.getUnitPrice().toString());
        btnAdd.setDisable(false);
        mouseEvent.consume();
    }

    public void btnAddOnAction(ActionEvent event) {
        BigDecimal total = new BigDecimal(txtUnitPrice.getText()).multiply(new BigDecimal(txtQty.getValue()));
        //Item addItem = new Item(txtItemName.getText(), txtQty.getValue().toString(), new BigDecimal(txtUnitPrice.getText()));
        Item cartItem = new Item(txtItemName.getText(), txtQty.getValue().toString(), new BigDecimal(txtUnitPrice.getText()), total);
        for (Item item : tblOrder.getItems()) {
            if(txtItemName.getText().equals(item.getItemName())){
                int newQTY = Integer.valueOf(item.getQty())+txtQty.getValue();
                item.setQty(String.valueOf(newQTY));
                BigDecimal newTotal = item.getItemPrice().multiply(new BigDecimal(newQTY));
                item.setTotal(newTotal);
                tblOrder.refresh();
                return;
            }
        }
        tblOrder.getItems().add(cartItem);
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnPlaceOrderOnAction(ActionEvent event) {
    }
    public List<Order> getAllOrders(){
        return tblStatus.getItems();
    }

    public void rootClientOnMouseClicked(MouseEvent mouseEvent) {
        /*txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0,1));
        txtItemName.clear();
        txtUnitPrice.clear();
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);
        btnPlaceOrder.setDisable(tblOrder.getItems().isEmpty());
        mouseEvent.consume();*/
    }
}
