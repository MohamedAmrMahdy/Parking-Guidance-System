package Library;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Exit_Empolyee extends staff implements Serializable{
    fileManager FM=new fileManager();
    public static ArrayList<ticket> Tickets = new ArrayList<>();
    public static ArrayList<Exit_Empolyee> ExitEmployees = new ArrayList<>();
    public Exit_Empolyee() {
 
    }

    public Exit_Empolyee(String shift, double hoursNo, String name ,int id , String userName, String Password) {
        super(shift, hoursNo, name,id, userName, Password);
    }

    public ArrayList<Exit_Empolyee> ViewOperatorExit(){    
        return (ArrayList<Exit_Empolyee>) FM.read(AppSettings.ExitEmployeeFile);
    }

    public long CalculateTotalParkingFees(String plate) {
       Date StartDate  = new Date();
       Date EndDate    = new Date();
       spot s=new spot();
       
       int i;
       ArrayList<ticket> tl = new ArrayList<ticket>();
       tl = (ArrayList<ticket>) FM.read("Ticket.bin");
       for(i=0;i<tl.size()-1;i++){
           if(tl.get(i).getPlateNo().equals(plate)){
               StartDate = tl.get(i).getTransactionDate();
               tl.get(i).setEndDate(EndDate);
           }
       }
       long diff=EndDate.getTime()-StartDate.getTime(); 
       s.exitSpot(tl.get(i).getSpotN());
       return diff; 
    }
    
    public int getExitEmployee(int id) {
        for (int i = 0; i < ExitEmployees.size(); i++) {
            if (ExitEmployees.get(i).getID() == id) {
                return i;
            }
        }
            return -1;
    }
     
    public boolean addExitEmpolyee(){ 
        if((ArrayList<Exit_Empolyee>) FM.read(AppSettings.ExitEmployeeFile)!=null){
            ExitEmployees = (ArrayList<Exit_Empolyee>) FM.read(AppSettings.ExitEmployeeFile);
        }
        ExitEmployees.add(this);
        return FM.write(AppSettings.ExitEmployeeFile, ExitEmployees);
    }
         
    public boolean updateExEmployee(int oldID,Exit_Empolyee emp) {
        ExitEmployees = (ArrayList<Exit_Empolyee>) FM.read(AppSettings.ExitEmployeeFile);
        int x = getExitEmployee(oldID);
        if (x != -1) {
            ExitEmployees.set(x, emp);  
            return FM.write(AppSettings.ExitEmployeeFile,ExitEmployees );
        }
       return false;
    }
        
    public boolean deleteExEmployee(int id) {
        ExitEmployees = (ArrayList<Exit_Empolyee>) FM.read(AppSettings.ExitEmployeeFile);
        int x = getExitEmployee(id);
        if (x != -1) {
            ExitEmployees.remove(x);
            return FM.write(AppSettings.ExitEmployeeFile, ExitEmployees);
        }

        return false;
    }
 
}
