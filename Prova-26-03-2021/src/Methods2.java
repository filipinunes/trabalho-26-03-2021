import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Methods2 {
	//separa o endereco em blocos e retorna um array
	public List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<>();
		
		String IP = str;
		String masc = "";
		if(str.contains("/")){
			//Separa o IP da mascIP informada pelo usuario;
			StringTokenizer tokenizer = new StringTokenizer(str, "/");
			while (tokenizer.hasMoreElements()) {
				tokens.add(tokenizer.nextToken());
			}
			IP = tokens.get(0);
			masc = tokens.get(1);
			//Limpa o array
			tokens.clear();
		}

		
		//Separa o IP em blocos
		StringTokenizer tokenizerIP = new StringTokenizer(IP, ".");
		while (tokenizerIP.hasMoreElements()) {
			tokens.add(tokenizerIP.nextToken());
		}
		
		//Adciona a mascIP no array
		if(str.contains("/")){
			tokens.add(masc);	
		}
		
		return tokens;
	}
	
	//converte o numero IP de decimal para binario
	public List<String> converte(String endereco) {
		List<String> teste = new ArrayList<>();
		teste = getTokens(endereco);


		String mascara = convMasc(Integer.parseInt(teste.get(4)));
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

	public String convMasc(int masc){
		int cont = 0;
		String endDec = "";
		String endBin = "";
		for(int i=0; i<4;i++){
			for(int j=0; j<8;j++){
				if(cont < masc){
					endBin += "1";
					cont ++;
				} else {
				endBin += "0";
				}
			}
			endDec += Integer.valueOf(Integer.parseInt(endBin, 2));
			if(i<3){
				endDec += ".";
			}
			endBin = "";
		}
		return endDec;

	}

}
