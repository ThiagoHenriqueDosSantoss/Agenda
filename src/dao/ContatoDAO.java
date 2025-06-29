package dao;

import config.DatabaseConnection;
import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    public void inserir(Contato contato) throws SQLException {
        //logica para inserir os contatos
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?,?,?);";
        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getTelefone());
        stmt.setString(3, contato.getEmail());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    public List<Contato> listar() throws SQLException{
        String sql = "SELECT * FROM contatos;";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();


        while(rs.next()) {
            Contato contato = new Contato();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));

            contatos.add(contato);
        }
        stmt.close();
        conn.close();

        return contatos;
    }
    public Contato buscarPorNome(String nome) throws SQLException{
        Contato contato = new Contato();
        String sql = "SELECT * FROM contatos WHERE nome = ?;";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,nome);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {

            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));

            contatos.add(contato);
        }
        stmt.close();
        conn.close();
        return contato;
    }
    public List<Contato> listarOrdenadoPorNome() throws SQLException{
        String sql = "SELECT * FROM contatos ORDER BY nome ASC;";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();


        while(rs.next()) {
            Contato contato = new Contato();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));

            contatos.add(contato);
        }
        stmt.close();
        conn.close();

        return contatos;
    }
    public void atualizarEmail(int id, Contato contato) throws SQLException{
        String sql = "UPDATE contatos SET email = ? WHERE id = ?;";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, contato.getEmail());
        stmt.setInt(2, id);

        stmt.executeUpdate();

        conn.close();
        stmt.close();
    }
    public List<Contato> listarEmailPorDominio(String dominio) throws SQLException{
        String sql = "SELECT * FROM contatos WHERE email ILIKE ?;";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, "%@" + dominio);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Contato contato = new Contato();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));

            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        conn.close();

        return contatos;
    }
    public void atualizar(Contato contato) throws SQLException{
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?;";

        Connection conn = DatabaseConnection.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);


        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getTelefone());
        stmt.setString(3, contato.getEmail());
        stmt.setInt(4,contato.getId());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
