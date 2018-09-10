package dijkstra;

import javax.swing.JOptionPane;

public class Dijkstra {
	public static void main(String args[]) {
		int D[][] = new int[100][100];
		int DA[] = new int[100];
		int Ant[] = new int[100];
		boolean ExpA[] = new boolean[100];
		int N, Origem, Destino, i, j, C, NovaDA, Min;
		//N = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de cidades)) Teste;
		N = 6;
		for(i=0;i<N;i++) {
			for(j=0;j<N;j++) {
				D[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite a distancia da cidade "+i+" at� "+j+":"));
			}
		}
		Origem = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de origem"));
		Destino = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de destino"));
		for(i=0; i<N; i++) {
			ExpA[i] = false;
			DA[i] = 10000;
		}
		C = Origem;
		DA[C] = 0;
		while((C != Destino) && (C!=-1)) {
			for(i=0;i<N;i++) { //Expansao de C
				if ((D[C][i] != 0)&&(!ExpA[i])) {
					NovaDA = DA[C] + D[C][i];
					if (NovaDA < DA[i]) {
						DA[i] = NovaDA;
						Ant[i] = C;
					}
				}
			}
			ExpA[C] = true;
			//Determinacao do Proximo C
			Min = 10000;
			C = -1;
			for(i=0;i<N;i++) {
				if( (!ExpA[i]) && (DA[i] < Min)) {
					Min = DA[i];
					C = i;
				}
			}
		}
		if (C == Destino) {
			String saida = "Caminho mais curto de " + Origem
					+ " ate o destino " + Destino + "\n";
			saida = saida + Destino + "\n";
			while (C != Origem) {
				C = Ant[C];
				saida = saida + C + "\n";
			}
			JOptionPane.showMessageDialog(null, saida);
		} else {
			JOptionPane.showMessageDialog(null, "Nao existe caminho entre as cidades");
		}
	}
}