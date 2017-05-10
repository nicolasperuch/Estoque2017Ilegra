package domain;

import java.util.Scanner;

import model.dao.ItemDAO;

public class DadosVenda {
	
	public Venda entradaDeDadosVenda(){
		
		Scanner input = new Scanner(System.in);
		Venda venda = new Venda();
		
		System.out.printf("\n\tVENDA\nInsira o nome do item que deseja vender: ");
		venda.setNome(input.nextLine());
		System.out.printf("Insira a quantidade que deseja vender: ");
		venda.setQuantidade(input.nextInt());
		
		return venda;
	}
	
	public boolean validarVenda (Venda venda){
		ItemDAO itemDAO = new ItemDAO();
		Item item = new Item();
		
		item = itemDAO.buscaItem(venda);
		
		if(item.getQuantidade()> venda.getQuantidade()){
			return true;
		}else{
			System.out.println("\n\tOcorreu um erro durante a venda\n\n");
			return false;
		}
	}
	

}
