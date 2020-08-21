package ejercicioswing1;

import javax.swing.JOptionPane;

public class Alumno {
    // Variables de Clase o Instancia
    public int expediente;
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public double promedio;
    public String sexo;
    public String carrera;
    
    // Constructor
    public Alumno() {
        System.out.println("Se creó un alumno");
    }
    
    // Constructor con parámetros
    public Alumno(int expediente,String nombre, String apellidoPaterno
        ,String apellidoMaterno, double promedio
        ,String sexo, String carrera) {
        
        
        this.expediente = expediente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.promedio = promedio;
        this.sexo = sexo;
        this.carrera = carrera;
        
        // this.mostrarDatos();
    }
    
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, 
            "Alumno con los datos: "
            + "\nExpediente" + expediente
            + "\nNombre: " + nombre
            + "\nApellido Paterno: " + apellidoPaterno
            + "\nApellido Materno: " + apellidoMaterno
            + "\nPromedio: " + promedio
            + "\nSexo: " + sexo
            + "\nCarrera: " + carrera );
    }
}
