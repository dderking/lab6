package fornecedor;

import java.util.HashMap;
import java.util.Map;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;
	private Map<String, Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();

	}

	public void cadastraProduto(String nome, String descricao, double preco) {
		if (!existeProduto(nome, descricao)) {
			this.produtos.put(nome + descricao, new Produto(nome, descricao, preco));
		}
	}

	public boolean existeProduto(String nome, String descricao) {
		return this.produtos.containsKey(nome + descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String exibeProduto(String nome, String descricao) {
		if (existeProduto(nome, descricao)) {
			return this.produtos.get(nome + descricao).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");

	}

	public void editaProduto(String nome, String descricao, double novoPreco) {
		if (existeProduto(nome, descricao)) {
			this.produtos.get(nome + descricao).setPreco(novoPreco);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");

		}
	}

	public void removeProduto(String nome, String descricao) {
		if (existeProduto(nome, descricao)) {
			this.produtos.remove(nome + descricao);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");

		}
	}

	public String toStringExibeFornecedor() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

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
