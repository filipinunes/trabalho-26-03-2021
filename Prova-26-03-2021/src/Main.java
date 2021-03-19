public class Main {
	public void run() {
		Methods teste = new Methods();
		String ip1 = teste.converte("138.0.0.255/08");
		System.out.println(ip1);
		System.out.println(teste.identMasc(ip1));
		System.out.println(teste.verifMasc(ip1));
	}
	public static void main(String[] args) {
		new Main().run();
	}

}
