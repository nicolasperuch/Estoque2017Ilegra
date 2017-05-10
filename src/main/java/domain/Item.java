package domain;

import org.apache.commons.lang3.StringUtils;

public class Item {

	private String nome;
	private int quantidade;
	private double precoCompra;
	private double precoVenda;
	
	public Item(){
		this.nome = "";
	}
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
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	@Override
	public String toString() {
		return "Item [nome=" + nome + ", quantidade=" + quantidade + ", precoCompra=" + precoCompra + ", precoVenda="
				+ precoVenda + "]";
	}
	public String configurarImpressaoEstoque() {
		int tamanho;
		int TABULAMENTO = 25;
		String quantidade;
		String precoCompra;
		String precoVenda;
		String nome;
		
		
		nome = this.nome;
		tamanho = TABULAMENTO - this.nome.length();
		for(int i=0; i< tamanho; i++)
			nome += " ";
		
		quantidade = String.valueOf(this.quantidade);
		tamanho = TABULAMENTO - quantidade.length();
		for(int i=0; i< tamanho; i++)
			quantidade += " ";
		
		precoCompra = String.valueOf(this.precoCompra);
		tamanho = TABULAMENTO - precoCompra.length();
		for(int i=0; i< tamanho; i++)
			precoCompra += " ";
		
		precoVenda = String.valueOf(this.precoVenda);
		tamanho = TABULAMENTO - precoVenda.length();
		for(int i=0; i< tamanho; i++)
			precoVenda += " ";
		
		return  nome + quantidade + precoVenda + precoCompra;
	}
	
	public String configurarImpressaoVenda() {
		int tamanho;
		int TABULAMENTO = 25;
		double lucro;
		String nome;
		String quantidade;
		String gastoTotal;
		String valorBrutoObtido;
		String lucroPorItem;
		
		lucro = this.precoVenda * this.quantidade - this.precoCompra * this.quantidade; 
		
		nome = this.nome;
		tamanho = TABULAMENTO - this.nome.length();
		for(int i=0; i< tamanho; i++)
			nome += " ";
		
		quantidade = String.valueOf(this.quantidade);
		tamanho = TABULAMENTO - quantidade.length();
		for(int i=0; i< tamanho; i++)
			quantidade += " ";
		
		gastoTotal = String.valueOf(this.precoCompra * this.quantidade);
		tamanho = TABULAMENTO - gastoTotal.length();
		for(int i=0; i< tamanho; i++)
			gastoTotal += " ";
		
		valorBrutoObtido = String.valueOf(this.precoVenda * this.quantidade);
		tamanho = TABULAMENTO - valorBrutoObtido.length();
		for(int i=0; i< tamanho; i++)
			valorBrutoObtido += " ";
		
		lucroPorItem = String.valueOf(lucro);
		tamanho = TABULAMENTO - lucroPorItem.length();
		for(int i=0; i< tamanho; i++)
			lucroPorItem += " ";
		
		
		
		return  nome + quantidade + gastoTotal + valorBrutoObtido + lucroPorItem;
	}
	

	public boolean verificarItemNome(){
		if(StringUtils.length(getNome()) > 3 ){
			if(!StringUtils.containsAny(getNome(), '0','1','2','3','4','5','6','7','8','9' )){
				return true;
			}else{
				System.out.println("\nERRO: O nome nao pode conter numeros.");
				return false;
			}
		}else{
			System.out.println("\nERRO: O nome deve conter mais de 3 letras.");
			return false;
		}
	}

	public boolean verificarItemQuantidade(){
		if(getQuantidade() > 0 )
			return true;
			
		System.out.println("\nERRO: A quantidade deve ser maior que 0.");	
		return false;
	}
	
	public boolean verificarItemPrecoCompra(){
		if(getPrecoCompra() > 0 )
			return true;
	
		System.out.println("\nERRO: O valor de compra deve ser maior que 0.");
		return false;
	}
	
	public boolean verificarItemPrecoVenda(){
		if(getPrecoCompra() < getPrecoVenda())
			return true;

		System.out.println("\nERRO: O valor de venda deve ser superior ao valor de compra");
		return false;
	}
	public void imprimirCabecario() {
		System.out.println("\n\t\t\t\t\tESTOQUE\n\nNOME                     QUANTIDADE               PRECO VENDA              PRECO COMPRA   ");
	}

}