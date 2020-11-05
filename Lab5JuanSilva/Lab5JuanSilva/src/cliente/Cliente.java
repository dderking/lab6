package cliente;

public class Cliente {

	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	public Cliente() {
		
	}

	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String toStringCpf() {
		return "CPF: " + getCpf();
	}

	public String toStringExibeCliente() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

}
