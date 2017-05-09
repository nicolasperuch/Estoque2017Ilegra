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
				case 4:
					exibirRelatorioVendas();
				break;
				case 0:
				System.out.println("\n Obrigado por utilizar nosso sistema!\n\n");
				break;
				default:
				System.out.println("\n Opcao Invalida");
				break;
			}
			
		}while(escolhaMenu > 0);
		
		
	}
	
	
	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.printf("\n\tSISTEMA DE ESTOQUE\n\n 1 - Inserir item ao estoque\n 2 - Fazer Venda\n 3 - Exibir Estoque\n 4 - Exibir Relatorio de Vendas\n\n 0 - Sair\n\n\n Insira a opcao desejada: ");
		return input.nextInt();
	}
	
	public static void adicionarItem (){
		
		Item item = new Item();
		
		item = entradaDeDadosItem();
		if(validarDados(item)){
			ItemDAO salvarItem = new ItemDAO();
			salvarItem.salvar(item);
			System.out.println("\n\n\tCadastro concluido com sucesso\n");
		}else{
			System.out.println("\n\n\tErro no cadastro do item\n");
		}
		
	}

	public static void fazerVenda(){
	
		Venda venda = new Venda();
		int fkItem;
		
		venda = entradaDeDadosVenda();
		if(validarVenda(venda)){
			VendaDAO vendaDAO = new VendaDAO();
			
			fkItem = ItemDAO.buscarFkItem(venda);
			vendaDAO.fazerVenda(venda, fkItem);
			ItemDAO.update(venda, fkItem);
			System.out.printf("\n\tVenda efetuada com sucesso!\n");
		}else{
			System.out.println("\n\tNão foi possivel efetuar a venda!\n");
		}
		
		
	}
	
	public static void exibirEstoque(){
		ItemDAO itemDAO = new ItemDAO();
		
		
		itemDAO.listar();
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
	

	
	public static Item entradaDeDadosItem(){
		
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
	
	public static Venda entradaDeDadosVenda(){
		
		Scanner input = new Scanner(System.in);
		Venda venda = new Venda();
		
		System.out.printf("\n\tVENDA\nInsira o nome do item que deseja vender: ");
		venda.setNome(input.nextLine());
		System.out.printf("Insira a quantidade que deseja vender: ");
		venda.setQuantidade(input.nextInt());
		
		return venda;
	}
	
	public static void exibirRelatorioVendas(){
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.listar();
		
	}
}
