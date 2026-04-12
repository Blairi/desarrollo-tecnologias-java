package mx.unam.dgtic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainJDBC {
    public static void main(String[] args) {

        // Datos de conexion
        String URL = "jdbc:mariadb://172.17.0.2:3306/cursos";
        String USER = "cursos";
        String PASSWORD = "cursos";

        try {

            // Obtener conexion del DriverManager
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Obtener Statement
            Statement stmt = conn.createStatement();

            // Ejecutar consulta y obtener resultados en un ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM estudiante");

            // Recorrer los resultados
            while (rs.next()) {
                int idEstudiante = rs.getInt("id_estudiante");
                String nombre =  rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String correoElectronico = rs.getString("correo_electronico");

                System.out.println(idEstudiante + " " + nombre + " "
                        + apellidoPaterno + " " + correoElectronico);

            }

            // Cerrar recursos
            rs.close();
            stmt.close();
            conn.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}