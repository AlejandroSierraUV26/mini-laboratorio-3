package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// import javax.swing.JOptionPane;

import Modelo.Dulce;
import Vista.Ventana;

public class Control implements ActionListener{
    private Dulce modelo;
    private Ventana vista;
    ArrayList <Dulce> lista_dulces = new ArrayList<Dulce>();

    public Control(Dulce modelo, Ventana vista){
        this.modelo = modelo;
        this.vista = vista;
        
    }
    public void iniciarVista(){
        vista.setSize(500, 500); 
        vista.setTitle("RINCON DULCE");
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.botonesPanelPrincipal[0].addActionListener(this);
        vista.botonesPanelPrincipal[1].addActionListener(this);
        vista.botonesPanelPrincipal[2].addActionListener(this);
        vista.botonesPanelPrincipal[3].addActionListener(this);
        vista.botonesPanelPrincipal[4].addActionListener(this);
        vista.botonEnviarActualizar.addActionListener(this);
        vista.botonEnviarInsertar.addActionListener(this);
        vista.botonEnviarActualizarOpciones.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonRegresar.addActionListener(this);
        vista.botonRegresarListar.addActionListener(this);
        vista.setVisible(true);


        
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        vista.categoriaSeleccionada = vista.categorias.getSelectedItem().toString();
        if(evento.getSource() == vista.botonesPanelPrincipal[0]){
            vista.panelPrincipal.setVisible(false);
            vista.panelInsertar.setVisible(true);
            vista.add(vista.panelInsertar);
            modelo.psbotonInsertar();   
        }
        else if(evento.getSource()==vista.botonEnviarInsertar){
            //  if(vista.contenido.isEmpty() && vista.contenido2.isEmpty() && vista.contenido3.isEmpty()){
            //     JOptionPane.showMessageDialog(null,"Llene todas las casillas","Advertencia",JOptionPane.WARNING_MESSAGE);       
            // }
            // else{
                String codigo="";
                int x,n;
                String[] letras = 
                {"A","B","C","D","E",
                "F","G","H","I","J", 
                "K","L","M","N","O", 
                "P","Q","R","S","T", 
                "U","V","W","X","Y","Z"};
                for (int i =0;i<3;i++){
                    x = (int) (Math.random() * 26 + 0);
                    codigo += letras[x];
                }
                for (int i =0;i<3;i++){
                    n = (int) (Math.random() * 10 + 0);
                    codigo += n;
                }
                
                Dulce n1 = new Dulce(vista.areaTextoNombre.getText(),codigo,vista.categorias.getSelectedItem().toString(),Short.parseShort(vista.areaTextoCantidad.getText()),Short.parseShort(vista.areaTextoPrecio.getText()));
                lista_dulces.add(n1);
                
                JOptionPane.showMessageDialog(null,"El codigo del producto es: " + codigo, "CODIGO", JOptionPane.INFORMATION_MESSAGE);
                vista.areaTextoNombre.setText(null);
                vista.categorias.setSelectedItem("Acido");
                vista.areaTextoPrecio.setText(null);;
                vista.areaTextoCantidad.setText(null);
                vista.panelInsertar.setVisible(false);
                vista.panelPrincipal.setVisible(true);
                vista.add(vista.panelPrincipal);
            // }
            
            
        }
        else if(evento.getSource() == vista.botonesPanelPrincipal[1]){
            vista.panelPrincipal.setVisible(false);
            vista.panelActualizar.setVisible(true);
            vista.add(vista.panelActualizar);
            modelo.psbotonActualizar();
        }
        else if(evento.getSource()==vista.botonEnviarActualizar){
                if(vista.areaTextoActualizar.getText().isEmpty() || vista.areaTextoActualizar.getText().length()<6){
                    JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
                else{                    
                vista.etiquetaActualizarDatos.setText(vista.areaTextoActualizar.getText());
                vista.panelActualizar.setVisible(false);             
                vista.panelActualizarDatos.setVisible(true);
                vista.add(vista.panelActualizarDatos);
                }
        }
        else if(evento.getSource() == vista.botonEnviarActualizarOpciones){
            vista.contenido5 = vista.areaTextoActualizarNombre.getText().trim();
            vista.contenido6 = vista.areaTextoActualizarPrecio.getText().trim();
            vista.contenido7 = vista.areaTextoActualizarCantidad.getText().trim();
            for(int i=0; i<lista_dulces.size();i++){
                if(lista_dulces.get(i).getCodigo().equals(vista.areaTextoActualizar.getText())){
                    if(vista.checkBox1.isSelected()){
                        lista_dulces.get(i).setNombre(vista.contenido5);
                        
                        }
                    if(vista.checkBox2.isSelected()){
                        lista_dulces.get(i).setPrecio(Short.parseShort(vista.contenido6));
                        
                    }
                    if(vista.checkBox3.isSelected()){
                        lista_dulces.get(i).setCantidad(Short.parseShort(vista.contenido6));      
                        
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

        else if(evento.getSource() == vista.botonesPanelPrincipal[2]){
            vista.panelPrincipal.setVisible(false);
            vista.panelEliminar.setVisible(true);
            vista.add(vista.panelEliminar);
            modelo.psbotonEliminar();
        }
        else if(evento.getSource() == vista.botonEliminar){
            vista.contenido8 = vista.areaTextoEliminar.getText().trim();
            if(vista.contenido8.isEmpty() || vista.contenido8.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int i=0; i<lista_dulces.size();i++){
                    if(lista_dulces.get(i).getCodigo().equals(vista.contenido8)){
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
        else if(evento.getSource() == vista.botonesPanelPrincipal[3]){
            vista.panelPrincipal.setVisible(false);
            vista.panelBuscar.setVisible(true);
            vista.add(vista.panelBuscar);
            modelo.psbotonBuscar();
        }
        else if(evento.getSource() == vista.botonBuscar){
            vista.contenido9 = vista.areaTextoBuscar.getText().trim();
            if(vista.contenido9.isEmpty() || vista.contenido9.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                    for(int i=0; i<lista_dulces.size();i++){
                        if(lista_dulces.get(i).getCodigo().equals(vista.contenido9)){
                            vista.etiquetaBuscarNombre.setText("Nombre: " + lista_dulces.get(i).getNombre());
                            vista.etiquetaBuscarCategoria.setText("Categoria: "+ lista_dulces.get(i).getCategoria());
                            vista.etiquetaBuscarCantidad.setText("Cantidad: "+ lista_dulces.get(i).getCantidad());
                            vista.etiquetaBuscarPrecio.setText("Precio: " + lista_dulces.get(i).getPrecio());
                        }
            }

        }
        }
        else if(evento.getSource() == vista.botonRegresar){
            vista.areaTextoBuscar.setText(null);
            vista.etiquetaBuscarNombre.setText(null);
            vista.etiquetaBuscarCategoria.setText(null);
            vista.etiquetaBuscarCantidad.setText(null);
            vista.etiquetaBuscarPrecio.setText(null);
            vista.panelBuscar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }
        else if(evento.getSource() == vista.botonesPanelPrincipal[4]){
            for(int i = 0; i<lista_dulces.size(); i++){
                vista.areaTextoListar.append(lista_dulces.get(i).MostrarDatos() + "\n\n");
            }
            vista.panelPrincipal.setVisible(false);
            vista.panelListar.setVisible(true);            
            vista.add(vista.panelListar);
            modelo.psbotonListar();
        }
        else if(evento.getSource() == vista.botonRegresarListar){
            vista.areaTextoListar.setText(null);
            vista.panelListar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }

    }
    
}
