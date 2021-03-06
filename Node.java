package Raymond;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by marci on 6/05/2018.
 */
public class Node {
    private int port;
    private String host;
    private String[] neighbours;
    private int id;

    Node(int id, int port, String host) {
        this.host = host;
        this.port = port;
        //this.neighbours=n;
        this.id = id;

    }

    public void setNeighbours(String[] n) {
        this.neighbours = n;
    }

    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);

        int holder=0;
        String hold="Holder_config";
        String lineh = null;
        FileReader fileReaderhold = new FileReader(hold);
        BufferedReader bufferedReaderh = new BufferedReader(fileReaderhold);
        while ((lineh = bufferedReaderh.readLine()) != null) {
            String[] l = lineh.split(",");
            if (Integer.parseInt(l[0]) == id) {
                holder=Integer.parseInt(l[1]);
            }
        }
        Plane p = new Plane(holder);
        if (id==Integer.parseInt(args[1])){
            p.hasToken=true;
        }
        PlaneServer sPlane = new PlaneServer(id, p);
        String fileName = "configConnections.txt";
        String line = null;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            String[] l = line.split(",");
            if (Integer.parseInt(l[0]) == id) {
                PlaneClient cPlane = new PlaneClient(Integer.parseInt(l[1]), p,id);
                cPlane.start();

            }
        }

        sPlane.start();
            //System.out.println("Server started");
            //cPlane.start();
            //for (int i=0;i<;)




    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String[] getNeighbours() {
        return neighbours;
    }

    public int getId() {
        return this.id;
    }
}
