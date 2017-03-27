package canalruidoso;

import java.util.Arrays;
import java.util.Random;

import singleton.SuperSingleton;

public class CanalRuidoso {
	
	public CanalRuidoso() {
		
	}
	
	//Serve para gerar um padrão de erros aleatório para ser usado durante a simulação
	public int[] gerarPadraoErros(double probErro, int[] trama) {
		int[] padraoErros = new int[trama.length];
		double erro = 0;
		Random random = new Random();
		for (int i=0; i<trama.length; i++) {
			erro = 0.000000 + (1-0.000000) * random.nextDouble();
			if (erro <= probErro) { 
				padraoErros[i] = 1;
			}else 
				padraoErros[i] = 0;			
		}
		System.out.println("Padrao de erros: "+Arrays.toString(padraoErros));
		return padraoErros;
	}
	
	//Serve para fazer o xor do padrão de erros com a trama enviada.
	public int[] addErrosTrama(int[] padraoErros, int[] trama){
		
		for (int i = 0; i<trama.length; i++) {
			trama[i] = SuperSingleton.getInstance().getAuxCalc().calcXor(trama[i], padraoErros[i]);
		}
		System.out.println("Trama após canal ruidoso: "+Arrays.toString(trama) );
		return trama;
	}

}
