package lab2;

public class ContaLaboratorio {
	private int espacoConsumido;
	private int cota;
	private String nomeLaboratorio;

	ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
		this.espacoConsumido = 0;
	}

	ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoConsumido = 0;
	}

	public void consomeEspaco(int mbytes) {
		this.espacoConsumido = espacoConsumido + mbytes;
	}

	public void liberaEspaco(int mbytes) {
		this.espacoConsumido = espacoConsumido - mbytes;

	}

	public boolean atingiuCota() {
		if (espacoConsumido >= cota) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return nomeLaboratorio + " " + espacoConsumido + "/" + cota;
	}

}
