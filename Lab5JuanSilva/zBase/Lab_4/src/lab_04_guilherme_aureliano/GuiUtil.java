package lab_04_guilherme_aureliano;

public class GuiUtil {
	public static void verificaStringVazia(String valor, String mensagem) {
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void verificaStringNull(String valor, String mensagem) {
		if(valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
}
