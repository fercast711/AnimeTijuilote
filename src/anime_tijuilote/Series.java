
package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Series extends Formatos{
    private int Caps;
    private int Temp;

    public Series() {
        super();
        this.Caps = 0;
        this.Temp = 0;
    }

    public Series(String Titulo, String Fecha,int Caps, int Temp) {
        super(Titulo, Fecha);
        this.Caps = Caps;
        this.Temp = Temp;
    }

    public void setCaps(int Caps) {
        this.Caps = Caps;
    }

    public void setTemp(int Temp) {
        this.Temp = Temp;
    }

    public int getCaps() {
        return Caps;
    }

    public int getTemp() {
        return Temp;
    }
    
    public void LeerGUI(int i){
        super.LeerGUI(i);
        try{
        Caps = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de capitulos del anime #"+(i+1)));
        }catch(java.lang.NumberFormatException e){
            Caps = 0;
        }
        try{
        Temp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de temporadas del anime #"+(i+1)));
        }catch(java.lang.NumberFormatException e){
            Temp = 0;
        }
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \n ",Caps,Temp);
    }
}
