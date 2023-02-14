package Library;
import java.io.Serializable;
import java.util.ArrayList;
public class spot implements Serializable {
    private int x;
    private int y;
    private boolean state;
    private String SpotName;
    fileManager FM=new fileManager();
    public static ArrayList<spot> spots = new ArrayList<>();
    public spot() {
        
    }
    public spot(int x, int y, String SpotName) {
        this.x = x;
        this.y = y;
        this.state = true;
        this.SpotName=SpotName;
    }
  
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    public void setSpotName(String SpotName) {
        this.SpotName=SpotName;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isState() {
        return state;
    }
    
    public String  getSpotName() {
        return SpotName;
    }


    public ArrayList<spot> freeSpots() {
        ArrayList<spot> freeSpots = new ArrayList<>();

        spots = (ArrayList<spot>) FM.read(AppSettings.SpotFile);
        for (spot Spot : spots) {
            if (Spot.isState()) {
                freeSpots.add(Spot);
            }
        }
            return freeSpots;
    }
      
    public boolean saveSpot() {
        if((ArrayList<spot>) FM.read(AppSettings.SpotFile)!=null){
            spots = (ArrayList<spot>) FM.read(AppSettings.SpotFile);
        }
        spots.add(this);
        return FM.write(AppSettings.SpotFile, spots);
    }

    public ArrayList<spot> viewSpots() {
        return spots = (ArrayList<spot>) FM.read (AppSettings.SpotFile);
        
    }
    
    public int searchSpots(String SpotName){
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getSpotName().equals(SpotName)) {
                return i;
            }
        }
        return -1;
    }
    
    void exitSpot(String SpotN)
    { 
        spot s=new spot();
        int i = searchSpots(SpotN);
        if (i > 0){
            s=spots.get(i);
            s.setState(true);  
            spots.set(i,s);
            FM.write(AppSettings.SpotFile, spots);
        }
    }
   
}
