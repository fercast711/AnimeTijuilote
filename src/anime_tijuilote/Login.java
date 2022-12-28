package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author fercast
 */
public class Login extends Anime {
    private String User;
    private String Password;

    public Login() {
        this.User = "";
        this.Password = "";
    }

    public Login(String User, String Password) {
        this.User = User;
        this.Password = Password;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
    }
    
    
    
    public void LeerGUI (int i){
     User = JOptionPane.showInputDialog("Ingrese ");
     Password = JOptionPane.showInputDialog("Ingrese ");
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        Linea.printf("%s \t %s \n ",User,Password);
    }
    
}
