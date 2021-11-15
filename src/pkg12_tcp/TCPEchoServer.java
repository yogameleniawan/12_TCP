package pkg12_tcp;

import java.io.*;
import java.net.*;

public class TCPEchoServer {

    private static ServerSocket servSock;
    private static final int PORT = 1234;

    public static void main(String args[]) {
        System.out.println("Opening Port.....\n");
        try {
            servSock = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Unable to attach to port"); 
            System.exit(1);
}
do {
            run();
        } while (true);
    }

    private static void run() {
        Socket link = null;
        try {
            link = servSock.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);
            int numMessages = 0;
            String message = in.readLine();
            while (!message.equals("close")) {
                System.out.println("Message received");
                numMessages++;
                out.println("Message " + numMessages + ":"
                        + message);
                message = in.readLine();
            }
            out.println(numMessages + " message received.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("*********Closing Connection * * * *"); 
                link.close();
}
catch (IOException e) {
                System.out.println("Unable to disconnect");
                System.exit(1);
            }
        }
    }
}
