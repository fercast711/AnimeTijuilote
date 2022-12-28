package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Audio extends Diseño{
    private String Actor;
    private String Op;
    private String End;

    public Audio() {
        super();
        this.Actor = "";
        this.Op = "";
        this.End = "";
    }

    public Audio(String Nombre, String Genero,  String Casa_Animacion, String Actor, String Op, String End ) {
        super( Nombre, Genero, Casa_Animacion);
        this.Actor = Actor;
        this.Op = Op;
        this.End = End;
    }

    public void setActor(String Actor) {
        this.Actor = Actor;
    }

    public void setOp(String Op) {
        this.Op = Op;
    }

    public void setEnd(String End) {
        this.End = End;
    }

    public String getActor() {
        return Actor;
    }

    public String getOp() {
        return Op;
    }

    public String getEnd() {
        return End;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        Actor = JOptionPane.showInputDialog("Ingrese un actor de voz del anime #"+(i+1));
        Op = JOptionPane.showInputDialog("Ingrese una banda de opening del anime #"+(i+1));
        End = JOptionPane.showInputDialog("Ingrese una banda de ending del anime #"+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \t %s \n",Actor, Op, End);
    }
}
