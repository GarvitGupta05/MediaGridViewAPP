package com.example.garvitgupta.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private Socket socket;
    private String serverIP;
    private ExecutorService executor;
    private static final int SERVER_PORT = 5000;

    public Client(String serverIP) {
        this.serverIP = serverIP;
        executor = Executors.newSingleThreadExecutor();
        executor.execute(new ClientThread());
    }

    class ClientThread implements Runnable {
        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(serverIP);
                socket = new Socket(serverAddr, SERVER_PORT);
            } catch (UnknownHostException e) {
                System.out.println("Garvit Not Connected to server");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Garvit Not Connected to server");
                e.printStackTrace();
            } finally {
                System.out.println("Garvit Connected to server");
            }
        }
    }

    public void sendData(String str) throws JSONException {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        try {
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJSONString() throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

//        try {
//
//            FileWriter file = new FileWriter("D:\\test.json");
//            file.write(obj.toJSONString());
//            file.flush();
//            file.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("Garvit json : " + obj.toString());
        return obj.toString();
    }

    public void parseJSONString(String str) throws JSONException {

        JSONObject reader = new JSONObject(str);

        String name = reader.getString("name");
        Integer age = reader.getInt("age");

        System.out.println("Garvit name : " + name + " age : " + age);

    }
}
