package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static String url = "jdbc:postgresql://localhost:5432/agenda";
    private static String user = "postgre";
    private static String password = "123";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }
}
