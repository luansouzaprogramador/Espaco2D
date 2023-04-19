package principal;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Espaco2D espaco2D = new Espaco2D();
		Ponto2D[] pontos;
		Ponto2D ponto;
		int opcao;
		
		System.out.println("Seja muito bem-vindo ao sistema Espaço 2D");
		
		do {
			do {
				System.out.print("\nDigite a opcao desejada:\n"
						+ "1 -> Criar Forma\n"
						+ "2 -> Calcular area total\n"
						+ "3 -> Calcular perimetro total\n"
						+ "4 -> Mostrar poligonos criados\n"
						+ "5 -> Sair\n"
						+ "-> ");
				
				opcao = teclado.nextInt();
				if (opcao<1 || opcao>5) {
					System.out.println("Opcao invalida!\n");
				} else {
					switch (opcao) {
					case 1:
						int opcao2;
						do {
							System.out.print("\nDigite a opcao desejada:\n"
									+ "1 -> Circulo (2 pontos)\n"
									+ "2 -> Triangulo (3 pontos)\n"
									+ "3 -> Quadrdado (4 pontos)\n"
									+ "-> ");
							opcao2 = teclado.nextInt()+1;
							if (opcao2-1<1 || opcao2-1>3) {
								System.out.println("Opcao invalida!");
							} else {
								do {
									pontos = new Ponto2D[opcao2];
									
									System.out.println();
									for (int i=0; i<opcao2; i++) {
										System.out.printf("%do ponto%n", i+1);
										System.out.print("X: ");
										double x = teclado.nextDouble();
										System.out.print("Y: ");
										double y = teclado.nextDouble();
										ponto = new Ponto2D(x, y);
										pontos[i] = new Ponto2D(ponto);
									}
									
									if (Forma.geraForma(pontos) == null) {
										System.out.println("Infelizmente, nao foi possivel criar a forma pretendida. Informe os pontos novamente.");
									} else {
										System.out.println("Forma criada com sucesso!");
										espaco2D.adicionaForma(espaco2D.criaForma(pontos));
									}
								} while(Forma.geraForma(pontos) == null);
							}
						} while(opcao2-1<1 || opcao2-1>3);
						
						break;
					case 2:
						System.out.printf("Area total das formas criadas: %.1f%n", espaco2D.calculaAreaTotal());
						break;
					case 3:
						System.out.printf("Perimetro total das formas criadas: %.1f%n", espaco2D.calculaPerimetroTotal());
						break;
					case 4:
		System.out.print(espaco2D.mostraPoligonos());
						break;
					}
				}
			} while (opcao<1 || opcao>5);
		} while(opcao!=5);
		
		
		teclado.close();
	}
}
