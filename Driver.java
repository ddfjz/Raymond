package Raymond;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by marci on 7/05/2018.
 */
public class Driver extends Thread{
    public static void main(String[] args) throws IOException {
        for(int i=0;i<5;i++) {
            System.out.println("Started");
            byte[] buffer = new byte[128];
            Socket mySocket = new Socket();
            InetSocketAddress targetAddress = new InetSocketAddress(InetAddress.getByName("localhost"), Integer.parseInt(args[0]));
            mySocket.connect(targetAddress);
            System.out.println("Connected");
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            String userInput= stdIn.readLine();
            out.write(userInput.getBytes());
            out.flush();
            InputStream stream = mySocket.getInputStream();
            stream.read(buffer, 0, 128);
            System.out.println(new String(buffer));

        }
    }
}
