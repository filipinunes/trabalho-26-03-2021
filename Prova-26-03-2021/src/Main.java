import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Methods teste = new Methods();
		String ip1 = teste.converte("138.0.0.255/08");
		System.out.println(ip1);
		System.out.println(teste.identMasc(ip1));
		System.out.println(teste.verifMasc(ip1));

		int opt;
		String strMatricula = JOptionPane.showInputDialog("Endereco IP");
		int intMatricula = Integer.parseInt(strMatricula);

		String strIdade = JOptionPane.showInputDialog("Idade");
		float floatIdade = Float.parseFloat(strIdade);

		String strSetor = JOptionPane.showInputDialog("Setor");
		int intSetor = Integer.parseInt(strSetor);

		teste.inserir(intMatricula, floatIdade, intSetor);

	}
}
