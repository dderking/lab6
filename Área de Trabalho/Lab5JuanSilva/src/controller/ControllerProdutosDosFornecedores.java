package controller;

import java.util.HashMap;

/*import fornecedor.Fornecedor;*/
import fornecedor.Produto;
import validator.ValidatorCliente;

public class ControllerProdutosDosFornecedores {
	private HashMap<String, Produto> produtos;

	public ControllerProdutosDosFornecedores(HashMap<String, Produto> produtos) {
		this.produtos = new HashMap<>();
	}

	public Produto getProduto(String nome) {
		return produtos.get(nome);
	}

/*	public String cadastraFornecedor(Fornecedor fornecedor, String nome, String descricao, double preco) {
		if (existeProduto(nome) == false) {
			Produto produto = new Produto(fornecedor, nome, descricao, preco);
			ValidatorCliente.verificaStringNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringNull(descricao,
					"Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			ValidatorCliente.verificaStringVazia(descricao,
					"Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			ValidatorCliente.verificaStringNull(preco, "Erro no cadastro de produto: preco invalido.");
			ValidatorCliente.verificaStringVazia(preco,
					"Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
			this.produtos.put(nome, produto);
			return produto.toStringNome();
		} else {
			return "Erro no cadastro de produto: produto ja existe.";
		}
	}*/

	public boolean existeProduto(String nome) {
		return this.produtos.containsKey(nome);
	}

	public HashMap<String, Produto> getProdutos() {
		return produtos;
	}

	public String exibeProduto(String nome) {
		ValidatorCliente.verificaStringNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (existeProduto(nome) == false) {
			return "Erro na exibicao de produto: produto nao existe.";
		}
		return getProdutos().get(nome).toStringExibeProduto();

	}

	public String removeProduto(String nome, String descricao, String fornecedor) {
		ValidatorCliente.verificaStringNull(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringNull(descricao,
				"Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		ValidatorCliente.verificaStringVazia(descricao,
				"Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		ValidatorCliente.verificaStringNull(fornecedor,
				"Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(fornecedor,
				"Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (existeProduto(nome) == false) {
			return "Erro na remocao de produto: produto nao existe.";
		}
		produtos.remove(nome);
		return nome;
	}

}
