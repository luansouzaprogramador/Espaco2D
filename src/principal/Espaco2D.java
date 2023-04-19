package principal;

import java.util.ArrayList;

public class Espaco2D {
	private ArrayList<Forma> formas;
	
	public Espaco2D() {
		formas = new ArrayList<>();
	}
	
	public Forma criaForma(Ponto2D[] pontos) {
		Forma forma = Forma.geraForma(pontos);
		return forma;
	}
	
	public boolean adicionaForma(Forma forma) {
		int tamanhoListaAntes = formas.size();
		formas.add(forma);
		int tamanhoListaDepois = formas.size();
		
		if (tamanhoListaAntes == tamanhoListaDepois)
			return false;
		return true;
	}
	
	public String mostraPoligonos() {
		String retorno = "Poligono: ";
		
		System.out.println();
		for (int i=0; i<formas.size(); i++) {
			if (i>0) {
				retorno += "Poligono: ";
			}
			
			if (formas.get(i) instanceof Circulo) {
				retorno += "Circulo";
			} else if (formas.get(i) instanceof Triangulo) {
				retorno += String.format("Triangulo %s", mostraTriangulo(formas.get(i)));
			} else if (formas.get(i) instanceof Quadrado) {
				retorno += "Quadrado";
			} else {
				retorno = null;
			}
			retorno += String.format("%nArea: %.1f%nPerimetro: %.1f%n%n", formas.get(i).calculaArea(), formas.get(i).calculaPerimetro());
		}
		
		return retorno;
	}
	
	public String mostraTriangulo(Forma forma) {
		return ((Triangulo)forma).tipoTriangulo();
	}
	
	public double calculaAreaTotal() {
		double areaTotal=0;
		for(int i=0; i<formas.size(); i++) {
			areaTotal += formas.get(i).calculaArea();
		}
		return areaTotal;
	}
	
	public double calculaPerimetroTotal() {
		double perimetroTotal=0;
		for (int i=0; i<formas.size(); i++) {
			perimetroTotal += formas.get(i).calculaPerimetro();
		}
		return perimetroTotal;
	}

	public ArrayList<Forma> getFormas() {
		return formas;
	}
	
	public void setFormas(ArrayList<Forma> formas) {
		this.formas = formas;
	}
}
