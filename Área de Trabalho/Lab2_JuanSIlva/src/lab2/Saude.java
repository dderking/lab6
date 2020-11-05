package lab2;

public class Saude {
	private String saudeMental;
	private String saudeFisica;

	Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}

	public void defineSaudeMental(String saudeMental) {
		this.saudeMental = saudeMental;

	}

	public void defineSaudeFisica(String saudeFisica) {
		this.saudeFisica = saudeFisica;

	}

	public String getStatusGeral() {
		if (saudeFisica.equals("boa") && saudeMental.equals("boa")) {
			return "boa";
		} else if (saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
			return "fraca";
		} else {
			return "ok";

		}
	}

}
