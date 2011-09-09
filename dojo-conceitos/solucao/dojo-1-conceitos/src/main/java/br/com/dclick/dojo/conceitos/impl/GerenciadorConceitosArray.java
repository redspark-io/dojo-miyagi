package br.com.dclick.dojo.conceitos.impl;

import br.com.dclick.dojo.conceitos.GerenciadorConceitos;
import br.com.dclick.dojo.conceitos.Operador;

import static br.com.dclick.dojo.conceitos.Operador.*;

/**
 * @author gustavo.moreira
 * 
 */
public class GerenciadorConceitosArray implements GerenciadorConceitos {

	private static final int FATOR_AJUSTE = 10;

	private String[] conceitos = { "RUIM", "REGULAR", "BOM" };

	private String[] atribuidos = new String[101];

	private int conceitoAtual = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean adicionaConceito(Operador operador1, double valor1,
			Operador operador2, Double valor2) {

		Comparador comp1 = this.criaComparador(operador1, (int) (valor1 * FATOR_AJUSTE));
		Comparador comp2 = null;
		if (operador2 != null) {
			comp2 = this.criaComparador(operador2, (int) (valor2 * FATOR_AJUSTE));
		}

		Intervalo inter = new Intervalo(comp1, comp2);

		for (int i = 0; i <= 100; i++) {
			if (inter.eValido(i) && this.atribuidos[i] != null) {
				return false;
			}
		}
		for (int i = 0; i <= 100; i++) {
			if (inter.eValido(i)) {
				this.atribuidos[i] = this.conceitos[this.conceitoAtual];
			}
		}
		this.conceitoAtual++;
		return true;
	}

	/**
	 * Cria um comparador baseado no operador
	 */
	private Comparador criaComparador(Operador op, int valor) {
		if (op == MENOR) {
			return new ComparadorMenor(valor);
		} else if (op == MENOR_IGUAL) {
			return new ComparadorMenorIgual(valor);
		} else if (op == MAIOR) {
			return new ComparadorMaior(valor);
		} else {
			return new ComparadorMaiorIgual(valor);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String atribuiConceito(double valor) {
		return this.atribuidos[(int) (valor * FATOR_AJUSTE)];
	}

	/**
	 * Define um intervalo para dois operadores
	 */
	private static final class Intervalo {

		private Comparador comparador1;
		private Comparador comparador2;

		public Intervalo(Comparador comparador1, Comparador comparador2) {
			super();
			this.comparador1 = comparador1;
			this.comparador2 = comparador2;
		}

		/**
		 * @return true caso o valor pertença ao intervalo
		 */
		public boolean eValido(int valor) {
			if (this.comparador2 == null) {
				return this.comparador1.eValido(valor);
			}
			if (this.comparador1.eValido(this.comparador2.getValor())) {
				return this.comparador1.eValido(valor) && this.comparador2.eValido(valor);
			}
			return this.comparador1.eValido(valor) || this.comparador2.eValido(valor);
		}
	}

	private interface Comparador {
		boolean eValido(int outroValor);

		int getValor();
	}

	private static final class ComparadorMenor implements Comparador {

		private int valor;

		public ComparadorMenor(int valor) {
			this.valor = valor;
		}

		@Override
		public boolean eValido(int outroValor) {
			return outroValor < this.valor;
		}

		@Override
		public int getValor() {
			return this.valor;
		}
	}

	private static final class ComparadorMenorIgual implements Comparador {

		private int valor;

		public ComparadorMenorIgual(int valor) {
			this.valor = valor;
		}

		@Override
		public boolean eValido(int outroValor) {
			return outroValor <= this.valor;
		}

		@Override
		public int getValor() {
			return this.valor;
		}
	}

	private static final class ComparadorMaior implements Comparador {

		private int valor;

		public ComparadorMaior(int valor) {
			this.valor = valor;
		}

		@Override
		public boolean eValido(int outroValor) {
			return outroValor > this.valor;
		}

		@Override
		public int getValor() {
			return this.valor;
		}
	}

	private static final class ComparadorMaiorIgual implements Comparador {

		private int valor;

		public ComparadorMaiorIgual(int valor) {
			this.valor = valor;
		}

		@Override
		public boolean eValido(int outroValor) {
			return outroValor >= this.valor;
		}

		@Override
		public int getValor() {
			return this.valor;
		}
	}

}
