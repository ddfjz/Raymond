package Raymond;

import java.io.*;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by marci on 7/05/2018.
 */
public class Launcher {
    public static void main(String[] args) throws IOException {
        //Tower t=new Tower(Integer.parseInt(args[0]),5);
        //t.run();
        //ArrayList<(String)> connectList=new ArrayList<String>();
        HashMap<String, Node> nodes = new HashMap<String, Node>();
        String fileName = "configNodes.txt";
        String line = null;
        FileReader fileReader = new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //Node file of the from: id,port,host
        while ((line = bufferedReader.readLine()) != null) {
            String[] l = line.split(",");
            //nodeList.add(new Node(Integer.parseInt(l[0]),Integer.parseInt(l[1]),l[2]));
            nodes.put(l[0], new Node(Integer.parseInt(l[0]), Integer.parseInt(l[1]), l[2]));
        }
        //Connection file of the form id,id
        fileName = "configConnections.txt";
        line = null;
        HashMap<String, String> connections = new HashMap<String, String>();
        fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            String[] l = line.split(",");

            // Always close files.
            bufferedReader.close();

        }
    }
}
