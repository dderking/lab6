package fornecedor;

public class Produto {
	private String nome;
	private String descricao;
	private double preco;

	public Produto() {

	}

	public Produto(Fornecedor fornecedor, String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	public String getNome() {
		return nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String toStringNome() {
		return "Nome: " + getNome();
	}

	public String toStringExibeProduto() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}
}
