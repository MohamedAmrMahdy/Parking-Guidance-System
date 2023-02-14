package Library;
import java.io.Serializable;
import java.util.Date;

public class admin extends staff implements Serializable {
    
    public admin(String shift, double hoursNo, String name,int id, String userName, String Password) {
        super(shift, hoursNo, name,id, userName, Password);
    }

    public void addNewSpots() {
           spot x = new spot();
           x.saveSpot();
    }
   
    public void viewTotalSpots() {
          
        spot x = new spot();
        System.out.println(x.viewSpots());
    }


    public void addEntryEmployee() {
           Entry_Empolyee x = new Entry_Empolyee();
           x.addEntryEmpolyee();
    }
    public void addExitEmployee() 
    {
         Exit_Empolyee x = new Exit_Empolyee();
          x.addExitEmpolyee();
    }
    public void updateEntryEmployee(int oldID, Entry_Empolyee emp) {
        Entry_Empolyee x = new Entry_Empolyee();
        if (x.updateEnEmployee(oldID, emp)) {
            System.out.println(emp.toString()+"Updated");
        } else {
            System.out.println("Failed !");
        }
    }
    
    public void updateExitEmployee(int oldID, Exit_Empolyee emp) {
        Exit_Empolyee x = new Exit_Empolyee();
        if (x.updateExEmployee(oldID, emp)) {
            System.out.println(emp.toString()+"Updated");
        } else {
            System.out.println("Failed !");
        }
    }
    public void deleteEntryEmployee(int Id) {
        Entry_Empolyee x = new Entry_Empolyee();
        if (x.deleteEnEmployee(Id)) {
           System.out.println(Id + " Deleted!");
        } else {
            System.out.println("Failed to Delet !");
        }
    }
    public void deleteExitEmployee(int Id) {
        Exit_Empolyee x = new Exit_Empolyee();
        if (x.deleteExEmployee(Id)) {
           System.out.println(Id + " Deleted!");
        } else {
            System.out.println("Failed to Delet !");
        }
           }

    public void viewParkedReport() {
        ticket x=new ticket ();
       System.out.println(x.viewParkedCars());
        
    }
    
    }

