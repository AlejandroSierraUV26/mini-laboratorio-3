package principal;
import Controlador.Controlador;
import Modelo.Dulce;
import Vista.Ventana;

public class App {
    public static void main(String[] args){
        Dulce modelo = new Dulce();
        Ventana vista = new Ventana();
        Controlador control = new Controlador(vista,modelo);
        control.Iniciar();     
    }
}

