package project2;
import Library.*;
import GUI.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.UnsupportedLookAndFeelException;
public class Core {
        
        
        static void FirstRun() throws IOException{
            fileManager FM=new fileManager();
            Entry_Empolyee ee = new Entry_Empolyee();
            Exit_Empolyee ex = new Exit_Empolyee();
            spot s = new spot();
            ticket t = new ticket();
            File fen = new File(ee.EntryEmployeeFile);
            File fex = new File(ex.ExitEmployeeFile);
            File fs = new File(s.spotFile);
            File ft = new File(t.TicketFile);
            //inisialaise defult index contain garbage 
            if(!fen.exists() && !fen.isDirectory()){
                fen.createNewFile();
                Entry_Empolyee entryexample = new Entry_Empolyee("AM", 2,"Mohamed Amr", 0, "Mohamed", "Mohamed--");
                entryexample.addEntryEmpolyee();
            }
            if(!fex.exists() && !fex.isDirectory()){
                fex.createNewFile();
                Exit_Empolyee exitexample = new Exit_Empolyee("PM", 4,"Mostafa Omar", 0, "Mostafa", "Mostafa--");
                exitexample.addExitEmpolyee();
            }
            if(!fs.exists() && !fs.isDirectory()){
                fs.createNewFile();
                spot First = new spot(0,0,"A1");
                First.saveSpot();
                spot Second = new spot(0,60,"A2");
                Second.saveSpot();
                spot Third = new spot(0,120,"A3");
                Third.saveSpot();
                spot Fourth = new spot(0,180,"A4");
                Fourth.saveSpot();
                spot Fifth = new spot(0,240,"A5");
                Fifth.saveSpot();
                spot Sixth = new spot(0,300,"A6");
                Sixth.saveSpot();
                spot Seventh = new spot(110,0,"B1");
                Seventh.saveSpot();
                spot Eighth = new spot(110,60,"B2");
                Eighth.saveSpot();
                spot Ninth = new spot(110,120,"B3");
                Ninth.saveSpot();
                spot Tenth = new spot(110,180,"B4");
                Tenth.saveSpot();
                spot Eleventh = new spot(110,240,"B5");
                Eleventh.saveSpot();
                spot Twelfth = new spot(110,300,"B6");
                Twelfth.saveSpot();
            }
            if(!ft.exists() && !ft.isDirectory()){
                ft.createNewFile();
                ticket ticketexample = new ticket(0,"123ABC","A0");
                ticketexample.addTicket();
            }
            ArrayList<Entry_Empolyee> alx = new ArrayList<Entry_Empolyee>();
            alx = (ArrayList<Entry_Empolyee>) FM.read(ee.EntryEmployeeFile);
            System.out.println(alx.get(0).getPassword());
            
            ArrayList<Exit_Empolyee> al = new ArrayList<Exit_Empolyee>();
            al = (ArrayList<Exit_Empolyee>) FM.read(ex.ExitEmployeeFile);
            System.out.println(al.get(0).getPassword());
            
            ArrayList<spot> sl = new ArrayList<spot>();
            sl = (ArrayList<spot>) FM.read(s.spotFile);
            System.out.println(sl.get(0).getSpotName());
            
            ArrayList<ticket> tl = new ArrayList<ticket>();
            tl = (ArrayList<ticket>) FM.read(t.TicketFile);
            System.out.println(tl.get(0).getPlateNo());
        }
    public static void main(String[] args) throws IOException {
        
        try{ 
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } 
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){ 
            System.out.println(e);
        }
        FirstRun();
        Login lg =new Login();
        lg.setVisible(true);
    }
    
    
}
