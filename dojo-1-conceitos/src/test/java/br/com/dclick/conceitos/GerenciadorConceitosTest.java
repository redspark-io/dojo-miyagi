package br.com.dclick.conceitos;

import static br.com.dclick.dojo.conceitos.Operador.*;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dclick.dojo.conceitos.GerenciadorConceitos;
import br.com.dclick.dojo.conceitos.Nota;
import br.com.dclick.dojo.conceitos.Operador;
import br.com.dclick.dojo.conceitos.impl.GerenciadorConceitosImpl;

public class GerenciadorConceitosTest {

	@Test
	public void testCadastrarIntervaloMaiorQueTres() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
	}

	@Test
	public void testCadastrarIntervaloMaiorQueTresDuasVezes() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
		Assert.assertFalse("Esperado não cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
	}

	@Test
	public void testCadastrarIntervaloMaiorQueTresMaiorQueDois() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
		Assert.assertFalse("Esperado não cadastrar maior que dois", gerenciador
				.adicionaConceito(MAIOR, 2, null, null));
	}

	@Test
	public void testCadastrarIntervaloMaiorQueTresMenorQueTres() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
		Assert.assertTrue("Esperado cadastrar menor que tres", gerenciador
				.adicionaConceito(MENOR, 3, null, null));
	}

	@Test
	public void testCadastrarIntervaloMaiorQueTresIntervaloFechado() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar maior que tres", gerenciador
				.adicionaConceito(MAIOR, 3, null, null));
		Assert.assertTrue("Esperado cadastrar intervalo fechado", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 0, MENOR, 3.0));
	}
	
	@Test
	public void testCadastrarFechado2Vezes() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("Esperado cadastrar intervalo fechado", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 0, MENOR, 3.0));
		Assert.assertFalse("Esperado nao cadastrar intervalo fechado", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 0, MENOR, 3.0));
	}
	
	@Test
	public void testCadastrar3SemColisoes() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("< 3 ", gerenciador
				.adicionaConceito(MENOR, 3, null, null));
		Assert.assertTrue(">= 3 <7 ", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7.0));
		Assert.assertTrue(">=7", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 7, null, null));
		
	}
	
	@Test
	public void testSobreposicaoDeIntervalosMenorMaior() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue(">= 2 <= 5 ", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 2, MENOR_IGUAL, 5.0));
		
		Assert.assertFalse(">= 1 <= 7 ", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 1, MENOR_IGUAL, 7.0));
	}
	
	@Test
	public void testSobreposicaoDeIntervalosMaiorMenor() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue(">= 1 <= 7 ", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 1, MENOR_IGUAL, 7.0));
		
		Assert.assertFalse(">= 2 <= 5 ", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 2, MENOR_IGUAL, 5.0));
	}
	
	@Test
	public void testAtribuirConceitos() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		 gerenciador
				.adicionaConceito(MENOR, 3, null, null);
		gerenciador
				.adicionaConceito(MAIOR_IGUAL, 3, MENOR, 7.0);
		 gerenciador
				.adicionaConceito(MAIOR_IGUAL, 7, null, null);
		 Assert.assertEquals("Esperado 5 igual Regular",Nota.REGULAR, gerenciador.atribuiConceito(5.0));
		 Assert.assertEquals("Esperado 2 igual Ruim",Nota.RUIM, gerenciador.atribuiConceito(2.0));
		 Assert.assertEquals("Esperado 8 igual Bom",Nota.BOM, gerenciador.atribuiConceito(8.0));
		
	}
	
	@Test
	public void testaDoisIntervalosComMesmoConceito() {
		GerenciadorConceitos gerenciador = new GerenciadorConceitosImpl();
		Assert.assertTrue("< 3 > 9 ", gerenciador
				.adicionaConceito(MENOR, 3, MAIOR, 9.0));
		
		Assert.assertFalse(">= 2", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 2, null, null));
		
		Assert.assertTrue(">= 3, <= 7", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 3, MENOR_IGUAL, 7.0));
		
		Assert.assertFalse(">= 9.5", gerenciador
				.adicionaConceito(MAIOR_IGUAL, 9.5, null,null));
	}
	
	
	
	
	
}
