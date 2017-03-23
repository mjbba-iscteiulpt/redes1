package receptor;

import java.util.Arrays;

import codes.Crc11;
import codes.Crc263;
import singleton.SuperSingleton;

public class Receptor {

	public Receptor() {
		// Exists only to defeat instantiation.
	}

	// teste
	public void tramaRecebida(int[] trama, int metodoEscolhido) {

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
				} else
					System.out.println("-- Trama corrigida incorrectamente. --");
			} else {
				System.out.println(">> Trama sem erro(s) detectados.");
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) 
					System.out.println("-- Trama com erro(s) não detectados. --");
			}

			break;

		case 3:
			System.out.println(">> Trama Recebida: " + Arrays.toString(trama));
			int[] tramaFinal = SuperSingleton.getInstance().getCrc11().calcFCS(trama).clone();
			if (SuperSingleton.getInstance().getCrc11().checkFCS(tramaFinal) == 0) {
				System.out.println("Trama sem erro(s) detectados.");
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaFinal)) {
					System.out.println("-- Erros detectados correctamente --");
				} else
					System.out.println("-- Trama com erro(s) não detectados. --");
			} else {
				System.out.println("Trama com erro(s) detectados.");
				if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaFinal)) {
					System.out.println("-- Erros detectados correctamente --");
				}
			}
			break;

		case 4:
			int[] tramaFinalCRC = SuperSingleton.getInstance().getCrc263().calcFCS(trama).clone();
			System.out.println(">> Trama Recebida: " + Arrays.toString(trama));
			if (SuperSingleton.getInstance().getCrc263().checkFCS(tramaFinalCRC) == 0) {
				System.out.println("Trama sem erro(s) detectados.");
				if (SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaFinalCRC)) {
					System.out.println("-- Erros detectados correctamente --");
				} else
					System.out.println("-- Trama com erro(s) não detectados. --");
			} else {
				System.out.println("Trama com erro(s) detectados.");
				if (!SuperSingleton.getInstance().getAuxCalc().checkTramas(tramaFinalCRC)) {
					System.out.println("-- Erros detectados correctamente --");
				}
			}
			break;
		}

	}

}
