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

public class ItemDAO {
	
	public boolean salvar(Item item){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO item (nome, quantidade, preco_compra, preco_venda)VALUES(?,?,?,?);");

			stmt.setString(1, item.getNome());
			stmt.setInt(2, item.getQuantidade());
			stmt.setDouble(3, item.getPrecoCompra());
			stmt.setDouble(4, item.getPrecoVenda());

			stmt.executeUpdate();

			
			return true;
	    } catch (SQLException ex){
	    	System.out.println("Erro no cadastro do item: "+ex);
	        	return false;
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public Item buscaItem (Venda venda){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Item item = new Item();
		
		try{
			stmt = con.prepareStatement("SELECT * FROM item");
			rs = stmt.executeQuery();
			while(rs.next()){
				if (rs.getString("nome").equals(venda.getNome())) {
					item.setNome(rs.getString("nome"));
					item.setQuantidade(rs.getInt("quantidade"));
					//item.setPrecoVenda(rs.getDouble("preco_venda"));
					return item;
				}
			}
		System.out.println("\nItem nao encontrado.");
		return item;
		
		}catch(SQLException e){
			System.out.println("\nbuscaItem ERRO: "+e);
			return item;
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	public static int buscarFkItem(Venda venda){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM item");
			rs = stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("nome").equalsIgnoreCase(venda.getNome())){
					return rs.getInt("id_item");
				}
			}
		}catch (SQLException e) {
			System.out.println("buscarFkItem: "+e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return 0;
		
		
	}

	public void update(Venda venda,int fkIdItem){

		Item item = new Item();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("update item set quantidade = (?) where id_item = (?)");

			item = buscaItem(venda);
			
			stmt.setInt(1, item.getQuantidade() - venda.getQuantidade());
			stmt.setInt(2, fkIdItem);
			

			stmt.executeUpdate();

	    } catch (SQLException ex){
	        System.out.println("Update ERRO: "+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
	public void listar(){
		Item cabecario = new Item();
		cabecario.imprimirCabecario();
		
		for(Item item : getList()){
			System.out.println(item.configurarImpressaoEstoque());
		}
		
	}
	
	public List <Item> getList(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Item> itens = new ArrayList<Item>();
		
		
		try{
			stmt = con.prepareStatement("select * from item");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Item newItem = new Item();
				
				newItem.setNome(rs.getString("nome"));
				newItem.setQuantidade(rs.getInt("quantidade"));
				newItem.setPrecoCompra(rs.getDouble("preco_compra"));
				newItem.setPrecoVenda(rs.getDouble("preco_venda"));
				
				itens.add(newItem);
			}
			rs.close();
			return itens;
			
		}catch(SQLException ex){
			System.out.println("getList ERRO: "+ex);
			return itens;
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
}
