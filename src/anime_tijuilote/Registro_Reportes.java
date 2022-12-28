package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public abstract class Registro_Reportes extends Anime {
    private char[] Numero = new char[6];
    private String Fecha;

    public Registro_Reportes() {
        this.Numero = "".toCharArray();
        this.Fecha = "";
    }

    public Registro_Reportes(char[] Numero, String Fecha) {
        this.Numero = Numero;
        this.Fecha = Fecha;
    }

    public void setNumero(char[] Numero) {
        this.Numero = Numero;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public char[] getNumero() {
        return Numero;
    }

    public String getFecha() {
        return Fecha;
    }
    
    
    
    public void LeerGUI (int i){
        try{
        Numero = JOptionPane.showInputDialog("Ingrese el numero de reporte").toCharArray();
        }catch(java.lang.NullPointerException e){
            Numero = "".toCharArray();
        }
        Fecha = JOptionPane.showInputDialog("Ingrese la fecha del reporte #"+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        Linea.printf("%s \t %s \t ",String.valueOf(Numero),Fecha);
    }
}
