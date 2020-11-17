package cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o Cliente
 * 
 * @author Juan Silva - 119210821
 *
 */
public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	private List<String> contasFornecedores;

	/**
	 * Construtor responsável por construir um Cliente a partir de seu
	 * cpf,nome,email e localizacao.
	 * 
	 * @param cpf         CPF do cliente.
	 * @param nome        Nome do cliente.
	 * @param email       Email do cliente.
	 * @param localizacao Localizacao do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.contasFornecedores = new ArrayList<String>();
	}

	/**
	 * Método responsável adiciona uma conta de um fornecedor na lista de
	 * fornecedores.
	 * 
	 * @param fornecedor Fornecedor a ser adicionado.
	 */
	public void adicionaContaFornecedor(String fornecedor) {
		if (!contasFornecedores.contains(fornecedor)) {
			contasFornecedores.add(fornecedor);
		}

	}

	/**
	 * Método responsável por retornar um CPF.
	 * 
	 * @return retorna um cpf na forma de String
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método responsável por retornar um Nome.
	 * 
	 * @return retorna um nome na forma de String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método responsável por retornar um lista de Strings de Contas do
	 * Fornecedores.
	 * 
	 * @return retorna um lista de String com as contas dos fornecedores.
	 */
	public List<String> getContasFornecedores() {
		return this.contasFornecedores;
	}

	/**
	 * Método responsável por alterar o nome do cliente.
	 * 
	 * @param nome Nome do Cliente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método responsável por alterar o email do cliente.
	 * 
	 * @param email Email do Cliente.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método responsável por alterar a localizacao do cliente.
	 * 
	 * @param localizacao Localização do Cliente.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Método responsável por formatar o nome do cliente.
	 * 
	 * @return Uma String com o nome do cliente
	 */
	public String formataNomeCliente() {
		return "Cliente: " + this.nome;
	}

	/**
	 * ToString responsável pelo retorno na forma de String do cliente.
	 * 
	 * @return Uma String do cliente.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * Método responsável pela comparação de clientes.
	 * 
	 * @return retorna um inteiro para a comparação
	 */
	public int compareTo(Cliente cliente) {
		return this.nome.compareTo(cliente.getNome());
	}

	/**
	 * Método que calcula o número hash do Cliente.
	 * 
	 * @return Um valor inteiro que representa o número hash do objeto Cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se o CPF é igual.
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
