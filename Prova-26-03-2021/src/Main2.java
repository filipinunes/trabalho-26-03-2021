import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
		public static void main(String[] args) {
			Methods2 teste = new Methods2();
			List<String> teste2 = new ArrayList<>();			
		int opt;
		String endereco = "";
		do {
			String strInput = JOptionPane.showInputDialog("Menu" 
			+ "\n1 - Calcula subrede"
			+ "\n9 - Encerrar"); 
			opt = Integer.parseInt(strInput); 
			switch (opt){
				case 1:
				endereco = JOptionPane.showInputDialog("Endereco de IP"); 

				teste2 = teste.calcSub(endereco);
				System.out.println("Subrede decimal: " + teste2.get(1));
				System.out.println("Subrede binario: " + teste2.get(0));
				break;
			}
		}while(opt!=9);
	}

}
