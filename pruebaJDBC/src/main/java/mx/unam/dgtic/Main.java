package mx.unam.dgtic;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String URL = "jdbc:mariadb://localhost:3306/cursos";
        String USER = "cursos";
        String PASSWORD = "cursos";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM estudiante");

            while (resultSet.next()) {
                int idEstudiante = resultSet.getInt("id_estudiante");
                String nombre = resultSet.getString("nombre");
                String apellidoPaterno = resultSet.getString("apellido_paterno");
                String correoElectronico = resultSet.getString("correo_electronico");

                System.out.println(
                        idEstudiante + ", " + nombre + ", " + apellidoPaterno + ", " + correoElectronico);

            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}