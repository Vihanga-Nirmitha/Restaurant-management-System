package lk.ijse.dep11;

import lk.ijse.dep11.shared.Order;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerDataOut {

    public ObjectOutputStream oos;
    public void opeServer(){

        Socket remoteSocket =null;
        try {
            remoteSocket = new Socket("hocalhost",5050);
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
}
