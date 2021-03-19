import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Methods2 {
	//separa o endereco em blocos e retorna um array
	public List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<>();
		
		//Separa o endereco em blocos
		StringTokenizer tokenizerIP = new StringTokenizer(str, ".");
		while (tokenizerIP.hasMoreElements()) {
			tokens.add(tokenizerIP.nextToken());
		}
		return tokens;
	}
	
	//converte o numero IP de decimal para binario
	public List<String> converte(String endereco, String mascara) {
		List<String> teste = new ArrayList<>();
		teste = getTokens(endereco);
		List<String> teste2 = new ArrayList<>();
		teste2 = getTokens(mascara);

        List<String> retorno = new ArrayList<>();

		String enderecoBi = "";
        String enderecoDec = "";
		
		//Percorre o array pegando endereco convertendo pra binario
		for(int i=0; i<4;i++) {
			int end = Integer.parseInt(teste.get(i));
            int masc = Integer.parseInt(teste2.get(i));
            
            //multiplica os enderecos em decimal e joga em uma variavel string 
            int and = end & masc;
            if(i==3) {
				enderecoDec = enderecoDec + String.format("%d", and);
			} else {
			enderecoDec = enderecoDec + String.format("%d.", and);
			}

            //multiplica os enderecos em binario e joga em uma variavel string
            int conv2 = Integer.parseInt(Integer.toBinaryString(and));
			if(i==3) {
				enderecoBi = enderecoBi + String.format("%08d", conv2);
			} else {
			enderecoBi = enderecoBi + String.format("%08d.", conv2);
			}
        }

        retorno.add(enderecoBi);
        retorno.add(enderecoDec);

		return retorno;
	}

}
