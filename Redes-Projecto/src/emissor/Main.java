package emissor;

public class Main {

	public static void main(String[] args) {
		System.out.println("Escolha o método.");
		System.out.println("Manual ou Simulação (m/s)");
		
		//Implentar simulacao depois. Para facilitar testes fazemos só manual
		
		Manual manual = new Manual();
		manual.init();
		
		
	}

}
