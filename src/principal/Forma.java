package principal;

public abstract class Forma {
	private Ponto2D[] pontos;
	protected double[] segmentos;
	
	public Forma() {
		
	}
	
	public Forma(Ponto2D[] pontos) {
		this.pontos = pontos;
		
		if (pontos.length == 2)
			segmentos = new double[1];
		else
			segmentos = new double[pontos.length];
		
		if (pontos.length == 2) {
			segmentos[0] = pontos[0].calculaDistancia(pontos[1]);
		} else {
			for (int i=0; i<pontos.length; i++) {
				if (i == pontos.length-1) {
					segmentos[i] = pontos[i].calculaDistancia(pontos[0]);
				} else {
					segmentos[i] = pontos[i].calculaDistancia(pontos[i+1]);
				}
			}
		}
	}
	
	public static Forma geraForma(Ponto2D[] pontos) {
		Forma retorno = null;
		
		switch (pontos.length) {
		case 2:
			if (geraCirculo(pontos)) {
				retorno = new Circulo(pontos);
			}
			break;
		case 3:
			if (geraTriangulo(pontos)) {
				retorno = new Triangulo(pontos);
			}
			break;
		case 4:
			if (geraQuadrado(pontos)) {
				retorno = new Quadrado(pontos);
			}
			break;
		}
		return retorno;
	}
	
	private static boolean geraTriangulo(Ponto2D[] pontos) {
		Triangulo aux = new Triangulo(pontos);
		
		if ((aux.segmentos[0] < aux.segmentos[1]+aux.segmentos[2]) || (aux.segmentos[1] < aux.segmentos[0]+aux.segmentos[2]) || (aux.segmentos[2] < aux.segmentos[0]+aux.segmentos[1])) {
			return true;
		}
		return false;
	}
	
	private static boolean geraQuadrado(Ponto2D[] pontos) {
		Quadrado aux = new Quadrado(pontos);
		if (aux.segmentos[0]==aux.segmentos[1] && aux.segmentos[1]==aux.segmentos[2] && aux.segmentos[2]==aux.segmentos[3]) {
			return true;
		}
		return false;
	}
	
	private static boolean geraCirculo(Ponto2D[] pontos) {
		Circulo aux = new Circulo(pontos);
		if (aux.segmentos[0] > 0)
			return true;
		
		return false;
	}
	
	public abstract double calculaArea();
	
	public abstract double calculaPerimetro();

	public Ponto2D[] getPontos() {
		return pontos;
	}

	public void setPontos(Ponto2D[] pontos) {
		this.pontos = pontos;
	}

	public double[] getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(double[] segmentos) {
		this.segmentos = segmentos;
	}
}