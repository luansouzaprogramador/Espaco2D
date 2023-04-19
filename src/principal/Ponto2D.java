package principal;

public class Ponto2D {
	private double x;
	private double y;
	
	public Ponto2D() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Ponto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto2D(Ponto2D ponto) {
		this.x = ponto.getX();
		this.y = ponto.getY();
	}
	
	public double calculaDistancia(Ponto2D ponto) {
		return Math.sqrt(Math.pow(x - ponto.getX(), 2) + Math.pow(y - ponto.getY(), 2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
