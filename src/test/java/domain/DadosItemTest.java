package domain;

import org.junit.Assert;
import org.junit.Test;

public class DadosItemTest {

	
	
	@Test
	public void validarDados(){
		Item item = new Item();
		DadosItem dadosItem = new DadosItem();
		
		item.setNome("Cadeira");
		item.setQuantidade(10);
		item.setPrecoCompra(5);
		item.setPrecoVenda(10);
		
		Assert.assertTrue(dadosItem.validarDados(item));
	}
	
}
