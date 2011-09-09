package br.com.dclick.dojo.conceitos.impl;

import static br.com.dclick.dojo.conceitos.Operador.MAIOR;
import static br.com.dclick.dojo.conceitos.Operador.MAIOR_IGUAL;
import static br.com.dclick.dojo.conceitos.Operador.MENOR;
import static br.com.dclick.dojo.conceitos.Operador.MENOR_IGUAL;

import java.util.LinkedList;

import br.com.dclick.dojo.conceitos.GerenciadorConceitos;
import br.com.dclick.dojo.conceitos.Nota;
import br.com.dclick.dojo.conceitos.Operador;
import br.com.dclick.dojo.conceitos.Intervalo;

public class GerenciadorConceitosImpl implements GerenciadorConceitos {

	private LinkedList<Intervalo> intervalos;

	private static final String[] conceitos = new String[] { "RUIM", "REGULAR",
			"BOM" };
	private int contadorNotas = 0;

	public GerenciadorConceitosImpl() {

		intervalos = new LinkedList<Intervalo>();
	}

	@Override
	public boolean adicionaConceito(Operador operador1, double valor1,
			Operador operador2, Double valor2) {

		double valor1Aux = valor1;

		valor1Aux = ajustaValor(operador1, valor1Aux);

		Intervalo intervalo = null;

		if (operadorUnico(operador2, valor2)) {
			if (operador1 == MENOR || operador1 == MENOR_IGUAL) {
				intervalo = new Intervalo(0, valor1Aux, getNota());
			} else if (operador1 == MAIOR || operador1 == MAIOR_IGUAL) {
				intervalo = new Intervalo(valor1Aux, 10, getNota());
			}
		} else {

			double valor2Aux = valor2;

			valor2Aux = ajustaValor(operador2, valor2Aux);

			if ((operador1 == MENOR || operador1 == Operador.MENOR_IGUAL)
					&& (operador2 == MAIOR || operador2 == Operador.MAIOR_IGUAL)) {
				Intervalo intervalo2 = new Intervalo(0, valor1Aux, getNota());
				intervalo = new Intervalo(valor2Aux, 10, getNota());

				if (verificaColisao(intervalo2) || verificaColisao(intervalo)) {
					return false;
				} else {
					intervalos.add(intervalo2);
				}

			} else {
				intervalo = new Intervalo(valor1Aux, valor2Aux, getNota());
			}

		}

		if (verificaColisao(intervalo)) {
			return false;
		}

		intervalos.add(intervalo);
		contadorNotas++;
		return true;
	}

	private boolean verificaColisao(Intervalo intervalo) {
		for (Intervalo intervaloExistente : intervalos) {
			if (intervalo.estaDentro(intervaloExistente)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param operador1
	 * @param valor1Aux
	 * @return retornar um valor ajustado.
	 */
	private double ajustaValor(Operador operador1, double valor1Aux) {
		if (operador1 == MAIOR) {
			valor1Aux += 0.1;
		}
		if (operador1 == MENOR) {
			valor1Aux -= 0.1;
		}
		return valor1Aux;
	}

	private boolean operadorUnico(Operador operador2, Double valor2) {
		return operador2 == null && valor2 == null;
	}

	private String getNota() {
		return conceitos[contadorNotas % 3];
	}

	@Override
	public String atribuiConceito(double valor) {
		for (Intervalo intervalo : intervalos) {

			if (valor >= intervalo.getMin() && valor <= intervalo.getMax()) {
				return intervalo.getNota();
			}

		}
		return null;
	}

}
