package Raymond;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by marci on 4/05/2018.
 */
public class Tower extends Thread{
    private PlaneServer[] planeServers;
    private int host;
    private int port;
    boolean using;
    int numPlanes;


    Tower(int p, int num){
        this.numPlanes=num;
        this.port=p;
        this.using=false;
    }

    public static void main(String[] args) throws IOException {
        int port = 123;
        //int address=
        ServerSocket sSocket = new ServerSocket(port);
        boolean r=true;
        int count=0;
        //while (r){
          //  Socket s = sSocket.accept();
          //  System.out.println(s.getRemoteSocketAddress().toString());
        //    OutputStream out=s.getOutputStream();
          //  String testMessage="H";
          // out.write(testMessage.getBytes(),0,testMessage.length());
          //  s.close();
      //  }

    }
    public void run(){
        try {
//            int count = 0;
//            String received="";
//            ServerSocket sSocket = new ServerSocket(this.port, 100, InetAddress.getByName("localhost"));
//            byte inputLine[] = new byte[256];
            File f=new File("TowerLog");
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
//            //PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.write("start");
            ServerSocket sSocket = new ServerSocket(this.port, 100, InetAddress.getByName("localhost"));
            Socket s = sSocket.accept();
            System.out.println(s.getRemoteSocketAddress().toString());
            OutputStream out = s.getOutputStream();
            InputStream in=s.getInputStream();
            DataInputStream is = new DataInputStream(s.getInputStream());
            BufferedInputStream input = new BufferedInputStream(is);
            String testMessage = "H";
            out.write(testMessage.getBytes(), 0, testMessage.length());
            boolean r=true;
            int inputCount = 0;
            byte inputLine[] = new byte[256];
            while ((inputCount = input.read(inputLine)) != -1) {
                System.out.write(inputLine);
                writer.write(new String(inputLine));
            }
            //while(r){
            //     int i=0;
            // }
            writer.close();
            s.close();
//            while (count != this.numPlanes) {
//                Socket s = sSocket.accept();
//                writer.write("s");
//                File f1=new File("Connect");
//                writer.close();
//                InputStream in=s.getInputStream();
//                DataInputStream is = new DataInputStream(s.getInputStream());
//                BufferedInputStream input = new BufferedInputStream(is);
//                Scanner scan=new Scanner(input);
//                received=scan.next();
//                System.out.println(received);
//                writer.write("n");
//                OutputStream out=s.getOutputStream();
//                String testMessage="Received";
//                out.write(testMessage.getBytes(),0,testMessage.length());
//                s.close();
//                count++;

    //        }
        }
        catch (IOException e){

        }
    }
    public synchronized void enterRunway(){

    }



}
