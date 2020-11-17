package fornecedor;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Classe que representa o Produto.
 * 
 * @author Juan Silva - 119210821
 *
 */

public class Produto implements Comparable<Produto> {
	private String nome;
	private String descricao;
	private double preco;

	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	/**
	 * Retorno a String que representa o nome do Produto.
	 * 
	 * @return nome Nome do produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorno o Double que representa o preco do produto.
	 * 
	 * @return preco Preco do produto
	 */

	public double getPreco() {
		return preco;
	}

	/**
	 * Retorno a String que representa o descricao do produto.
	 * 
	 * @return descricao Descricao do produto
	 */

	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método responsável por alterar o preco do produto.
	 * 
	 * @param preco Preco do produto.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Método responsável pela comparação de produtos.
	 * 
	 * @return retorna um inteiro para a comparação
	 */
	public int compareTo(Produto produto) {
		return this.nome.compareTo(produto.getNome());
	}

	/**
	 * Método que representa o produto no formato: NOME - DESCRICAO - PRECO.
	 * 
	 * @return Uma string que é a representação do produto
	 */
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
		nf.setMinimumFractionDigits(2);
		return this.nome + " - " + this.descricao + " - R$" + nf.format(this.preco);
	}

	/**
	 * Método que calcula o número hash do Produto.
	 * 
	 * @return Um valor inteiro que representa o número hash do objeto Produto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se a nome e
	 * descricao são iguais.
	 * 
	 * @return Um valor booleano que representa se são iguais ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
