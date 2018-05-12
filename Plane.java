package Raymond;

import java.io.IOException;

/**
 * Created by marci on 6/05/2018.
 */
public class Plane {
    boolean landed=false;
    boolean using=false;
    boolean asked=false;
    boolean hasToken=false;

    Plane(){
        this.hasToken=false;
        this.landed=false;
        this.asked=false;
    }
    public void printMessage(String m){
        System.out.println(m);
    }


    }

