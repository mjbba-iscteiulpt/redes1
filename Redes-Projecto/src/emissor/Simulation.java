package emissor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Simulation {
	
	private final List<Double> probErro = Arrays.asList(0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 0.125, 0.25, 0.5);
	
	public Simulation() {
	}
	
	public void run() {
		
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Escolha o código que quer usar.");
		System.out.println("1:Bit paridade | 2:Hamming | 3:CRC11 | 4: CRC263:");
		int anwser = reader.nextInt();
		simulate(anwser);
	}

	
	public int[] gerarTrama() {
		int[] trama = new int[4];
		for (int i=0;i<4;i++)
			trama[i]= (int) Math.round(Math.random());
		return trama;
	}
	
	public void simulate(int anwser) {
		for (int i=0; i<probErro.size(); i++) {
			for (int c=0; c<10000000; c++) {
				System.out.println(Arrays.toString(gerarTrama()));
			}
		}
	}
}
