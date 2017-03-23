package emissor;

import java.util.Scanner;

import singleton.SuperSingleton;

public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		System.out.println("Escolha o método.");
		System.out.println("Manual ou Simulação (m/s)");
		String anwser = reader.next();
		// Implentar simulacao depois. Para facilitar testes fazemos só manual

		if (anwser.equals("m")) {
			SuperSingleton.getInstance().initClasses(1);
			SuperSingleton.getInstance().getManual().init();
		} else if (anwser.equals("s")) {
			SuperSingleton.getInstance().initClasses(2);
			SuperSingleton.getInstance().getSimulacao().run();
		}

	}

}
