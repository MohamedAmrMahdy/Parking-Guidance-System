package Library;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class ticket implements Serializable {
    public final String TicketFile = "Ticket.bin";
    public static ArrayList<ticket> Tickets = new ArrayList<>();
    fileManager FM=new fileManager();
    private int Id;
    private String plateNo;
    private Date transactionDate;
    private Date EndDate;
    private String SpotN;
    

    public ticket(int Id, String plateNo,String SpotN) {
        this.Id = Id;
        this.plateNo = plateNo;
        this.SpotN=SpotN;
        Date stDate =new Date ();
        this.transactionDate=stDate;
        
    }

    public ticket() {
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public void setEndDate (Date EndDate){
     this.EndDate=EndDate;
    }
    public void setSpotN (String SpotN )
    {
        this.SpotN=SpotN;
    }
    public int getId() {
        return Id;
    }

   
    public String getPlateNo() {
        return plateNo;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
    public Date getEndDate () {
        return EndDate;
    }
    public String getSpotN (){
        return SpotN;
    }
   
    
    public void addTicket() {
        if((ArrayList<ticket>) FM.read(TicketFile)!=null){
        Tickets = (ArrayList<ticket>) FM.read(TicketFile);
        }
        Tickets.add(this);
        FM.write(TicketFile, Tickets);
    }
    
    public int searchTicket(int Id)
     {
         for (int i = 0; i < Tickets.size(); i++) {
            if (Tickets.get(i).getId()== Id) {
                return i;
            }
        }
            return -1;
     }
    
    public ArrayList<ticket> viewParkedCars() {
        return Tickets = (ArrayList<ticket>) FM.read (TicketFile);
        
    }
     
     }

