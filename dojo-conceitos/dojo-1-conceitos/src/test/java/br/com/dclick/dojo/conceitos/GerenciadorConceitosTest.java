package br.com.dclick.dojo.conceitos;

import static br.com.dclick.dojo.conceitos.Operador.MAIOR;
import static br.com.dclick.dojo.conceitos.Operador.MAIOR_IGUAL;
import static br.com.dclick.dojo.conceitos.Operador.MENOR;
import static br.com.dclick.dojo.conceitos.Operador.MENOR_IGUAL;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gustavo.moreira
 * 
 */
public class GerenciadorConceitosTest {

	private GerenciadorConceitos gc;

	@Before
	public void inicializaGerenciador() {

		this.gc = null; // Inicializa o gerenciador

	}

	/**
	 * x < 3 ; 3 <= x < 7 ; x >= 7
	 */
	@Test
	public void testGerenciador2_36_7() {

		Assert.assertTrue(this.gc.adicionaConceito(MENOR, 3, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 3, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 6, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 10, null, null));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 1, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 0, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 6, MENOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.5));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(4.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(4.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(4.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.5));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(10.0));
	}

	/**
	 * x <= 8 ; 8 < x <= 9 ; 9 < x <= 10
	 */
	@Test
	public void testGerenciador8_9_10() {

		Assert.assertTrue(this.gc.adicionaConceito(MENOR_IGUAL, 8, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 3, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 6, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 10, MAIOR_IGUAL, 1D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR, 8, MENOR_IGUAL, 9D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 9, MENOR_IGUAL, 9D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 1, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 0, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 6, MENOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR, 9, MENOR_IGUAL, 10.0));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.2));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.3));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.4));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.5));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.6));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.7));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.8));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.2));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.3));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.4));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(10.0));
	}

	/**
	 * x < 8.1 ; 8.1 <= x < 9.1 ; 9.1 <= x <= 10
	 */
	@Test
	public void testGerenciador81_91_10() {

		Assert.assertTrue(this.gc.adicionaConceito(MENOR, 8.1, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 3, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 6, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 10, MAIOR_IGUAL, 1D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 8.1, MENOR, 9.1D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 9, MENOR_IGUAL, 9D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 1, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 0, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 6, MENOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 9.1, MENOR_IGUAL, 10.0));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.2));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.3));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.4));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.5));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.6));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.7));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.8));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.2));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.3));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.4));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(10.0));
	}

	/**
	 * x < 3 x > 8 ; 5 < x <= 8 ; 3 <= x <= 5
	 */
	@Test
	public void testGerenciador38_58_35() {

		Assert.assertTrue(this.gc.adicionaConceito(MENOR, 3, MAIOR, 8.0));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 3, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 6, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 5, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 4, MAIOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 4, MENOR, 9D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR, 5.0, MENOR_IGUAL, 8D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 9, MENOR_IGUAL, 9D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 1, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 0, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 6, MENOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR_IGUAL, 5.0));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.2));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.5));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.5));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(10.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.6));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.5));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.6));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(5.0));
	}

	/**
	 * x >= 8 ; 3 <= x < 8; x < 3
	 */
	@Test
	public void testGerenciador8_38_3() {

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 8, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 10, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 5, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 4, MAIOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR, 4, MENOR, 9D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 3.0, MENOR, 8D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 9, MENOR_IGUAL, 9D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 1, MENOR, 7D));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 0, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 6, MENOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MENOR, 3, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.2));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.5));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.5));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(10.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(7.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(6.0));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.6));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(5.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(4.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(4.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.1));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(2.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(2.6));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(2.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(1.6));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(0.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(0.6));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(0.2));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(0.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(0.0));
	}

	/**
	 * x < 3 ; 3 <= x <= 3; x > 3
	 */
	@Test
	public void testGerenciador3_3_3() {

		Assert.assertTrue(this.gc.adicionaConceito(MENOR, 3, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 9, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 10, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MENOR, 4, MAIOR, 7D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR_IGUAL, 3.0, MENOR_IGUAL, 3D));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 3.0, MENOR_IGUAL, 3D));

		Assert.assertTrue(this.gc.adicionaConceito(MAIOR, 3, null, null));

		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		Assert.assertFalse(this.gc.adicionaConceito(MAIOR_IGUAL, 7, null, null));

		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.6));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(0.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.6));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(1.9));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.0));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.1));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.6));
		Assert.assertEquals("RUIM", this.gc.atribuiConceito(2.9));
		Assert.assertEquals("REGULAR", this.gc.atribuiConceito(3.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.6));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(3.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(4.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(5.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(5.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(5.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(6.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(6.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(6.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(7.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(8.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.0));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.1));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(9.9));
		Assert.assertEquals("BOM", this.gc.atribuiConceito(10.0));
	}

}
