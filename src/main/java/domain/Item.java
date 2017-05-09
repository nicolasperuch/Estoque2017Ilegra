package domain;

import org.apache.commons.lang3.StringUtils;

public class Item {

	private String nome;
	private int quantidade;
	private double precoCompra;
	private double precoVenda;
	
	public Item(){}

	
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
	
	public String configurarImpressao() {
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
		
		return  nome + quantidade + precoCompra	+ precoVenda;
	}

	public boolean verificarItemNome(){
		if(StringUtils.length(getNome()) > 3 ){
			if(StringUtils.containsAny(getNome(), '0','1','2','3','4','5','6','7','8','9' )){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	public boolean verificarItemQuantidade(){
		if(getQuantidade() > 0 ){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean verificarItemPrecoCompra(){
		if(getPrecoCompra() > 0 ){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean verificarItemPrecoVenda(){
		if(getPrecoCompra() < getPrecoVenda()){
			return true;
		}else{
			return false;
		}
	}


	

}
