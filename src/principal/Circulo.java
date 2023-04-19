package principal;

public class Circulo extends Forma {
	
	public Circulo(Ponto2D[] pontos) {
		super(pontos);
	}

	@Override
	public double calculaArea() {
		return Math.PI * Math.pow(segmentos[0], 2);
	}

	@Override
	public double calculaPerimetro() {
		return 2*Math.PI*segmentos[0];
	}
}
