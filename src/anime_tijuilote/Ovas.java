
package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Ovas extends Formatos {
    private int Numero_Ova;
    private int Caps;

    public Ovas() {
        super();
        this.Numero_Ova = 0;
        this.Caps = 0;
    }

    public Ovas(String Titulo, String Fecha, int Numero_Ova, int Caps) {
        super(Titulo, Fecha);
        this.Numero_Ova = Numero_Ova;
        this.Caps = Caps;
    }

    public void setNumero_Ova(int Numero_Ova) {
        this.Numero_Ova = Numero_Ova;
    }

    public void setCaps(int Caps) {
        this.Caps = Caps;
    }

    public int getNumero_Ova() {
        return Numero_Ova;
    }

    public int getCaps() {
        return Caps;
    }
    
    public void LeerGUI (int i){
    super.LeerGUI(i);
    try{
    Numero_Ova = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ovas del anime #"+(i+1)));
    }catch(java.lang.NumberFormatException e){
        Numero_Ova = 0;
    }
    try{
    Caps = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de capitulos del anime #"+(i+1)));
    }catch(java.lang.NumberFormatException e){
        Caps = 0;
    }
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \n ",Numero_Ova,Caps);
    }
}
