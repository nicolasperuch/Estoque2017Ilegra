package domain;

import model.dao.VendaDAO;

public class Venda {

	private String nome;
	private int quantidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Venda [nome=" + nome + ", quantidade=" + quantidade + "]";
	}
	public void imprimirCabecario() {
		System.out.println("\n\t\t\t\t\tVENDAS\n\nNOME                     QUANTIDADE               GASTO TOTAL              VALOR BRUTO OBTIDO       LUCRO");
	}
	public boolean listar(){
		VendaDAO listaDAO = new VendaDAO();
		imprimirCabecario();
		for(Item item : listaDAO.getList()){
			System.out.println(item.configurarImpressaoVenda());
		}
		
		//imprimirTotais();
		return true;
	}
	
	/*private void imprimirTotais() {
		
		
	}
	*/
	
}
