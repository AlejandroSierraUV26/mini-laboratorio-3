package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Dulce;
import Vista.Ventana;

public class Controlador implements ActionListener{
    private Dulce modelo;
    private Ventana vista;
    public ArrayList <Dulce> lista_dulces = new ArrayList<Dulce>();
    public String contenido, contenido2, contenido3, contenido4, contenido5, contenido6, contenido7, contenido8, contenido9, categoriaSeleccionada;
    public Controlador(Ventana vista,Dulce modelo){
        this.modelo = modelo;
        this.vista = vista;   
    }
    public void Iniciar(){
        Ventana v1 = new Ventana();
        v1.setVisible(true);
        

    }
    @Override
    public void actionPerformed(ActionEvent e){
        contenido = vista.areaTextoNombre.getText().trim();
        contenido2 = vista.areaTextoPrecio.getText().trim();
        contenido3 = vista.areaTextoCantidad.getText().trim();
        contenido4 = vista.areaTextoActualizar.getText().trim();
        categoriaSeleccionada = vista.categorias.getSelectedItem().toString();
        if(e.getSource()==vista.botonesPanelPrincipal[0]){
            vista.panelPrincipal.setVisible(false);
            vista.panelInsertar.setVisible(true);
            vista.add(vista.panelInsertar);
        }
        else if(e.getSource()==vista.botonEnviarInsertar){
            if(contenido.isEmpty() || contenido2.isEmpty() || contenido3.isEmpty()){
                JOptionPane.showMessageDialog(null,"Llene todas las casillas","Advertencia",JOptionPane.WARNING_MESSAGE);       
            }
            else{
                String codigo="";
                int x,n;
                String[] letras = 
                {"A","B","C","D","E",
                "F","G","H","I","J", 
                "K","L","M","N","O", 
                "P","Q","R","S","T", 
                "U","V","W","X","Y","Z"};
                //Pendiente comparacion para codigos iguales existentes.
                for (int i =0;i<3;i++){
                    x = (int) (Math.random() * 26 + 0);
                    codigo += letras[x];
                }
                for (int i =0;i<3;i++){
                    n = (int) (Math.random() * 10 + 0);
                    codigo += n;
                }
                modelo = new Dulce(contenido,codigo,categoriaSeleccionada,Short.parseShort(contenido3),Short.parseShort(contenido2));
                lista_dulces.add(modelo);
                
                

                


                System.out.println(lista_dulces.get(0));
                JOptionPane.showMessageDialog(null,"El codigo del producto es: " + codigo, "CODIGO", JOptionPane.INFORMATION_MESSAGE);
                vista.areaTextoNombre.setText(null);
                vista.categorias.setSelectedItem("Acido");
                vista.areaTextoPrecio.setText(null);;
                vista.areaTextoCantidad.setText(null);
                vista.panelInsertar.setVisible(false);
                vista.panelPrincipal.setVisible(true);
                vista.add(vista.panelPrincipal);
            }
            
            
        }
        else if(e.getSource()==vista.botonesPanelPrincipal[1]){
            vista.panelPrincipal.setVisible(false);
            vista.panelActualizar.setVisible(true);
            vista.add(vista.panelActualizar);
        }
        else if(e.getSource()==vista.botonEnviarActualizar){
            if(contenido4.isEmpty() || contenido4.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                vista.etiquetaActualizarDatos.setText(contenido4);
                vista.panelActualizar.setVisible(false);             
                vista.panelActualizarDatos.setVisible(true);
                vista.add(vista.panelActualizarDatos);
            }
        }
        else if(e.getSource() == vista.botonEnviarActualizarOpciones){
            contenido5 = vista.areaTextoActualizarNombre.getText().trim();
            contenido6 = vista.areaTextoActualizarPrecio.getText().trim();
            contenido7 = vista.areaTextoActualizarCantidad.getText().trim();
            if(contenido5.isEmpty() && contenido6.isEmpty() && contenido7.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion y llenarla para actualizar","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int i=0; i<lista_dulces.size();i++){
                    if(lista_dulces.get(i).getCodigo().equals(contenido4)){
                        if(vista.checkBox1.isSelected()){
                            lista_dulces.get(i).setNombre(contenido5);
                        }
                        if(vista.checkBox2.isSelected()){
                            lista_dulces.get(i).setPrecio(Short.parseShort(contenido6));
                        }
                        if(vista.checkBox3.isSelected()){
                            lista_dulces.get(i).setCantidad(Short.parseShort(contenido6));      
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,"Producto Actualizado","Actualizado",JOptionPane.INFORMATION_MESSAGE);
                vista.checkBox1.setSelected(false);
                vista.checkBox2.setSelected(false);
                vista.checkBox3.setSelected(false);
                vista.areaTextoActualizar.setText(null);
                vista.areaTextoActualizarNombre.setText(null);
                vista.areaTextoActualizarPrecio.setText(null);
                vista.areaTextoActualizarCantidad.setText(null);
                vista.panelActualizarDatos.setVisible(false);
                vista.panelPrincipal.setVisible(true);
                
                vista.add(vista.panelPrincipal);
            }
        }
        else if(e.getSource() == vista.botonesPanelPrincipal[2]){
            vista.panelPrincipal.setVisible(false);
            vista.panelEliminar.setVisible(true);
            vista.add(vista.panelEliminar);
        }
        else if(e.getSource() == vista.botonEliminar){
            contenido8 = vista.areaTextoEliminar.getText().trim();
            if(contenido8.isEmpty() || contenido8.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                System.out.println(contenido8);
                for(int i=0; i<lista_dulces.size();i++){
                    if(lista_dulces.get(i).getCodigo().equals(contenido8)){
                        lista_dulces.remove(lista_dulces.get(i));
                    }
                }
                
                JOptionPane.showMessageDialog(null,"Producto Eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
                vista.areaTextoEliminar.setText(null);
                vista.panelEliminar.setVisible(false);
                vista.panelPrincipal.setVisible(true);
                vista.add(vista.panelPrincipal);
            }
        }
        else if(e.getSource() == vista.botonesPanelPrincipal[3]){
            vista.panelPrincipal.setVisible(false);
            vista.panelBuscar.setVisible(true);
            vista.add(vista.panelBuscar);
        }
        else if(e.getSource() == vista.botonBuscar){
            contenido9 = vista.areaTextoBuscar.getText().trim();
            if(contenido9.isEmpty() || contenido9.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int i=0; i<lista_dulces.size();i++){
                    if(lista_dulces.get(i).getCodigo().equals(contenido9)){
                        vista.etiquetaBuscarNombre.setText("Nombre: " + lista_dulces.get(i).getNombre());
                        vista.etiquetaBuscarCategoria.setText("Categoria: "+ lista_dulces.get(i).getCategoria());
                        vista.etiquetaBuscarCantidad.setText("Cantidad: "+ lista_dulces.get(i).getCantidad());
                        vista.etiquetaBuscarPrecio.setText("Precio: " + lista_dulces.get(i).getPrecio());
                    }
                }

            }
            
        }
        else if(e.getSource() == vista.botonRegresar){
            vista.areaTextoBuscar.setText(null);
            vista.etiquetaBuscarNombre.setText(null);
            vista.etiquetaBuscarCategoria.setText(null);
            vista.etiquetaBuscarCantidad.setText(null);
            vista.etiquetaBuscarPrecio.setText(null);
            vista.panelBuscar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }
        else if(e.getSource() == vista.botonesPanelPrincipal[4]){
            for(int i = 0; i<lista_dulces.size(); i++){
                vista.areaTextoListar.append(lista_dulces.get(i).MostrarDatos() + "\n\n");
            }
            vista.panelPrincipal.setVisible(false);
            vista.panelListar.setVisible(true);            
            vista.add(vista.panelListar);
        }
        else if(e.getSource() == vista.botonRegresarListar){
            vista.areaTextoListar.setText(null);
            vista.panelListar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }

    }

}
