package ar.edu.asap.practica0.modelo;

public class Lizard extends PiedraPapelTijeraFactory {

	public Lizard() {
		this("lizard", PiedraPapelTijeraFactory.LIZARD);
	}	
	
	public Lizard(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int pNUm) {
		return pNUm == PiedraPapelTijeraFactory.LIZARD;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPPTFact) {
		int result=0;
		
		switch (pPPTFact.getNumero()) {
		case PiedraPapelTijeraFactory.PIEDRA:
			result=-1;
			this.descripcionResultado = nombre + " pierde con " + pPPTFact.getNombre();		
			break;
		case PiedraPapelTijeraFactory.TIJERA:
			result=-1;
			this.descripcionResultado = nombre + " pierde con " + pPPTFact.getNombre();		
			break;		
		case PiedraPapelTijeraFactory.SPOCK:
			result=1;
			this.descripcionResultado = nombre + " le gana a " + pPPTFact.getNombre();		
			break;
		case PiedraPapelTijeraFactory.PAPEL:
			result=1;
			this.descripcionResultado = nombre + " le gana a " + pPPTFact.getNombre();		
			break;
		default:
			this.descripcionResultado = nombre + " empata con " + pPPTFact.getNombre();					
			break;		
		}		
		
		return result;
	}
}
