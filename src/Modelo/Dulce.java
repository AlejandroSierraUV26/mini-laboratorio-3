package Modelo;

public class Dulce {
    private String nombre;
    private String categoria;
    private short cantidad;
    private short precio;
    private String codigo;
    public Dulce(){
        
    }
    public Dulce(String nombre,String codigo, String categoria, short cantidad, short precio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;

    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public short getCantidad() {
        return cantidad;
    }
    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }
    public short getPrecio() {
        return precio;
    } 
    public void setPrecio(short precio) {
        this.precio = precio;
    }
    public String MostrarDatos(){
        String texto;
        texto =(   "           Nombre: " + getNombre()+"                            \n"
                +  "           Codigo : "+ getCodigo() +"                           \n" 
                +  "           Precio : "+ getPrecio() +"                           \n"
                +  "           Categoria : " + getCategoria() +"                \n"                
                +  "           Cantidad : "+ getCantidad()+"                       "); 
        return texto;
    }
}
