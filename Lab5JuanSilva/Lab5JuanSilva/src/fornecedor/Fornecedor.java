package fornecedor;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Classe que representa o Fornecedor.
 * 
 * @author Juan Silva - 119210821
 *
 */

public class Fornecedor implements Comparable<Fornecedor> {

	private String nome;
	private String email;
	private String telefone;
	private Map<String, Produto> produtos;
	private Map<String, Conta> contas;

	/**
	 * Construtor responsável por construir um fornecedor a partir de seu nome, seu
	 * email e seu telefone.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
		this.contas = new HashMap<>();

	}

	/**
	 * Método responsável por cadastrar um produto a partir do nome, descricao e
	 * preco.
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param preco     Preco do produto
	 */
	public void cadastraProduto(String nome, String descricao, double preco) {
		if (!existeProduto(nome, descricao)) {
			this.produtos.put(nome + descricao, new Produto(nome, descricao, preco));
		}
	}

	/**
	 * * Método responsável por cadastrar uma compra a partir do cpf,
	 * cliente,produto, descricao e data.
	 * 
	 * @param cpf         CPF do cliente
	 * @param nomeCliente Nome do cliente
	 * @param nomeProduto Nome do Produto
	 * @param descricao   Descricao do produto
	 * @param data        Data da compra
	 * @throws ParseException Uma execeção a ser lançada
	 */
	public void cadastraCompra(String cpf, String nomeCliente, String nomeProduto, String descricao, String data)
			throws ParseException {
		if (existeProduto(nomeProduto, descricao)) {
			if (contas.containsKey(cpf)) {
				contas.get(cpf).adicionaCompras(nomeProduto, data, descricao,
						produtos.get(nomeProduto + descricao).getPreco());
			} else {
				contas.put(cpf, new Conta(this.nome, nomeCliente));
				contas.get(cpf).adicionaCompras(nomeProduto, data, descricao,
						produtos.get(nomeProduto + descricao).getPreco());
			}
		}
	}

	/**
	 * Método responsável por verificar se existe um produto a partir do nome e
	 * descricao.
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @return retorna um booleano
	 */
	public boolean existeProduto(String nome, String descricao) {
		return this.produtos.containsKey(nome + descricao);
	}

	/**
	 * Retorno a String que representa o nome do aluno.
	 * 
	 * @return nome O nome do aluno
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método responsável por alterar o email do fornecedor.
	 * 
	 * @param email Email do Fornecedor.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método responsável por alterar o telefone do fornecedor.
	 * 
	 * @param telefone Telefone do Fornecedor.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método responsável por exibir UM produto a partir do nome e descricao.
	 * 
	 * @param nome      Nome do Produto
	 * @param descricao Descricao do Produto
	 * @return retorna uma String da exibição de um produto se ele existir, se não
	 *         lança uma exceção
	 */
	public String exibeProduto(String nome, String descricao) {
		if (existeProduto(nome, descricao)) {
			return this.produtos.get(nome + descricao).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");

	}

	/**
	 * Método responsável por exibir TODOS os produtos de um fornecedor.
	 * 
	 * @return retorna String com todos os produtos do fornecedor.
	 */
	public String exibeProdutos() {
		if (this.produtos.isEmpty()) {
			return this.nome + " -";
		}
		List<Produto> todosProdutos = new ArrayList<Produto>();
		todosProdutos.addAll(this.produtos.values());
		Collections.sort(todosProdutos);
		String[] produtosToString = new String[this.produtos.size()];
		for (int i = 0; i < this.produtos.size(); i++) {
			produtosToString[i] = this.nome + " - " + todosProdutos.get(i).toString();
		}
		return String.join(" | ", produtosToString);
	}

	/**
	 * Método responsável por retorna um o debito da conta a parti do cpf.
	 * 
	 * @param cpf CPF do cliente
	 * @return retorna o debito do cliente na forma de String se existir, se não ele
	 *         retorna uma execeção
	 */
	public String getDebitoConta(String cpf) {
		if (contas.containsKey(cpf)) {
			NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
			nf.setMinimumFractionDigits(2);
			return nf.format(contas.get(cpf).getDebito());
		}
		throw new NullPointerException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");

	}

	/**
	 * Método responsável por retorna uma lista de compras
	 * 
	 * @return retorna uma List de compras.
	 */
	public List<Compra> getCompras() {
		List<Compra> compras = new ArrayList<>();
		if (verificaCompras()) {
			for (Conta conta : contas.values()) {
				compras.addAll(conta.getCompras());
			}
		}
		return compras;

	}

	/**
	 * Método responsável por retorna UMA conta de um cliente a partir do CPF.
	 * 
	 * @param cpf CPF do cliente
	 * @return Retorna uma String com a conta do cliente se ele existir, se não
	 *         lança uma exceção.
	 */
	public String exibeContaCliente(String cpf) {
		if (contas.containsKey(cpf)) {
			return contas.get(cpf).toString();

		} else {
			throw new NullPointerException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}

	/**
	 * Método responsável por retorna UMA conta de um cliente a partir do CPF.
	 * 
	 * @param cpf CPF do cliente
	 * @return Retorna uma String com a conta do cliente se ele existir, se não
	 *         lança uma exceção.
	 */
	public String exibeConta(String cpf) {
		if (contas.containsKey(cpf)) {
			return contas.get(cpf).contaFormatada();

		} else {
			throw new NullPointerException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}

	/**
	 * Método responsável por editar um produto a partir do nome,descricao e o novo
	 * preco
	 * 
	 * @param nome      Nome do Produto
	 * @param descricao Descricao do Produto
	 * @param novoPreco Novo Preco do Produto
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		if (existeProduto(nome, descricao)) {
			this.produtos.get(nome + descricao).setPreco(novoPreco);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");

		}
	}

	/**
	 * Método resposável por remover um produto a partir do nome e descricao.
	 * 
	 * @param nome      Nome do Produto
	 * @param descricao Descricao do Produto
	 */
	public void removeProduto(String nome, String descricao) {
		if (existeProduto(nome, descricao)) {
			this.produtos.remove(nome + descricao);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");

		}
	}

	/**
	 * Método responsável para verificar se a compra existe.
	 * 
	 * @return retorna um booleano.
	 */
	public boolean verificaCompras() {
		return !this.contas.isEmpty();
	}

	/**
	 * Método responsável pela comparação de Fornecedores.
	 * 
	 * @return retorna um inteiro para a comparação
	 */
	public int compareTo(Fornecedor fornecedor) {
		return this.nome.compareTo(fornecedor.getNome());
	}

	/**
	 * Método que representa o fornecedor no formato: NOME - EMAIL - TELEFONE.
	 * 
	 * @return Uma string que é a representação do fornecedor
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * Método que calcula o número hash do Fornecedor.
	 * 
	 * @return Um valor inteiro que representa o número hash do objeto Fornecedor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se o nome do
	 * fornecedor é igual.
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
