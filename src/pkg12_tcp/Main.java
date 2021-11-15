/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg12_tcp;

import java.util.StringTokenizer;

/**
 *
 * @author Pamungkas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = "", sendRead = "";
        String message = "Andi send";
        String delimiter = " ";
        StringTokenizer st = new StringTokenizer(message, delimiter);
		while (st.hasMoreElements()) {
                     name = name + st.nextToken().toString();
                     sendRead = sendRead + st.nextToken().toString();
		}
                System.out.println(name);                
                System.out.println(sendRead);

    }
    
}
