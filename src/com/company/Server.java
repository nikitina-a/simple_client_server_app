package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.Random;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(8086);
        var ss = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(ss.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(ss.getOutputStream());
        Random random = new Random();

        while (true) {

            var request = objectInputStream.readObject();
            var response = random
                                   .ints((Integer)request,0,360)
                                   .boxed()
                                    .toArray();

            objectOutputStream.writeObject(response);
            objectOutputStream.flush();

            objectInputStream.close();
            objectOutputStream.close();

        }

    }
}
