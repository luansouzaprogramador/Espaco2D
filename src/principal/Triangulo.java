package principal;

public class Triangulo extends Forma {
	public Triangulo(Ponto2D[] pontos) {
		super(pontos);
	}

	@Override
	public double calculaArea() {
		double sp = calculaPerimetro()/2;
		
		return Math.sqrt(sp * (sp-segmentos[0]) * (sp-segmentos[1]) * (sp-segmentos[2]));
	}

	@Override
	public double calculaPerimetro() {
		double perimetro=0;
		
		for (int i=0; i<segmentos.length; i++) {
			perimetro += segmentos[i];
		}
		
		return perimetro;
	}
	
	public String tipoTriangulo() {
		String tipo;
		
		if (segmentos[0]!=segmentos[1] && segmentos[1]!=segmentos[2]) {
			tipo = "Escaleno";
		} else if (segmentos[0]==segmentos[1] && segmentos[1]==segmentos[2]) {
			tipo = "Equilatero";
		} else {
			tipo = "Isosceles";
		}
		
		return tipo;
	}
}
