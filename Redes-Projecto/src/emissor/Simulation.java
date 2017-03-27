package emissor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import singleton.SuperSingleton;

public class Simulation {

	private final List<Double> probErro = Arrays.asList(0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 0.125, 0.25, 0.5);
	private int[] trama;
	
	public Simulation() {
	}
	
	public void run() {
		
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Escolha o código que quer usar.");
		System.out.println("1:Bit paridade | 2:Hamming | 3:CRC11 | 4: CRC263:");
		int anwser = reader.nextInt();
		//simulate(anwser);
		SuperSingleton.getInstance().getEstatisticas().setMetodoEscolhido(anwser);
		SuperSingleton.getInstance().getEstatisticas().criarFicheiro();
		SuperSingleton.getInstance().getEstatisticas().escreverHeader();
		for (Double pb : probErro) {
			SuperSingleton.getInstance().getEstatisticas().setProbErroBit(pb);
			SuperSingleton.getInstance().getEstatisticas().resetContadores();
			for (int i = 0; i<10000000;i++) {
				trama = gerarTrama().clone();
				int[] tramaFinal;
				switch (anwser) {
				case 1:
					System.out.println("");
					System.out.println("");
					SuperSingleton.getInstance().initBit();
					tramaFinal = SuperSingleton.getInstance().getBitParidade().calcularParidade(trama).clone();
					SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaFinal);
					System.out.println(">> Trama enviada. " + Arrays.toString(tramaFinal));
					tramaFinal = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(SuperSingleton.getInstance().getCanalRuido().gerarPadraoErros(pb, tramaFinal), tramaFinal);
					SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaFinal, 1);
					break;

				case 2:
					
					SuperSingleton.getInstance().initHamming();
					tramaFinal = new int[7];
					int[] vectorOfP = SuperSingleton.getInstance().getHamming().calcP(trama);
					int auxCount = 0;
					int auxCountP = 0;
					for (int x = 0; x < tramaFinal.length; x++) {
						if (x==2 || x==4 || x==5 ||x==6){
							tramaFinal[x] = trama[auxCount];
							auxCount++;
						}else {
							tramaFinal[x] =vectorOfP[auxCountP];
							auxCountP++;
						}				
					}
					SuperSingleton.getInstance().getAuxCalc().setTramaEnviada(tramaFinal);
					System.out.println(">> Trama enviada. " + Arrays.toString(tramaFinal));
					tramaFinal = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(SuperSingleton.getInstance().getCanalRuido().gerarPadraoErros(pb, tramaFinal), tramaFinal);
					SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaFinal, 2);
					break;

				case 3:
					
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
					tramaAux = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(SuperSingleton.getInstance().getCanalRuido().gerarPadraoErros(pb, tramaAux), tramaAux);
					SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaAux, 3);
					
					break;

				case 4:
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
					tramaAuxCRC = SuperSingleton.getInstance().getCanalRuido().addErrosTrama(SuperSingleton.getInstance().getCanalRuido().gerarPadraoErros(pb, tramaAuxCRC), tramaAuxCRC);
					SuperSingleton.getInstance().getReceptor().tramaRecebida(tramaAuxCRC, 4);
					break;
				}
			}
			SuperSingleton.getInstance().getEstatisticas().escreverFicheiro();
		}
		SuperSingleton.getInstance().getEstatisticas().closeWriter();
	}

	
	public int[] gerarTrama() {
		int[] trama = new int[4];
		for (int i=0;i<4;i++)
			trama[i]= (int) Math.round(Math.random());
		return trama;
	}
}
