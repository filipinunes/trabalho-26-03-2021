import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Methods endIP = new Methods();

		int opt;
		String endereco = "";
		do {
			String strInput = JOptionPane.showInputDialog("Menu" 
			+ "\n1 - Converte IP/identifica mascara"
			+ "\n2 - Converte IP/verifica mascara"
			+ "\n9 - Encerrar"); 
			opt = Integer.parseInt(strInput); 
			switch (opt){
				case 1:
				endereco = JOptionPane.showInputDialog("Endereco de IP"); 

				System.out.println("IP binario: " + endIP.converte(endereco));
				System.out.println("Classe padrao: " + endIP.identMasc(endIP.converte(endereco)));
				break;

				case 2:
				endereco = JOptionPane.showInputDialog("Endereco de IP com mascara"); 
				System.out.println("IP binario: " + endIP.converte(endereco));
				if(endIP.verifMasc(endereco) == 0){
					System.out.println("A mascara informada pelo usuario esta correta");
				} else {
					System.out.println("A mascara correta para este endereco eh: " + endIP.verifMasc(endIP.converte(endereco)));
				}

				break;
			}
		}while(opt!=9);
	}
}
