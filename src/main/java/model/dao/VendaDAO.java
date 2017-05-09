package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Item;
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
	
	public void listar(){
		
		for(Venda venda : getList()){
			System.out.println(venda.toString());
		}
		
	}
	
	public List <Venda> getList(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Venda> vendas = new ArrayList<Venda>();
		
		
		try{
			stmt = con.prepareStatement("select * from venda");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Venda novaVenda = new Venda();
				
				novaVenda.setNome(rs.getString("nome"));
				novaVenda.setQuantidade(rs.getInt("quantidade"));
				novaVenda.setPrecoVenda(rs.getDouble("preco_venda"));
				
				vendas.add(novaVenda);
			}
			rs.close();
			return vendas;
			
		}catch(SQLException ex){
			System.out.println(ex);
			return vendas;
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
}
