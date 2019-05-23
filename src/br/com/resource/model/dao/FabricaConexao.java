package br.com.resource.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaConexao {
    
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String URL      = "jdbc:mysql://localhost:3306/loja"
    										+ "?useTimezone=true&serverTimezone=UTC";
    private static final String USER     = "root";
    private static final String PASS     = "";
            
    public static Connection getConexao(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro de conexão", e);
            
        }
    }
    
    public static void fecharConexao(Connection conn){
        if(conn != null){    
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement pstm){
        if(pstm!=null){
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
        fecharConexao(conn);
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement pstm, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex){
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
        fecharConexao(conn, pstm);
    }
}