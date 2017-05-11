package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	
	@Before
	public void inicializar(){
	item = new Item();
	}
	
	@Test
	public void verificarItemNome(){
		item.setNome("Cadeira");
		Assert.assertTrue(item.verificarItemNome());
	}	
	@Test
	public void verificarItemQuantidade(){
		item.setQuantidade(1);
		Assert.assertTrue(item.verificarItemQuantidade());
	}
	@Test
	public void verificarItemPrecoCompra(){
		item.setPrecoCompra(10);
		Assert.assertTrue(item.verificarItemPrecoCompra());
	}
	@Test
	public void verificarItemPrecoVenda(){
		item.setPrecoCompra(15.5);
		item.setPrecoVenda(15.6);
		Assert.assertTrue(item.verificarItemPrecoVenda());

	}
}