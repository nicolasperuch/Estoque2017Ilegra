package domain;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
	
	@Test
	public void verificarItemNome(){
		Item item = new Item();
		item.setNome("Cadeira");
		Assert.assertTrue(item.verificarItemNome());
	}	
	@Test
	public void verificarItemQuantidade(){
		Item item = new Item();
		item.setQuantidade(5);
		Assert.assertTrue(item.verificarItemQuantidade());
	}
	@Test
	public void verificarItemPrecoCompra(){
		Item item = new Item();
		item.setPrecoCompra(15.5);
		Assert.assertTrue(item.verificarItemPrecoCompra());
	}
	@Test
	public void verificarItemPrecoVenda(){
		Item item = new Item();
		item.setPrecoCompra(15.5);
		item.setPrecoVenda(30);
		Assert.assertTrue(item.verificarItemPrecoVenda());

	}
}