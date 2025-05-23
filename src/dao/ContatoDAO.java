package dao;

import config.DatabaseConnection;
import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    public void inserir(Contato contato) throws SQLException {
        //logica para inserir os contatos
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?,?,?);";
        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getTelefone());
        stmt.setString(3, contato.getEmail());

        stmt.execute();

        stmt.close();
        conn.close();
    }
}
