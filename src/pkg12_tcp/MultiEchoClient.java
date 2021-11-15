package pkg12_tcp;

import java.io.*;
import java.net.*;
public class MultiEchoClient {

    private static InetAddress host;
    private static final int PORT = 1234;
    private static Socket link;
    private static BufferedReader in;
    private static PrintWriter out;
    private static BufferedReader keyboard;

    public static void main(String args[]) {
        try {
            host = InetAddress.getLocalHost();
            link = new Socket(host, PORT);
            in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            out
                    = new PrintWriter(link.getOutputStream(), true);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            String message, response;
            do {
                System.out.print("Enter message(QUIT to exit)");
                message = keyboard.readLine();
                out.println(message);
                response = in.readLine();
                System.out.println(response);
            } while (!message.equals("QUIT"));
        } catch (UnknownHostException e) {
            System.out.println("Host ID not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (link != null) {
                    System.out.println("Closing down connection");
                    link.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
