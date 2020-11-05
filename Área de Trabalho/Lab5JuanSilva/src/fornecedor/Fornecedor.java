package fornecedor;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;

	public Fornecedor() {

	}

	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

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

	public String toStringNome() {
		return "Nome: " + getNome();
	}

	public String toStringExibeFornecedor() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

}
