package saga;

import controller.ControllerCliente;
import easyaccept.EasyAccept;

public class Facade {
	private ControllerCliente cliente;
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "acceptance_test/use_case_1.txt" };
		EasyAccept.main(args);
	}
	public Facade() {
		this.cliente = new ControllerCliente();
		
	}


}
