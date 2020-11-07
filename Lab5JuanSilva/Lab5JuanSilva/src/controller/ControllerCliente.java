package controller;

import java.util.HashMap;

import cliente.Cliente;
import validator.Validator;

public class ControllerCliente {
	private HashMap<String, Cliente> clientes;
	public ControllerCliente() {
		
	}

	public ControllerCliente(HashMap<String, Cliente> clientes) {
		this.clientes = new HashMap<>();
	}

	public Cliente getCliente(String cpf) {
		return clientes.get(cpf);
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if (existeCliente(cpf) == false) {
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			Validator.verificaStringNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
			Validator.verificaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
			Validator.verificaCpfInvalido(cpf, "Erro no cadastro do cliente: cpf invalido.");
			Validator.verificaStringNull(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
			Validator.verificaStringVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
			Validator.verificaStringNull(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
			Validator.verificaStringVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
			Validator.verificaStringNull(localizacao,
					"Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
			Validator.verificaStringVazia(localizacao,
					"Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
			this.clientes.put(cpf, cliente);
			return cliente.toStringCpf();
		} else {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}

	public boolean existeCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}

	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public String exibeCliente(String cpf) {
		Validator.verificaStringNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Validator.verificaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		if (existeCliente(cpf) == false) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return getClientes().get(cpf).toStringExibeCliente();

	}
	public String exibeTodosClientes() {
		String texto = "";
		for (String chave : clientes.keySet()){
			texto += clientes.get(chave).toStringExibeCliente();
			texto += " | ";
			}
		return texto;
	}

	public String editaCliente(String cpf, String atributo, String novoValor) {
		Validator.verificaStringNull(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Validator.verificaStringVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Validator.verificaStringNull(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Validator.verificaStringVazia(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		if (existeCliente(cpf) == false) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

		switch (atributo) {

		case "cpf":
			System.out.println("Erro na edicao do cliente: cpf nao pode ser editado.");
			break;
		case "nome":
			getCliente(cpf).setNome(novoValor);
			break;
		case "email":
			getCliente(cpf).setEmail(novoValor);
			break;
		case "localizacao":
			getCliente(cpf).setLocalizacao(novoValor);
			break;
		default:
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}

		return novoValor;
	}

	public String removeCliente(String cpf) {
		Validator.verificaStringNull(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		Validator.verificaStringVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		if (existeCliente(cpf) == false) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
		return cpf;
	}
}
