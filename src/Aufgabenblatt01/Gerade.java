package Aufgabenblatt01;

public class Gerade {
	private Punkt einstiegsPunkt;
	private Punkt richtungsVektor;
	
	public Gerade(Punkt epunkt, Punkt rvektor) {
		einstiegsPunkt = epunkt;
		richtungsVektor = rvektor;
	}
	public static double abstand(Gerade g, Punkt p){
		
		double lamda = -((((g.getEinstiegsPunkt().getX() - p.getX()) * g.getRichtungsVektor().getX() +
					(g.getEinstiegsPunkt().getY() - p.getY()) * g.getRichtungsVektor().getY()) / 
					( Math.pow(g.getRichtungsVektor().getX(), 2) + Math.pow(g.getRichtungsVektor().getY(), 2))));
		
		double lotPunkt1 = g.getRichtungsVektor().getX() * lamda + g.getEinstiegsPunkt().getX();
		double lotPunkt2 = g.getRichtungsVektor().getY() * lamda + g.getEinstiegsPunkt().getY();
		
		//Punkt lotPunkt = new Punkt((int)lotPunkt1, (int)lotPunkt2);
		
		double abstandsVektor1 = lotPunkt1 - p.getX();
		double abstandsVektor2 = lotPunkt2 - p.getY();
		
		//Punkt abstandsVektor = new Punkt(abstandsVektor1, abstandsVektor2);
		
		double betragAbstand = Math.sqrt( (Math.pow(abstandsVektor1, 2) + Math.pow(abstandsVektor2, 2)) ); 
		
		return betragAbstand;
	}
	
	public Punkt getEinstiegsPunkt() {
		return einstiegsPunkt;
	}
	
	public Punkt getRichtungsVektor() {
		return richtungsVektor;
	}
	
	public static void main(String[] args) {
		
		Punkt ep = new Punkt(1, 1);
		Punkt rv = new Punkt(1, 4);
		
		Punkt p = new Punkt(4, 5);
		
		Gerade g = new Gerade(ep, rv);
		double abstand = abstand(g, p);
		
		System.out.println(abstand);
	}
}
