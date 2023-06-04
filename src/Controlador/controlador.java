package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Modelo.Dulce;
import Vista.Ventana;

public class controlador implements ActionListener{
    private Ventana vista;
    public controlador(Ventana vista){
        this.vista = vista;   
        for(int i = 0; i<5; i++){
            vista.botonesPanelPrincipal[0].addActionListener(this);
        }
        vista.categorias.addActionListener(this);
        vista.botonEnviarInsertar.addActionListener(this);
        vista.botonEnviarInsertar.addActionListener(this);
        vista.botonEnviarActualizar.addActionListener(this);
        vista.botonEnviarActualizarOpciones.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonRegresar.addActionListener(this);
        vista.botonRegresarListar.addActionListener(this);

        
    }
    public void iniciar(){
        vista.iniciarComponentes();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        vista.contenido = vista.areaTextoNombre.getText().trim();
        vista.contenido2 = vista.areaTextoPrecio.getText().trim();
        vista.contenido3 = vista.areaTextoCantidad.getText().trim();
        vista.contenido4 = vista.areaTextoActualizar.getText().trim();
        vista.categoriaSeleccionada = vista.categorias.getSelectedItem().toString();
        if(e.getSource()==vista.botonesPanelPrincipal[0]){
            vista.panelPrincipal.setVisible(false);
            vista.panelInsertar.setVisible(true);
            vista.add(vista.panelInsertar);
        }
        else if(e.getSource()==vista.botonEnviarInsertar){
            if(vista.contenido.isEmpty() || vista.contenido2.isEmpty() || vista.contenido3.isEmpty()){
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
                Dulce n1 = new Dulce(vista.contenido,codigo,vista.categoriaSeleccionada,Short.parseShort(vista.contenido3),Short.parseShort(vista.contenido2));
                vista.lista_dulces.add(n1);
                
                

                

                
                
                
                System.out.println(vista.lista_dulces.get(0));
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
            if(vista.contenido4.isEmpty() || vista.contenido4.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                vista.etiquetaActualizarDatos.setText(vista.contenido4);
                vista.panelActualizar.setVisible(false);             
                vista.panelActualizarDatos.setVisible(true);
                vista.add(vista.panelActualizarDatos);
            }
        }
        else if(e.getSource() == vista.botonEnviarActualizarOpciones){
            vista.contenido5 = vista.areaTextoActualizarNombre.getText().trim();
            vista.contenido6 = vista.areaTextoActualizarPrecio.getText().trim();
            vista.contenido7 = vista.areaTextoActualizarCantidad.getText().trim();
            if(vista.contenido5.isEmpty() && vista.contenido6.isEmpty() && vista.contenido7.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion y llenarla para actualizar","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int i=0; i<vista.lista_dulces.size();i++){
                    if(vista.lista_dulces.get(i).getCodigo().equals(vista.contenido4)){
                        if(vista.checkBox1.isSelected()){
                            vista.lista_dulces.get(i).setNombre(vista.contenido5);
                        }
                        if(vista.checkBox2.isSelected()){
                            vista.lista_dulces.get(i).setPrecio(Short.parseShort(vista.contenido6));
                        }
                        if(vista.checkBox3.isSelected()){
                            vista.lista_dulces.get(i).setCantidad(Short.parseShort(vista.contenido6));      
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
            vista.contenido8 = vista.areaTextoEliminar.getText().trim();
            if(vista.contenido8.isEmpty() || vista.contenido8.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                System.out.println(vista.contenido8);
                for(int i=0; i<vista.lista_dulces.size();i++){
                    if(vista.lista_dulces.get(i).getCodigo().equals(vista.contenido8)){
                        vista.lista_dulces.remove(vista.lista_dulces.get(i));
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
            vista.contenido9 = vista.areaTextoBuscar.getText().trim();
            if(vista.contenido9.isEmpty() || vista.contenido9.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int i=0; i<vista.lista_dulces.size();i++){
                    if(vista.lista_dulces.get(i).getCodigo().equals(vista.contenido9)){
                        vista.etiquetaBuscarNombre.setText("Nombre: " + vista.lista_dulces.get(i).getNombre());
                        vista.etiquetaBuscarCategoria.setText("Categoria: "+ vista.lista_dulces.get(i).getCategoria());
                        vista.etiquetaBuscarCantidad.setText("Cantidad: "+ vista.lista_dulces.get(i).getCantidad());
                        vista.etiquetaBuscarPrecio.setText("Precio: " + vista.lista_dulces.get(i).getPrecio());
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
            for(int i = 0; i<vista.lista_dulces.size(); i++){
                vista.areaTextoListar.append(vista.lista_dulces.get(i).MostrarDatos() + "\n\n");
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
