
package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author fercast
 */
public abstract class Atributos extends Anime{
    private String Nombre;
    private String Genero;

    public Atributos() {
        this.Nombre = "";
        this.Genero = "";
    }

    public Atributos(String Nombre, String Genero) {
        this.Nombre = Nombre;
        this.Genero = Genero;
    }

    //Voids
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    //Funciones
    public String getNombre() {
        return Nombre;
    }

    public String getGenero() {
        return Genero;
    }
    
    
    
    public void LeerGUI (int i){
        Nombre = JOptionPane.showInputDialog("Ingrese el nombre del anime # "+(i+1));
        Genero = JOptionPane.showInputDialog("Ingrese el genero al que pertenece el anime # "+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        Linea.printf("%s \t %s \t ",Nombre,Genero);
    }
    
}
