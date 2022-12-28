package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Diseño extends Atributos{
    private String Casa_Animacion;

    public Diseño() {
        super();
        this.Casa_Animacion = "";
    }

    public Diseño(String Nombre, String Genero, String Casa_Animacion) {
        super(Nombre, Genero);
        this.Casa_Animacion = Casa_Animacion;
    }

    public void setCasa_Animacion(String Casa_Animacion) {
        this.Casa_Animacion = Casa_Animacion;
    }

    public String getCasa_Animacion() {
        return Casa_Animacion;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        Casa_Animacion = JOptionPane.showInputDialog("Ingrese la casa de animacion del anime # "+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t",Casa_Animacion);
    }
}
