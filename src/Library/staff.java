package Library;

import java.io.Serializable;
import java.util.Date;


public  class staff implements Serializable{

    private String shift;

    private double hoursNo;

    private String name;
    
    private int id;

    private String userName;

    private String Password;
    public staff(){
    
}
      public staff(String shift, double hoursNo, String name,int id, String userName, String Password) {
        this.shift = shift;
        this.hoursNo = hoursNo;
        this.name = name;
        this.id=id;
        this.userName = userName;
        this.Password = Password;
    }
    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setHoursNo(double hoursNo) {
        this.hoursNo = hoursNo;
    }

    public void setName(String name) {
        this.name = name;
    }

     public void setID(int id) {
        this.id = id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

  

    public String getShift() {
        return shift;
    }

    public double getHoursNo() {
        return hoursNo;
    }

    public String getName() {
        return name;
    }
    
    public int getID() {
        return id;
    } 
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }
    
}