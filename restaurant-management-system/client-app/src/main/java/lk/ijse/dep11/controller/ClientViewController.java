package lk.ijse.dep11.controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.shared.Order;

public class ClientViewController {
    public AnchorPane rootMain;
    public TextField txtOrderID;
    public TextField txtOrderName;
    public TextField txtContactNo;
    public TextField txtItemName;
    public TableView<Order> tblOrder;
    public TableView tblStatus;
    public ImageView imvBurger;
    public ImageView imvPizza;
    public ImageView imvSub;
    public ImageView imvBurrito;

    public void imvBurgerOnMouseCliked(MouseEvent mouseEvent) {
    }

    public void imvPizzaOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void imvSubOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void imvBurritoOnMouseClicked(MouseEvent mouseEvent) {
    }
}
