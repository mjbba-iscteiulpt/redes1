package emissor;

public class Main {

	public static void main(String[] args) {
		System.out.println("Escolha o m�todo.");
		System.out.println("Manual ou Simula��o (m/s)");
		
		//Implentar simulacao depois. Para facilitar testes fazemos s� manual
		
		Manual manual = new Manual();
		manual.init();
		
		
	}

}
