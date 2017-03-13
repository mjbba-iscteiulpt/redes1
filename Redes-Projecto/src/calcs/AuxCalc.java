package calcs;


public class AuxCalc {
	
	private static AuxCalc instance = null;

	protected AuxCalc() {
		// Exists only to defeat instantiation.
	}

	public static AuxCalc getInstance() {
		if (instance == null) {
			instance = new AuxCalc();
		}
		return instance;
	}
	
	
	public int calcXor(int value1, int value2) {
		if (value1 != value2)
			return 1;
		return 0;
	}

}
