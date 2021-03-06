import java.util.Scanner;

import domain.Item;
import domain.Venda;
import model.dao.ItemDAO;
import model.dao.VendaDAO;

public class Main {

	public static void main(String[] args) {
		
		int escolhaMenu;
		
		do{
			escolhaMenu = menu();
			
			switch(escolhaMenu){
				case 1:
					adicionarItem();
				break;
				case 2:
					fazerVenda();
				break;
				case 3:
					exibirEstoque();
				break;
				default:
				System.out.println("\n Opcao Invalida");
				break;
				case 0:
				System.out.println("\n Obrigado por utilizar nosso sistema!\n\n");
			}
			
		}while(escolhaMenu > 0);
		
		
	}
	
	
	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.printf("\n\tSISTEMA DE ESTOQUE\n\n 1 - Inserir item ao estoque\n 2 - Fazer Venda\n 3 - Exibir Estoque\n\n 0 - Sair\n\n\n Insira a opcao desejada: ");
		return input.nextInt();
	}
	
	public static void adicionarItem (){
		
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
		
		if(validarDados(item)){
			ItemDAO salvarItem = new ItemDAO();
			
			//salvarItem.salvar(item);
			System.out.println(""+salvarItem.salvar(item));
			System.out.println("\n\n\tCadastro concluido com sucesso\n");
		}else{
			System.out.println("\n\n\tErro no cadastro do item\n");
		}
		
	}

	public static void fazerVenda(){
		
		Scanner input = new Scanner(System.in);
		Venda venda = new Venda();
		
		System.out.printf("\n\tVENDA\nInsira o nome do item que deseja vender: ");
		venda.setNome(input.nextLine());
		System.out.printf("Insira a quantidade que deseja vender: ");
		venda.setQuantidade(input.nextInt());
		if(validarVenda(venda)){
			VendaDAO vendaDAO = new VendaDAO();
			
			vendaDAO.fazerVenda(venda);
			ItemDAO.update(venda);
			System.out.printf("\n\tVenda efetuada com sucesso!\n");
		}else{
			System.out.println("\n\tN�o foi possivel efetuar a venda!\n");
		}
		
		
	}
	
	public static void exibirEstoque(){
		
		
	}
	
	public static boolean validarDados(Item item){
		if(item.verificarItemNome()){
			if(item.verificarItemQuantidade()){
				if(item.verificarItemPrecoCompra()){
					if(item.verificarItemPrecoVenda()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean validarVenda (Venda venda){
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
