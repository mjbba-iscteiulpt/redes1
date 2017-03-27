package calcs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Estatisticas {

	private final int totalTramas = 10000000;
	private int tramaComErros = 0;
	private int tramaSemErros = 0;
	private int errosD = 0;
	private int errosND = 0;
	private int tramasC = 0;
	private int tramasNC = 0;
	private int bitErrados = 0;
	private final String formatStr = "%-10s %-22s %-10s %-10s %-10s";
	private PrintWriter writer;
	private int metodoEscolhido;
	private double probErroBit;
	

	public Estatisticas() {
		// TODO Auto-generated constructor stub
	}
	
	public void resetContadores() {
		tramaComErros = 0;
		tramaSemErros = 0;
		errosD = 0;
		errosND = 0;
		tramasC = 0;
		tramasNC = 0;
		bitErrados = 0;
	}

	public int getTramaSemErros() {
		return tramaSemErros;
	}

	public void tramaSemErros() {
		tramaSemErros++;
	}

	public int getTramaComErros() {
		return tramaComErros;
	}

	public void tramaComErros() {
		tramaComErros++;
	}

	// Contagem dos erros detectados correctamente.
	public void errosDetectatos() {
		errosD++;
	}

	// Contagem dos erros não detectados.
	public void errosNaoDetectados() {
		errosND++;
	}

	// Contagem das tramas corrigidas correctamente.
	public void tramasCorrigidas() {
		tramasC++;
	}

	// Contagem das tramas corrigidas incorrectamente.
	public void tramasNaoCorrigidas() {
		tramasNC++;
	}

	public void countBitErrados(int[] tramaEnviada, int[] tramaRecebida) {
		for (int i = 0; i < tramaEnviada.length; i++) {
			if (tramaEnviada[i] != tramaRecebida[i])
				bitErrados++;
		}

	}

	public void criarFicheiro() {
		File file = new File("C:\\Users\\Mario\\Documents\\repositorio-redes_"+getMetodoEscolhido()+".txt");
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro não encontrado!");
			e.printStackTrace();
		}

	}

	public void escreverHeader() {
		writer.println("#Técnica " + getMetodoEscolhido());
		writer.println(String.format(formatStr, "#Peb", "Pse", "#erros", "Pnd_e", "Pcc_e"));
	}

	public void escreverFicheiro() {
		writer.println(String.format(formatStr, String.valueOf(getProbErroBit()), getPSE(), getValErros(),
				getPND_e(), getPCC_e()));
		writer.flush();
	}

	public void closeWriter() {
		writer.close();
	}

	public int getErrosD() {
		return errosD;
	}

	public int getErrosND() {
		return errosND;
	}

	public int getTramasC() {
		return tramasC;
	}

	public int getTramasNC() {
		return tramasNC;
	}

	public int getBitErrados() {
		return bitErrados;
	}

	public String getMetodoEscolhido() {
		if (metodoEscolhido == 1)
			return "Bit Paridade";
		else if (metodoEscolhido == 2)
			return "Ham(7,4)";
		else if (metodoEscolhido == 3)
			return "CRC, G11";
		else
			return "CRC, G263%";
	}

	public void setMetodoEscolhido(int metodoEscolhido) {
		this.metodoEscolhido = metodoEscolhido;
	}

	public double getProbErroBit() {
		return probErroBit;
	}

	public double getPSE() {
		return (double) tramaSemErros/totalTramas;
	}
	
	public double getValErros() {
		return (double) bitErrados/totalTramas;
	}
	
	public double getPND_e() {
		return (double) errosND/totalTramas;
	}
	
	public double getPCC_e() {
		return (double)tramasC/totalTramas;
	}

	public void setProbErroBit(double probErroBit) {
		this.probErroBit = probErroBit;
	}

	@Override
	public String toString() {
		return "Estatisticas [tramaComErros=" + tramaComErros + ", tramaSemErros=" + tramaSemErros + ", errosD="
				+ errosD + ", errosND=" + errosND + ", tramasC=" + tramasC + ", tramasNC=" + tramasNC + ", bitErrados="
				+ bitErrados + ", probErroBit=" + probErroBit + "]";
	}

}
