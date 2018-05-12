package Raymond;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by marci on 6/05/2018.
 */
public class Message implements Serializable {
    boolean request;
    boolean token;
    String fromHost;
    int type;

    public ArrayList<Integer> getForwarded() {
        return forwarded;
    }

    public void setForwarded(ArrayList<Integer> forwarded) {
        this.forwarded = forwarded;
    }

    ArrayList<Integer> forwarded;

    public int getFromID() {
        return fromID;
    }

    public void setFromID(int fromID) {
        this.fromID = fromID;
    }

    int fromPort;
    int fromID;

    public void setRequest(boolean request) {
        this.request = request;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    public void setFromHost(String fromHost) {
        this.fromHost = fromHost;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFromPort(int fromPort) {
        this.fromPort = fromPort;
    }

    Message(boolean r, boolean t, String h, int f){
       // this.type=t;
        this.fromPort=f;
        this.request=r;
        this.token=t;
        this.fromHost=h;
        this.forwarded=new ArrayList<Integer>();
        this.forwarded.add(f);
    }

    public String toString(){
        return Integer.toString(this.fromPort)+fromHost;
    }

    public boolean isRequest() {
        return request;
    }

    public boolean isToken() {
        return token;
    }

    public String getFromHost() {
        return fromHost;
    }

    public int getType() {
        return type;
    }

    public int getFromPort() {
        return fromPort;
    }

    public void forward(int i){
        this.forwarded.add(i);
    }
    public int dequeue(){
        int index=this.forwarded.size()-1;
        int i=this.forwarded.get(index);
        this.forwarded.remove(index);
        return i;

    }
}
