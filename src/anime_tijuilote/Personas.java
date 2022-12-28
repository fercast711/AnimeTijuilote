
package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public abstract class Personas extends Anime{
    private String Nombre;
    private char Genero;

    public Personas() {
        this.Nombre = "";
        this.Genero = ' ';
    }

    public Personas(String Nombre, char Genero) {
        this.Nombre = Nombre;
        this.Genero = Genero;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getGenero() {
        return Genero;
    }
    
    
    public void LeerGUI(int i){
        Nombre = JOptionPane.showInputDialog("Ingrese el nombre");
        try{
        Genero = JOptionPane.showInputDialog("Ingrese el genero #"+(i+1)).charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
        Genero = ' ';
        }
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        Linea.printf("%s \t %s \t ",Nombre,Genero);
    }
}
