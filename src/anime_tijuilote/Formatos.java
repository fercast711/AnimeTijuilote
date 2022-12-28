package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author fercast
 */
public abstract class Formatos extends Anime {
    private String Titulo;
    private String Fecha;

    public Formatos() {
        this.Titulo = "";
        this.Fecha = "";
    }

    public Formatos(String Titulo, String Fecha) {
        this.Titulo = Titulo;
        this.Fecha = Fecha;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getFecha() {
        return Fecha;
    }
    
    
    
    public void LeerGUI (int i){
    Titulo = JOptionPane.showInputDialog("Ingrese el titulo del anime");
    Fecha = JOptionPane.showInputDialog("Ingrese la fecha de estreno del anime #"+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        Linea.printf("%s \t %s \t ",Titulo,Fecha);
    }
    
}
