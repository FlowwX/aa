package Aufgabenblatt01;

public class Matrize{
	
	final static int ZAHLEN_BEREICH = 10;
	
	private int m;
	private int n;
	private int feld[][];
	
	public Matrize(int m, int n) {
		feld = new int[m][n];
		this.m = m;
		this.n = n;
		
		fuelleFeld();
	}
	
	private void fuelleFeld(){
		for(int i=0; i<m; i++){
			for(int k=0; k<n; k++){
				feld[i][k] = (int) (Math.random() * ZAHLEN_BEREICH);
			}
		}
	}
	
	public Matrize multipliziere(Matrize matrizeB) throws IncompatibleMatricesException{
		
		if( !pruefeKompatiblitaet(matrizeB) ){
			throw new IncompatibleMatricesException("Die Matrizen sind nicht kompatibel.");
		}
		
		Matrize ergebnis = new Matrize(m, matrizeB.getN());
		
		for(int zeileA=0; zeileA<m; zeileA++){
			for(int spalteB=0; spalteB<matrizeB.getN(); spalteB++){
				int wert = 0;
				for(int i=0; i<n; i++){
					int wertA = getValue(i, zeileA);
					int wertB = matrizeB.getValue(spalteB, i);
					wert += wertA * wertB;
					ergebnis.setValue(spalteB, zeileA, wert);
				}
			}
		}
		
		return ergebnis;
	}
	
	public boolean pruefeKompatiblitaet(Matrize b) {
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

	public static void main(String[] args) {
		
		Matrize a = new Matrize(3, 3);
		Matrize b = new Matrize(3, 2);
		Matrize c = null;
		
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
