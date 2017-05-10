package domain;

import org.junit.Test;

import junit.framework.Assert;

public class DadosVendaTest {

	
	@Test
	public void validarVenda(){
		DadosVenda dadosVenda = new DadosVenda();
		Venda venda = new Venda();
		venda.setNome("Notebook");
		venda.setQuantidade(1);
		Assert.assertTrue(dadosVenda.validarVenda(venda));
	}
}
