package domain;

import java.util.Scanner;

public class DadosItem {

	public Item entradaDeDadosItem(){
		
		Scanner input = new Scanner(System.in);
		Item item = new Item();
		
		System.out.printf("\n\tADICAO DE ITEM\n Insira os seguintes dados\n Nome: ");
		item.setNome(input.nextLine());
		System.out.printf("Quantidade: ");
		item.setQuantidade(input.nextInt());
		System.out.printf("Preco de Compra: ");
		item.setPrecoCompra(input.nextDouble());
		System.out.printf("Preco de Venda: ");
		item.setPrecoVenda(input.nextDouble());
		
		return item;
	}
	
	public boolean validarDados(Item item){
		if(item.verificarItemNome() && item.verificarItemQuantidade())
			if(item.verificarItemPrecoCompra() && item.verificarItemPrecoVenda())
						return true;
						
		return false;
	}
	

	
	
}
