package domain;

public class Venda {

	private String nome;
	private int quantidade;
	private double precoVenda;
	
	
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
	public double getPrecoVenda(){
		return this.precoVenda;
	}
	public void setPrecoVenda(double precoVenda){
		this.precoVenda = precoVenda;
	}
	@Override
	public String toString() {
		return "Venda [nome=" + nome + ", quantidade=" + quantidade + ", precoVenda=" + precoVenda + "]";
	}
	
	
	
}
