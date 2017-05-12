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
		
		if(item.getQuantidade()>= venda.getQuantidade() && venda.getQuantidade() > 0)
			return true;

		System.out.println("A quantidade de venda deve ser menor que a do estoque e maior que 0.\n\n");
		return false;
		}
	}
	

