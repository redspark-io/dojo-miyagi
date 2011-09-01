package br.com.dclick.dojo.conceitos.impl;

import static br.com.dclick.dojo.conceitos.Operador.MAIOR;
import static br.com.dclick.dojo.conceitos.Operador.MAIOR_IGUAL;
import static br.com.dclick.dojo.conceitos.Operador.MENOR;
import static br.com.dclick.dojo.conceitos.Operador.MENOR_IGUAL;

import java.util.LinkedList;

import br.com.dclick.dojo.conceitos.GerenciadorConceitos;
import br.com.dclick.dojo.conceitos.Nota;
import br.com.dclick.dojo.conceitos.Operador;
import br.com.dclick.dojo.conceitos.Range;

public class GerenciadorConceitosImpl implements GerenciadorConceitos {

	private LinkedList<Range> conceitos;

	public GerenciadorConceitosImpl() {

		conceitos = new LinkedList<Range>();
	}

	@Override
	public boolean adicionaConceito(Operador operador1, double valor1,
			Operador operador2, Double valor2) {

		Range range = null;

		if (operadorUnico(operador2, valor2)) {

			if (operador1 == MENOR) {
				range = new Range(0, valor1 - 0.1, getNota());
			}

			else if (operador1 == MAIOR) {
				range = new Range(valor1 + 0.1, 10, getNota());
			}

			else if (operador1 == MAIOR_IGUAL) {
				range = new Range(valor1, 10, getNota());
			}

			else if (operador1 == MENOR_IGUAL) {
				range = new Range(0, valor1, getNota());
			}

		} else {

		}

		conceitos.add(range);
		return false;
	}

	private boolean operadorUnico(Operador operador2, Double valor2) {
		return operador2 == null && valor2 == null;
	}

	private String getNota() {
		int size = conceitos.size();
		switch (size) {
		case 0:
			return Nota.RUIM;
		case 1:
			return Nota.REGULAR;
		case 2:
			return Nota.BOM;
		default:
			return null;
		}
	}

	@Override
	public String atribuiConceito(double valor) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estaDentro(Range range) {
		boolean estaDentro = false;
		double inicio = range.getX();
		double fim = range.getY();
		
		for (Range r : conceitos) {
			if(r.getX() >= inicio && r.getX() <= fim)
				return true;
			if(r.getY() >= inicio && r.getY() <= fim)
				return true;
		}
		return estaDentro;
	}

}
