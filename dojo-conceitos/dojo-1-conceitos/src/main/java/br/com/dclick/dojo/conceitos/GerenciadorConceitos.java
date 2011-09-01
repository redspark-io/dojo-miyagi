package br.com.dclick.dojo.conceitos;

/**
 * Interface para gerenciar os conceitos que serão atribuídos aos alunos a
 * partir de suas notas quantitativas.
 * 
 * @author DClick-Dojo
 */
public interface GerenciadorConceitos {

	/**
	 * Este método será chamado 3 vezes em sequência para que sejam adicionados
	 * respectivamente os conceitos RUIM, REGULAR e BOM nesta ordem.<br>
	 * Caso o conceito tenha sido adicionado corretamente, então o método deve
	 * devolver <code>true</code>.<br>
	 * Caso o intervalo que tenha sido passado seja inválido, então o método
	 * deve retornar <code>false</code>, e não deve ser adicionado nenhum
	 * coneito. Após um intervalo inválido, o processo de adição de conceitos
	 * pode ser retomado.<br>
	 * Uma vez que os 3 conceitos tenham sido adicionados corretamente, o método
	 * sempre devolverá <code>false</code> para chamadas adicionais do mesmo,
	 * independente do intervalo passado.<br>
	 * Um intervalo pode ser definido por um ou dois operadores seguidos de seus
	 * respectivos números. Por exemplo alguns possíveis intervalos:<br>
	 * - MAIOR_IGUAL 3.0 <br>
	 * - MAIOR 4.0 <br>
	 * - MAIOR_IGUAL 3.0 ; MENOR_IGUAL 5.0 <br>
	 * Os números são sempre {@link Double} no formato 'n.m', onde n é um
	 * inteiro entre 0 e 10, e m outro inteiro entre 0 e 9.<br>
	 * Exemplo com todos possíveis números: 0.0, 0.1, 0.2, ... , 4.3, 4.4, 4.5,
	 * ... , 9.9, 10.0<br>
	 * 
	 * @param operador1
	 *            o primeiro operador do intervalo
	 * @param valor1
	 *            o valor para o primeiro operador do intervalo
	 * @param operador2
	 *            o segundo operador do intervalo, podendo ser <code>null</code>
	 * @param valor2
	 *            o valor para o segundo operador do intervalo, podendo ser
	 *            <code>null</code> caso o segundo operador seja
	 *            <code>null</code>
	 * @return <code>true</code> caso o intervalor tenha sido adicionado
	 *         corretamente, <code>false</code> caso contrário
	 * 
	 */
	boolean adicionaConceito(Operador operador1, double valor1, Operador operador2,
			Double valor2);

	/**
	 * Uma vez que os conceitos foram cadastrados corretamente, esse método pode
	 * ser chamado.<br>
	 * O método deve retornar o conceito respectivo ao valor que foi passado
	 * como parâmetro, baseado no cadastro que foi realizado posteriormente.
	 * 
	 * @param valor
	 *            o valor que o conceito deve ser atribuído
	 * @return o conceito referente ao valor
	 */
	String atribuiConceito(double valor);

}
