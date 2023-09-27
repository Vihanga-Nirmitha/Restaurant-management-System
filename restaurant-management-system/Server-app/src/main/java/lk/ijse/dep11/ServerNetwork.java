
package lk.ijse.dep11;

import lk.ijse.dep11.shared.Order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerNetwork {

    private ArrayList<Order> orderInputList = new ArrayList<>();
    public ObjectOutputStream oos;

    public /*static*/ void openServerInputServer(){
        try {
            System.out.println("Kitchen Server socket is open t connect");
            ServerSocket serverSocket = new ServerSocket(5050);

            Socket localSocket = serverSocket.accept();
            System.out.println("Cashier connected to Kitchen");

           new Thread(()->{
               InputStream is = null;
               try {
                   is = localSocket.getInputStream();
                   BufferedInputStream bis = new BufferedInputStream(is);
                   ObjectInputStream ois = new ObjectInputStream(bis);

                   while (true){
                       Order newOrder = (Order) ois.readObject();
                       //Todo : code here and below to process order data from client app
                       //orderInputList.add(newOrder);
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

    public void openserverOutput(){
        Socket remoteSocket =null;
        try {
            System.out.println("Kitchen trying to connect");
            remoteSocket = new Socket("localhost",5051);
            OutputStream os = remoteSocket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Order newOrder){
        try {
            oos.writeObject(newOrder);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //this will return order arrayList
    public ArrayList<Order> getOrderList(){
        return orderInputList;
    }

}

