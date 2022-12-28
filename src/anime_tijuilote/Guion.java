package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Guion extends Diseño{
    private String Mangaka;

    public Guion() {
        super();
        this.Mangaka = "";
    }

    public Guion( String Nombre, String Genero, String Casa_Animacion,String Mangaka) {
        super( Nombre, Genero, Casa_Animacion);
        this.Mangaka = Mangaka;
    }

    public void setMangaka(String Mangaka) {
        this.Mangaka = Mangaka;
    }

    public String getMangaka() {
        return Mangaka;
    }

    public void LeerGUI (int i){
        super.LeerGUI(i);
        Mangaka = JOptionPane.showInputDialog("Ingrese el mangaka del anime #"+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \n",Mangaka);
    }
}
