package principal;

public class Quadrado extends Forma {
	
	public Quadrado(Ponto2D[] pontos) {
		super(pontos);
	}

	@Override
	public double calculaArea() {
		return Math.pow(segmentos[0], 2);
	}

	@Override
	public double calculaPerimetro() {
		return 4*segmentos[0];
	}
}
