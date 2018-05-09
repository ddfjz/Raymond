package Raymond;

import java.io.*;
import java.net.*;

/**
 * Created by marci on 4/05/2018.
 */
public class PlaneServer extends Thread{
    //private PlaneServer parent;
    //private Socket parentSocket;
    //private Tower tower;
    ServerSocket sSocket;
    private int serverPort;
    private int id;
    private int host;
    private int port;
    int holder;
    boolean using;
    boolean asked;
    Plane plane;

   // Raymond.PlaneServer(Raymond.PlaneServer p, Socket s, Raymond.Tower t, int id){
     //   this.parent=p;
     //   this.parentSocket=s;
    //    this.tower=t;
    //    this.id=id;
   // }
   PlaneServer(int s,Plane p) {
       this.serverPort=s;
       this.plane=p;
   }
    public static void main(String[] args) throws IOException {
        //int serverPort=Integer.parseInt(args[0]);

        //InetSocketAddress myAddress=new InetSocketAddress("localhost",Integer.parseInt(args[0]));
        //System.out.println(InetAddress.getByName("localhost"));
        //Socket mySocket=new Socket(InetAddress.getByName("localhost"),Integer.parseInt(args[0]));


        boolean r=true;
       // while (r) {
        //    int i=0;
       // }
    }

    public void receiveMessage(){

    }
    public void receiveRequest(){

    }
    public void receivePrivillege(){

    }
    public void communicatewithServer(int serverPort) throws UnknownHostException, IOException{
        Socket mySocket=new Socket();
        byte[] buffer=new byte[128];
        //InetSocketAddress targetAddress=new InetSocketAddress(InetAddress.getByName("localhost"),Integer.parseInt(args[1]));
        InetSocketAddress targetAddress=new InetSocketAddress(InetAddress.getByName("localhost"),serverPort);
        //  InetAddress LHAddress = mySocket.getLocalAddress();
        //  int myPort = mySocket.getLocalPort();
        // System.out.println("\nLocal Host:" + LHAddress + "\nLocal port:" + myPort);
        mySocket.connect(targetAddress);
        InputStream stream=mySocket.getInputStream();
        stream.read(buffer,0,128);
        System.out.println(new String(buffer));
        mySocket.close();
    }
    @Override
    public void run() {
       try {
           boolean waiting=true;
           ServerSocket sSocket = new ServerSocket(serverPort, 100, InetAddress.getByName("localhost"));
           plane.printMessage("Server Init");
           System.out.println(sSocket.getLocalSocketAddress().toString());
           while(waiting) {
               Socket s = sSocket.accept();
               System.out.println(s.getRemoteSocketAddress().toString());
               System.out.println(s.getLocalSocketAddress().toString());
               OutputStream out = s.getOutputStream();
               InputStream in = s.getInputStream();
               DataInputStream is = new DataInputStream(s.getInputStream());
               BufferedInputStream input = new BufferedInputStream(is);
               String testMessage = "Received";
               out.write(testMessage.getBytes(), 0, testMessage.length());
               ObjectInputStream objectInputStream = new ObjectInputStream(input);
               Object object = objectInputStream.readObject();
               Message mesg = Message.class.cast(object);
               //processMess
               System.out.println(object.toString());
               s.close();
             //  boolean r = true;
               int inputCount = 0;
             //  byte inputLine[] = new byte[256];
              // while ((inputCount = input.read(inputLine)) != -1) {
              //     System.out.write(inputLine);
              // }
               //while(r){
               //     int i=0;
               // }
               //s.close();
           }
       }
       catch (IOException e){
           System.out.println(e);
       }
       catch (ClassNotFoundException e){
           System.out.println(e);
       }
    }
    public void processMessage(Message o) throws IOException{
        if(o.isRequest() & !plane.hasToken){
            Socket mySocket = new Socket();
            InetSocketAddress targetAddress = new InetSocketAddress(InetAddress.getByName("localhost"), serverPort);
            mySocket.connect(targetAddress);
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            o.setFromPort(this.serverPort);
            //Message m=new Message(true,false,"localhost",this.id);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
            mySocket.close();
            //Forward request
        }
        if(o.isRequest() & plane.hasToken){

            //Send privillge
        }
        if(o.isToken() & !plane.asked){
            //Forward request
            //Update holder
        }
        if(o.isToken() & plane.asked){
            plane.asked=false;
            plane.hasToken=true;
            //Enter CS
        }

    }
    //Get request

    //Get privilege




}
