import java.util.Scanner;

import domain.DadosItem;
import domain.DadosVenda;
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
		DadosItem dados = new DadosItem();
		
		item = dados.entradaDeDadosItem();
		if(dados.validarDados(item)){
			ItemDAO salvarItem = new ItemDAO();
			
			if(salvarItem.salvar(item))
				System.out.println("\n\n\tCadastro concluido com sucesso\n");
		}
	}

	public static void fazerVenda(){
	
		Venda venda = new Venda();
		DadosVenda dados = new DadosVenda();
		
		int fkItem;
		
		venda = dados.entradaDeDadosVenda();
		if(dados.validarVenda(venda)){
			
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
	


	


	
	public static void exibirRelatorioVendas(){
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.listar();
		
	}
}
