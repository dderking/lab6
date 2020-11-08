package saga;

import java.util.HashMap;
import java.util.Map;

import controller.ControllerCliente;
import controller.ControllerFornecedor;
import controller.ControllerProdutosDosFornecedores;
import easyaccept.EasyAccept;
import fornecedor.Fornecedor;

public class Facade {
	private ControllerCliente cliente;
	private ControllerFornecedor fornecedor;
	private ControllerProdutosDosFornecedores produtos;

	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		Map<String, Fornecedor> fornecedores = new HashMap<>();
		this.cliente = new ControllerCliente();
		this.fornecedor = new ControllerFornecedor(fornecedores);
		this.produtos = new ControllerProdutosDosFornecedores(fornecedores);
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return cliente.adicionaCliente(cpf, nome, email, localizacao);
	}

	public String editaCliente(String cpf, String atributo, String novoValor) {
		return cliente.editaCliente(cpf, atributo, novoValor);
	}

	public String exibeCliente(String cpf) {
		return cliente.exibeCliente(cpf);
	}

	public String removeCliente(String cpf) {
		return cliente.removeCliente(cpf);
	}

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fornecedor.adicionaFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return fornecedor.exibeFornecedor(nome);
	}

	public String exibeClientes() {
		return cliente.exibeTodosClientes();
	}

	public String editaFornecedor(String nome, String atributo, String novoValor) {
		return fornecedor.editaFornecedor(nome, atributo, novoValor);
	}

	public String removeFornecedor(String nome) {
		return fornecedor.removeFornecedor(nome);
	}

	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.produtos.cadastraProduto(fornecedor, nome, descricao, preco);
	}

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.produtos.exibeProduto(fornecedor, nome, descricao);
	}

	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.produtos.editaProduto(nome, descricao, fornecedor, novoPreco);
	}

	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.produtos.removeProduto(nome, descricao, fornecedor);
	}
}
