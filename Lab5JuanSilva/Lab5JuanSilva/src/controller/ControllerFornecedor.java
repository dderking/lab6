package controller;

import java.util.HashMap;

import fornecedor.Fornecedor;
import validator.ValidatorCliente;

public class ControllerFornecedor {
	private HashMap<String, Fornecedor> fornecedores;

	public ControllerFornecedor(HashMap<String, Fornecedor> fornecedores) {
		this.fornecedores = new HashMap<>();
	}

	public Fornecedor getFornecedor(String nome) {
		return fornecedores.get(nome);
	}

	public String cadastraFornecedor(String nome, String email, String telefone) {
		if (existeFornecedor(nome) == false) {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			ValidatorCliente.verificaStringNull(nome,
					"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringVazia(nome,
					"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringNull(email,
					"Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringVazia(email,
					"Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringNull(telefone,
					"Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
			ValidatorCliente.verificaStringVazia(telefone,
					"Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
			this.fornecedores.put(nome, fornecedor);
			return fornecedor.toStringNome();
		} else {
			return "Erro no cadastro de fornecedor: fornecedor ja existe.";
		}
	}

	public boolean existeFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}

	public HashMap<String, Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public String exibeFornecedor(String nome) {
		ValidatorCliente.verificaStringNull(nome, "Erro na exibicao do fornecedor: fornecedor nao existe.");
		ValidatorCliente.verificaStringVazia(nome, "Erro na exibicao do fornecedor: fornecedor nao existe.");
		if (existeFornecedor(nome) == false) {
			return "Erro na exibicao do fornecedor: fornecedor nao existe.";
		}
		return getFornecedores().get(nome).toStringExibeFornecedor();

	}

	public String editaFornecedor(String nome, String atributo, String novoValor) {
		ValidatorCliente.verificaStringNull(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringNull(atributo,
				"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(atributo,
				"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		if (existeFornecedor(nome) == false) {
			return "Erro na edicao do fornecedor: fornecedor nao existe.";
		}

		switch (atributo) {
		case "nome":
			System.out.println("Erro na edicao do fornecedor: nome nao pode ser editado.");
			break;
		case "email":
			getFornecedor(nome).setEmail(novoValor);
			break;
		case "telefone":
			getFornecedor(nome).setTelefone(novoValor);
			break;
		default:
			return "Erro na edicao do fornecedor: atributo nao existe.";
		}

		return novoValor;
	}

	public String removeCliente(String nome) {
		ValidatorCliente.verificaStringNull(nome,
				"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		ValidatorCliente.verificaStringVazia(nome,
				"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if (existeFornecedor(nome) == false) {
			return "Erro na remocao do fornecedor: fornecedor nao existe.";
		}
		fornecedores.remove(nome);
		return nome;
	}

}
