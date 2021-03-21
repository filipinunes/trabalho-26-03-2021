import java.util.ArrayList;
import java.util.List;

public class Main2 {
		public static void main(String[] args) {
			Methods2 teste = new Methods2();
			List<String> teste2 = new ArrayList<>();
			teste2 = teste.converte("199.42.78.133/26");
			System.out.println(teste2.get(0));
			System.out.println(teste2.get(1));
	}

}
