package emissor;

import java.util.Scanner;

import codes.BitParidade;

public class Manual {

	private static Manual instance = null;

	protected Manual() {
		// Exists only to defeat instantiation.
	}

	public static Manual getInstance() {
		if (instance == null) {
			instance = new Manual();
		}
		return instance;
	}

	public void init() {
		askQuestions();
	}

	public void askQuestions() {
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Escolha o c�digo que quer usar.");
		System.out.println("1:Bit paridade | 2:Hamming | 3:CRC11 | 4: CRC263:");
		int anwser = reader.nextInt();
		
		System.out.println("Insira a trama");
		String stringTrama = reader.next();
		int[] trama = new int[5];
		for (int i =0; i< stringTrama.length(); i++) {
			trama[i] = Integer.parseInt(String.valueOf(stringTrama.charAt(i)));
		}
		BitParidade bitParidade = new BitParidade();
		switch(anwser) {
		   case 1:
			   //teste
			   int[] tramaFinal = bitParidade.calcularParidade(trama);
			   String teste = "";
			   for (int i = 0; i< tramaFinal.length; i++)
				   teste += tramaFinal[i];
			   System.out.println(teste);
		      break; 
		   
		   case 2:
		      // Statements
		      break; // optional
		   
		   case 3:
			   
			   break;
			   
		   case 4:
			   
			   break;
		}
		
	}

}
