package lab2;

public class ContaCantina {
	private int pendura;
	private String nomeCantina;
	private int qtdItens;
	private int valorCentavos;

	ContaCantina(String nomeDaCantina) {
		this.nomeCantina = "Seu Matias";
		this.valorCentavos = 0;
		this.qtdItens = 0;

	};

	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.pendura += valorCentavos;

	}

	public void pagaConta(int valorCentavos) {
		this.pendura -= valorCentavos;

	}

	public int getFaltaPagar() {
		return pendura;
	}

	@Override
	public String toString() {
		return nomeCantina + " " + qtdItens + " " + valorCentavos;
	}

}
