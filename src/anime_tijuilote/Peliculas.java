
package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Peliculas extends Formatos{
    private String Duracion;

    public Peliculas() {
        super();
        this.Duracion = "";
    }

    public Peliculas(String Titulo, String Fecha, String Duracion) {
        super(Titulo, Fecha);
        this.Duracion = Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getDuracion() {
        return Duracion;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
    Duracion = JOptionPane.showInputDialog("Ingrese la duracion de la pelicula #"+(i+1));
    
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \n ",Duracion);
    }
}
