package Aufgabenblatt01;

/**
 * Vektormatrix.
 * 
 * @author Florian Heuer
 *
 */
public class Matrix{
	
	/**
	 *  Konstante die den Zahlenbereich definert,
	 *  aus diesen Zahlen für die initialisierung 
	 *  der Matrizen gewählt werden.
	 */
	final static int ZAHLEN_BEREICH = 10;
	
	private int m;
	private int n;
	private int feld[][];
	
	/**
	 * Konstruktor
	 */
	public Matrix(int m, int n) {
		feld = new int[m][n];
		this.m = m;
		this.n = n;
		
		// befülle Matrix mit zufälligen Zahlen aus dem Zahlenbereich
		fuelleFeld();
	}
	
	/**
	 *  Funktion zur Initialensierung der Matrix.
	 */
	private void fuelleFeld(){
		for(int i=0; i<m; i++){
			for(int k=0; k<n; k++){
				feld[i][k] = (int) (Math.random() * ZAHLEN_BEREICH);
			}
		}
	}
	
	/**
	 * Multiplikation mit einer Matrix.
	 * @param matrixB
	 * @return Matrix (Produkt mit matrixB)
	 * @throws IncompatibleMatricesException
	 */
	public Matrix multipliziere(Matrix matrixB) throws IncompatibleMatricesException{
		
		if( !pruefeKompatiblitaet(matrixB) ){
			throw new IncompatibleMatricesException("Die Matrizen sind nicht kompatibel.");
		}
		
		Matrix ergebnis = new Matrix(m, matrixB.getN());
		
		for(int zeileA=0; zeileA<m; zeileA++){
			for(int spalteB=0; spalteB<matrixB.getN(); spalteB++){
				int wert = 0;
				for(int i=0; i<n; i++){
					int wertA = getValue(i, zeileA);
					int wertB = matrixB.getValue(spalteB, i);
					wert += wertA * wertB;
					ergebnis.setValue(spalteB, zeileA, wert);
				}
			}
		}
		
		return ergebnis;
	}
	
	/**
	 * Prüft ob die Matrix b multiplizierbar ist.
	 * @param b
	 * @return boolean
	 */
	public boolean pruefeKompatiblitaet(Matrix b) {
		return (n==b.getM());
	}
	
	@Override
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				ausgabe += feld[i][k] + " ";
			}
			ausgabe += "\n";
		}
		return ausgabe;
	}
	
	public void setValue(int x, int y, int value) {
		feld[y][x] = value;
	}
	
	public int getValue(int x, int y) {
		return feld[y][x];
	}
	
	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}
	
	/*
	 *	Hauptprogramm 
	 */
	public static void main(String[] args) {
		
		Matrix a = new Matrix(3, 3);
		Matrix b = new Matrix(3, 2);
		Matrix c = null;
		
		try {
			c = a.multipliziere(b);
		} catch (IncompatibleMatricesException e) {
			e.printStackTrace();
		}
		
		System.out.println(a);

		System.out.println(b);

		System.out.println(c);
		
	}
	

}
