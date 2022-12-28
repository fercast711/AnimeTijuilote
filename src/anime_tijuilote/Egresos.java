package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Egresos extends Registro_Reportes{
    private float Cant;

    public Egresos() {
        super();
        this.Cant = 0;
    }

    public Egresos(char[] Numero, String Fecha, float Cant ) {
        super(Numero, Fecha);
        this.Cant = Cant;
    }

    public void setCant(float Cant) {
        this.Cant = Cant;
    }

    public float getCant() {
        return Cant;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        try{
        Cant = Float.parseFloat(JOptionPane.showInputDialog("Ingrese los Egresos del reporte #"+(i+1)));
        }catch(java.lang.NumberFormatException e){
            Cant= 0;
        }catch(java.lang.NullPointerException e){
            Cant = 0;
        }
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \n",Cant);
    }
}
