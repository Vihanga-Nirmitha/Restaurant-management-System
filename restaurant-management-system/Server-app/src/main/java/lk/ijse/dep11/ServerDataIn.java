package lk.ijse.dep11;

import lk.ijse.dep11.shared.Order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerDataIn {

    ArrayList<Order> orderInputList = new ArrayList<>();

    public static void openServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(5050);

            Socket localSocket = serverSocket.accept();
            System.out.println("Client connected : ");

           new Thread(()->{
               InputStream is = null;
               try {
                   is = localSocket.getInputStream();
                   BufferedInputStream bis = new BufferedInputStream(is);
                   ObjectInputStream ois = new ObjectInputStream(bis);

                   while (true){
                       Order newOrder = (Order) ois.readObject();

                   }
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }).start();

        } catch (IOException e) {
            System.out.println("Caught error");
            e.printStackTrace();
        }

    }

    public ArrayList<Order> getOrderList(){
        return orderInputList;
    }
}
