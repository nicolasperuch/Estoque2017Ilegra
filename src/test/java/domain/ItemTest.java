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
	public void verificarItemNomeCorreto(){
		item.setNome("Cadeira");
		Assert.assertTrue(item.verificarItemNome());
	}	
	@Test
	public void verificarItemNomeComNumero(){
		item.setNome("Cad31ra");
		Assert.assertFalse(item.verificarItemNome());
	}
	@Test
	public void verificarItemNomeMenosDe4Letras(){
		item.setNome("oi");
		Assert.assertFalse(item.verificarItemNome());
	}
	@Test
	public void verificarItemQuantidadeMaiorQueZero(){
		item.setQuantidade(1);
		Assert.assertTrue(item.verificarItemQuantidade());
	}
	@Test
	public void verificarItemQuantidadeMenorQueZero(){
		item.setQuantidade(-1);
		Assert.assertFalse(item.verificarItemQuantidade());
	}
	@Test
	public void verificarItemPrecoCompraPositivo(){
		item.setPrecoCompra(10);
		Assert.assertTrue(item.verificarItemPrecoCompra());
	}
	@Test
	public void verificarItemPrecoCompraNegativo(){
		item.setPrecoCompra(-1);
		Assert.assertFalse(item.verificarItemPrecoCompra());
	}
	@Test
	public void verificarItemPrecoVendaMaiorQueCompra(){
		item.setPrecoCompra(1);
		item.setPrecoVenda(10);
		Assert.assertTrue(item.verificarItemPrecoVenda());
	}
	@Test
	public void veridicarItemPrecoVendaMenorQueCompra(){
		item.setPrecoCompra(10);
		item.setPrecoVenda(1);
		Assert.assertFalse(item.verificarItemPrecoVenda());
	}
}