package lk.ijse.dep11;

import lk.ijse.dep11.shared.Order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientNetwork {

    public ArrayList<Order> completeOrders = new ArrayList<>();

    public ObjectOutputStream oos;

    //Server to send data from client app
    public void openClientOutput(){

        Socket remoteSocket =null;
        try {
            System.out.println("Client trying to connect");
            remoteSocket = new Socket("localhost",5050);
            OutputStream os = remoteSocket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Server to recieve data to client app
    public void openClientInputServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(5051);
            Socket localSocket = serverSocket.accept();
            System.out.println("Kitchen connected to cashier");
            InputStream is  = localSocket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ObjectInputStream ois = new ObjectInputStream(bis);

            while (true){
            Order completedOrder = (Order) ois.readObject();
            //Todo :  code here to process data from server(Completed order data)
            completeOrders.add(completedOrder);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Order> getCompleteOrders(){
        return completeOrders;
    }

    public void sendObject(Order newOrder){
        try {
            oos.writeObject(newOrder);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
