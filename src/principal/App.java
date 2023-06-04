package principal;
import Controlador.controlador;
import Vista.Ventana;

public class App {
    public static void main(String[] args){
        Ventana vista = new Ventana();
        controlador ctr = new controlador(vista);
        // Ventana v1 = new Ventana();        
        ctr.iniciar();
        vista.setVisible(true);
    }
}

