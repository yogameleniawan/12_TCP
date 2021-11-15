package pkg12_tcp;

import java.io.*;
import java.net.*;
public class MultiEchoServer {

    private static ServerSocket servSock;
    private static final int PORT = 1234;

    public static void main(String args[]) throws IOException {
        System.out.println("Opening Port.....\n");
        try {
            servSock = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Unable to attach to port "); 
            System.exit(1);
}
do {
            Socket client = servSock.accept();
            ClientHandler handler = new ClientHandler(client);
            handler.start();
        } while (true);
    }
}

class ClientHandler extends Thread {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        client = socket;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String received;
            do {
                received = in.readLine();
                System.out.println(received);
                out.println("ECHO : " + received);
            } while (!received.equals("QUIT"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    System.out.println("Closing down connection");
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
