package emissor;

import java.util.Arrays;
import java.util.Scanner;
import singleton.SuperSingleton;

public class Manual {
	
	String stringPadrao; 
	int[] padraoErros;

	public Manual() {
	}

	public void init() {
		askQuestions();
	}

	public void askQuestions() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Escolha o código que quer usar.");
		System.out.println("1:Bit paridade | 2:Hamming | 3:CRC11 | 4: CRC263:");
		int anwser = reader.nextInt();
		SuperSingleton.getInstance().getEstatisticas().setMetodoEscolhido(anwser);
		System.out.println("Insira a trama:");
		String stringTrama = reader.next();
		int[] trama = new int[5];
		for (int i = 0; i < stringTrama.length(); i++) {
			trama[i] = Integer.parseInt(String.valueOf(stringTrama.charAt(i)));
		}
		
		

		int[] tramaFinal;
		switch (anwser) {
		case 1:
			// teste
			System.out.println("Insira o padrão de erros:");
			stringPadrao = reader.next();
			padraoErros = new int[5];
			for (int i = 0; i < stringPadrao.length(); i++) {
				padraoErros[i] = Integer.parseInt(String.valueOf(stringPadrao.charAt(i)));
			}
			System.out.println("");
			System.out.println("");
			SuperSingleton.getInstance().initBit();
			tramaFinal = SuperSingleton.getInstance().getBitParidade().calcularParidade(trama);
			SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaFinal);
			System.out.println(">> Trama enviada. " + Arrays.toString(tramaFinal));
			tramaFinal = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(padraoErros, tramaFinal);
			SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaFinal, 1);
			break;

		case 2:
			System.out.println("Insira o padrão de erros:");
			stringPadrao = reader.next();
			padraoErros = new int[7];
			for (int i = 0; i < stringPadrao.length(); i++) {
				padraoErros[i] = Integer.parseInt(String.valueOf(stringPadrao.charAt(i)));
			}
			SuperSingleton.getInstance().initHamming();
			tramaFinal = new int[7];
			int[] vectorOfP = SuperSingleton.getInstance().getHamming().calcP(trama);
			int auxCount = 0;
			int auxCountP = 0;
			for (int i = 0; i < tramaFinal.length; i++) {
				if (i==2 || i==4 || i==5 ||i==6){
					tramaFinal[i] = trama[auxCount];
					auxCount++;
				}else {
					tramaFinal[i] =vectorOfP[auxCountP];
					auxCountP++;
				}				
			}
			SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaFinal);
			System.out.println(">> Trama enviada. " + Arrays.toString(tramaFinal));
			tramaFinal = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(padraoErros, tramaFinal);
			SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaFinal, 2);
			break;

		case 3:
			System.out.println("Insira o padrão de erros:");
			stringPadrao = reader.next();
			padraoErros = new int[7];
			for (int i = 0; i < stringPadrao.length(); i++) {
				padraoErros[i] = Integer.parseInt(String.valueOf(stringPadrao.charAt(i)));
			}
			SuperSingleton.getInstance().initCRC11();
			int[] tramaAux= new int[7];
			
			for (int c=0;c<tramaAux.length;c++) {
				if (c<4)
					tramaAux[c] = trama[c];
				else
					tramaAux[c] = 0;
			}
			tramaAux = SuperSingleton.getInstance().getCrc11().calcFCS(tramaAux);
			SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaAux);
			System.out.println(">> Trama enviada. " + Arrays.toString(tramaAux));
			tramaAux = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(padraoErros, tramaAux);
			SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaAux, 3);
			
			break;

		case 4:
			System.out.println("Insira o padrão de erros:");
			stringPadrao = reader.next();
			padraoErros = new int[12];
			for (int i = 0; i < stringPadrao.length(); i++) {
				padraoErros[i] = Integer.parseInt(String.valueOf(stringPadrao.charAt(i)));
			}
			SuperSingleton.getInstance().initCRC263();
			int[] tramaAuxCRC= new int[12];
			
			for (int c=0;c<tramaAuxCRC.length;c++) {
				if (c<4)
					tramaAuxCRC[c] = trama[c];
				else
					tramaAuxCRC[c] = 0;
			}
			tramaAuxCRC = SuperSingleton.getInstance().getCrc263().calcFCS(tramaAuxCRC);
			SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaAuxCRC);
			System.out.println(">> Trama enviada:  " + Arrays.toString(tramaAuxCRC));
			tramaAuxCRC = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(padraoErros, tramaAuxCRC);
			SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaAuxCRC, 4);
			break;
		}

	}

}
