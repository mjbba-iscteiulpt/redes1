package singleton;

import calcs.AuxCalc;
import calcs.Estatisticas;
import canalruidoso.CanalRuidoso;
import codes.BitParidade;
import codes.Crc11;
import codes.Crc263;
import codes.Hamming;
import emissor.Manual;
import emissor.Simulation;
import receptor.Receptor;

public class SuperSingleton {
	
	private static SuperSingleton instance = null;
	private BitParidade bitParidade;
	private Hamming hamming;
	private Crc11 crc11;
	private Crc263 crc263;
	private Manual manual;
	private Simulation simulacao;
	private Receptor receptor;
	private AuxCalc auxCalc;
	private CanalRuidoso canalRuido;
	private Estatisticas estatisticas;
	

	public Estatisticas getEstatisticas() {
		return estatisticas;
	}

	protected SuperSingleton() {
		// Exists only to defeat instantiation.
	}

	public static SuperSingleton getInstance() {
		if (instance == null) {
			instance = new SuperSingleton();
		}
		return instance;
	}
	
	
	public void initClasses(int escolha) {
		if (escolha == 1) 
			manual = new Manual();
		else
			simulacao = new Simulation();
		receptor = new Receptor();
		auxCalc = new AuxCalc();
		canalRuido = new CanalRuidoso();
		estatisticas = new Estatisticas();
	}
	
	public void initBit() {
		bitParidade = new BitParidade();
	}
	
	public void initHamming() {
		hamming = new Hamming();
	}
	
	public void initCRC11() {
		crc11 = new Crc11();
	}
	
	public void initCRC263() {
		crc263 = new Crc263();
	}

	public BitParidade getBitParidade() {
		return bitParidade;
	}

	public Hamming getHamming() {
		return hamming;
	}

	public Crc11 getCrc11() {
		return crc11;
	}

	public Crc263 getCrc263() {
		return crc263;
	}

	public Manual getManual() {
		return manual;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public AuxCalc getAuxCalc() {
		return auxCalc;
	}

	public CanalRuidoso getCanalRuido() {
		return canalRuido;
	}

	public Simulation getSimulacao() {
		return simulacao;
	}

	
	
	
	
	

}
