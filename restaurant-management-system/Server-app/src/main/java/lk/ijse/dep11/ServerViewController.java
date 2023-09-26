package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.dep11.shared.Order;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.control.Control.*;

//import java.awt.*;

public class ServerViewController {

    public VBox vBoxOrders;
    public AnchorPane root;
    public Button complete;
    public void initialize() {
        Order order;
        additem();
        additem();
        try{


            vBoxOrders.setOnMouseClicked(event -> {
                System.out.println("qq");
                try{
                    System.out.println(event.getTarget().hashCode());
                    Label clickedButton = (Label) event.getTarget();
                    System.out.println(clickedButton);

                }catch (Throwable t){
                    System.out.println("no button detected");
                }
            });
        }catch (NullPointerException e){
            System.out.println("BBB");
        }

        ServerNetwork serverNetwork = new ServerNetwork();
        new Thread(()->{
            serverNetwork.openServerInputServer();
        }).start();
        Platform.runLater(()->{
            serverNetwork.openserverOutput();
        });

    }

    public void additem (){
        HBox hbox = new HBox();
        hbox.setSpacing(10);

        Label ID = new Label(" "+"order.getOderId()");
        ID.setAlignment(Pos.CENTER_LEFT);
        ID.setPrefWidth(100);
        hbox.getChildren().add(ID);

        Label Description = new Label(String.format("Burger - %d / Pizza - %d / Submarine - %d / Hotdog - %d",1,2,3,4));
        Description.setAlignment(Pos.CENTER_LEFT);
        Description.setPrefWidth(300);
        hbox.getChildren().add(Description);

        complete =new Button("Complete");
        complete.setAlignment(Pos.CENTER_LEFT);
        complete.setPrefWidth(100);
        hbox.getChildren().add(complete);

        vBoxOrders.getChildren().add(hbox);
    }

}


