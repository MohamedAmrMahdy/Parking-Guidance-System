package Library;
import java.io.Serializable;
import java.util.ArrayList;
public class LoginCheck implements Serializable{
    static fileManager FM =new fileManager();
    public LoginCheck(){
        
    }
    public static boolean Check_admim(String user,String pass){
        if(user.equals("Admin")&&pass.equals("Password")){
            return true;
        }
        return false;
    }
    public static boolean Check_Exit(String user,String pass){
        ArrayList<Exit_Empolyee> alx = new ArrayList<Exit_Empolyee>();
        alx = (ArrayList<Exit_Empolyee>) FM.read("ExitEmployee.bin");
        for(int i=0;i<alx.size();i++){
            if(alx.get(i).getUserName().equals(user)&&alx.get(i).getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    public static boolean Check_Entry(String user,String pass){
        ArrayList<Entry_Empolyee> alx = new ArrayList<Entry_Empolyee>();
        alx = (ArrayList<Entry_Empolyee>) FM.read("EntryEmployee.bin");
        for(int i=0;i<=alx.size();i++){
            if(alx.get(i).getUserName().equals(user)&&alx.get(i).getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
}