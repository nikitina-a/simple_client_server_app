package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost",8086);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        Random random = new Random();

        while(true) {

            Integer numToSent = random.nextInt(0,10);
            objectOutputStream.writeObject(numToSent);
            objectOutputStream.flush();

            var response = objectInputStream.readObject();

            System.out.println(response);
            objectOutputStream.close();
            objectInputStream.close();
        }



    }
}
