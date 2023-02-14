package Library;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Entry_Empolyee extends staff implements Serializable{
    fileManager FM=new fileManager();
    public final String EntryEmployeeFile = "EntryEmployee.bin";
    public static ArrayList<Entry_Empolyee> EntryEmployees = new ArrayList<>();
    public Entry_Empolyee() {
        
    }
      
    public Entry_Empolyee(String shift, double hoursNo, String name, int id, String userName, String Password) {
        super(shift, hoursNo, name, id, userName, Password);
    }

    public ArrayList<spot> getFreeSpot() {
        spot s =new spot ();
        ArrayList<spot> FreeSpots = new ArrayList<>();
        FreeSpots= s.freeSpots();
            return FreeSpots;
        
    }
    
    public void setSpotToTicket(String SpotName) {
        spot s= new spot ();
        ArrayList <spot> spots = new ArrayList<>();
        spots = (ArrayList < spot >) FM.read(s.spotFile);
        int i=s.searchSpots(SpotName);
        spots.get(i).setState(false);
        FM.write(s.spotFile, spots);
    }
    
    public int getEntryEmployee(int id) {
        for (int i = 0; i < EntryEmployees.size(); i++) {
            if (EntryEmployees.get(i).getID() == id) {
                return i;
            }
        }
            return -1;
        }
    
    public boolean addEntryEmpolyee() {  
        if((ArrayList<Entry_Empolyee>) FM.read(EntryEmployeeFile)!=null){
            EntryEmployees = (ArrayList<Entry_Empolyee>) FM.read(EntryEmployeeFile);
        }
        EntryEmployees.add(this);
        return FM.write(EntryEmployeeFile, EntryEmployees);
    }

    public boolean updateEnEmployee(int oldID,Entry_Empolyee emp) {
        EntryEmployees = (ArrayList<Entry_Empolyee>) FM.read(EntryEmployeeFile);
        int x = getEntryEmployee(oldID);
        if (x != -1) {
            EntryEmployees.set(x, emp);  
            return FM.write(EntryEmployeeFile,EntryEmployees );
        } 
       return false;
    }
   
    public boolean deleteEnEmployee(int id) {
        EntryEmployees = (ArrayList<Entry_Empolyee>) FM.read(EntryEmployeeFile);
        int x = getEntryEmployee(id);
        if (x != -1) {
            EntryEmployees.remove(x);
            return FM.write(EntryEmployeeFile, EntryEmployees);
        }
        return false;
    }
}
