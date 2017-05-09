package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Venda;
import model.ConnectionFactory;

public class VendaDAO {

	public void fazerVenda(Venda venda){

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO venda (nome, quantidade, preco_venda) VALUES (?,?,?);");

			stmt.setString(1, venda.getNome());
			stmt.setInt(2, venda.getQuantidade());
			stmt.setDouble(3, venda.getPrecoVenda());

			stmt.executeUpdate();
			
	    } catch (SQLException ex){
	    	System.out.println(ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
}
