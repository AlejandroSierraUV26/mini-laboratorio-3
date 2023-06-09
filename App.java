import Controlador.Control;
import Modelo.Dulce;
import Vista.Ventana;

public class App {
    public static void main(String[] args) {
        Ventana v1 = new Ventana();
        Dulce d1 = new Dulce();
        Control c1 = new Control(d1, v1);
        c1.iniciarVista();
        
    }
}
