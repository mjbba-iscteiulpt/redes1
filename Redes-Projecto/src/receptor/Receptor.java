package receptor;

import java.util.Arrays;
import singleton.SuperSingleton;

public class Receptor {

	public Receptor() {
		// Exists only to defeat instantiation.
	}

	// teste
	public void tramaRecebida(int[] trama, int metodoEscolhido) {
		int[] tramaRecebida = trama.clone();
		if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaRecebida)) {
			SuperSingleton.getInstance().getEstatisticas().tramaComErros();
		} else
			SuperSingleton.getInstance().getEstatisticas().tramaSemErros();
		
		switch (metodoEscolhido) {
		case 1:
			int[] tramaAContar = new int[5];

			for (int i = 0; i < tramaAContar.length - 1; i++) {
				tramaAContar[i] = trama[i];
			}
			System.out.println(">> Trama Recebida: " + Arrays.toString(trama));
			SuperSingleton.getInstance().getBitParidade()
					.detectErrors(SuperSingleton.getInstance().getBitParidade().countOnes(tramaAContar), trama);

			break;

		case 2:
			System.out.println(">> Trama Recebida: " + Arrays.toString(trama));
			int posicaoErro = SuperSingleton.getInstance().getHamming().calcC(trama);
			
			if (posicaoErro != 0) {
				trama[posicaoErro - 1] = SuperSingleton.getInstance().getAuxCalc().calcXor(trama[7-posicaoErro], 1);
				System.out.println(">> Trama corrigida na posição " + posicaoErro);
				System.out.println("Trama após correcção: "+Arrays.toString(trama));
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) {
					System.out.println("-- Erros detectados correctamente --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
					SuperSingleton.getInstance().getEstatisticas().tramasCorrigidas();
				} else {
					System.out.println("-- Trama corrigida incorrectamente. --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
					SuperSingleton.getInstance().getEstatisticas().tramasNaoCorrigidas();
				}
			} else {
				if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) {
					System.out.println("-- Trama com erro(s) não detectados. --");
					SuperSingleton.getInstance().getEstatisticas().errosNaoDetectados();
				}
			}

			break;

		case 3:
			System.out.println(">> Trama Recebida: " + Arrays.toString(trama));
			int[] tramaFinal = SuperSingleton.getInstance().getCrc11().calcFCS(trama).clone();
			if (SuperSingleton.getInstance().getCrc11().checkFCS(tramaFinal) == 0) {
				System.out.println("Trama sem erro(s) detectados.");
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaRecebida)) {
					System.out.println("-- Erros detectados correctamente --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
				} else {
					System.out.println("-- Trama com erro(s) não detectados. --");
					SuperSingleton.getInstance().getEstatisticas().errosNaoDetectados();
				}
			} else {
				System.out.println("Trama com erro(s) detectados.");
				if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaRecebida)) {
					System.out.println("-- Erros detectados correctamente --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
				}
			}
			break;

		case 4:
			int[] tramaFinalCRC = SuperSingleton.getInstance().getCrc263().calcFCS(trama).clone();
			System.out.println(">> Trama Recebida: " + Arrays.toString(tramaFinalCRC));
			System.out.println(SuperSingleton.getInstance().getCrc263().checkFCS(tramaFinalCRC));
			if (SuperSingleton.getInstance().getCrc263().checkFCS(tramaFinalCRC) == 0) {
				System.out.println("Trama sem erro(s) detectados.");
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaRecebida)) {
					System.out.println("-- Erros detectados correctamente --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
				} else {
					System.out.println("-- Trama com erro(s) não detectados. --");
					SuperSingleton.getInstance().getEstatisticas().errosNaoDetectados();
				}
			} else {
				System.out.println("Trama com erro(s) detectados.");
				if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaRecebida)) {
					System.out.println("-- Erros detectados correctamente --");
					SuperSingleton.getInstance().getEstatisticas().errosDetectatos();
				}
			}
			break;
		}
		
		SuperSingleton.getInstance().getEstatisticas().countBitErrados(SuperSingleton.getInstance().getAuxCalc().getTramaEnviada(), tramaRecebida);
		System.out.println("");
		System.out.println(SuperSingleton.getInstance().getEstatisticas().toString());
	}

}
