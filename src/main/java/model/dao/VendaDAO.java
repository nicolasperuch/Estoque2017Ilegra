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

	public void fazerVenda(Venda venda, int fkItem){

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO venda (quantidade, fk_item ) VALUES (?,?);");

			stmt.setInt(1, venda.getQuantidade());
			stmt.setInt(2, fkItem);
			
			stmt.executeUpdate();
			
	    } catch (SQLException ex){
	    	System.out.println("VendaDAO"+ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void listar(){
		Venda cabecario = new Venda();
		cabecario.imprimirCabecario();
		for(Item item : getList()){
			System.out.println(item.configurarImpressaoVenda());
		}
		
	}
	
	public List <Item> getList(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Item> itens = new ArrayList<Item>();
		
		
		try{
			stmt = con.prepareStatement("select i.nome, v.quantidade, i.preco_compra, i.preco_venda from venda as v  inner join item as i  on v.fk_item = i.id_item");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Item novoItem = new Item();
				
				novoItem.setNome(rs.getString("nome"));
				novoItem.setQuantidade(rs.getInt("quantidade"));
				novoItem.setPrecoCompra(rs.getDouble("preco_compra"));
				novoItem.setPrecoVenda(rs.getDouble("preco_venda"));
				
				itens.add(novoItem);
			}
			rs.close();
			return itens;
			
		}catch(SQLException ex){
			System.out.println(ex);
			return itens;
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
}
