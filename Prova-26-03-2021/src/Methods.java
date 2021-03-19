import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Methods {
	//separa o ip em blocos e retorna um array
	public List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<>();
		
		//Separa o IP da mascIP informada pelo usuario;
		StringTokenizer tokenizer = new StringTokenizer(str, "/");
		while (tokenizer.hasMoreElements()) {
			tokens.add(tokenizer.nextToken());
		}
		String IP = tokens.get(0);
		String masc = tokens.get(1);
		//Limpa o array
		tokens.clear();
		
		//Separa o IP em blocos
		StringTokenizer tokenizerIP = new StringTokenizer(IP, ".");
		while (tokenizerIP.hasMoreElements()) {
			tokens.add(tokenizerIP.nextToken());
		}
		
		//Adciona a mascIP no array
		tokens.add(masc);	
		
		return tokens;
	}
	
	//converte o numero IP de decimal para binario
	public String converte(String endereco) {
		List<String> teste = new ArrayList<>();
		teste = getTokens(endereco);
		
		String mascIP = teste.get(4);
		
		String IPconvertido = "";
		
		//Percorre o array pegando somente o IP e converte pra binario
		for(int i=0; i<4;i++) {
			int conv = Integer.parseInt(teste.get(i));
			int conv2 = Integer.parseInt(Integer.toBinaryString(conv));
			if(i==3) {
				IPconvertido = IPconvertido + String.format("%08d", conv2);
			} else {
			IPconvertido = IPconvertido + String.format("%08d.", conv2);
			}
		}	
		return IPconvertido + "/" + mascIP;
	}
	
	//Identifica a mascIP do IP
	public String identMasc(String endereco) {
		String mascIP = endereco.substring(0,2);
		String classe = "";
		if(Integer.parseInt(mascIP) == 0 || Integer.parseInt(mascIP) == 1) {
			classe = "A";
		} else if (Integer.parseInt(mascIP) == 10) {
			classe = "B";
		} else {
			classe = "C";
		}
		return classe;
	}
	
	//verifica se a mascIP informada pelo usuario eh a correta
	public String verifMasc(String endereco) {
		String convert;
		String classe = "Correta.";
		
		convert = endereco.substring(0,2);
		int mascIP = Integer.parseInt(convert);
		convert = endereco.substring(endereco.length()-2,endereco.length());
		int mascUsuario = Integer.parseInt(convert);
		
		if(mascIP == 0 || mascIP == 1) {
			if(mascUsuario == 8) {
				return classe;
			} else {
				return classe = "8";
			}
		} else if (mascIP == 10) {
			if(mascUsuario == 16) {
				return classe;
			} else {
				return classe = "16";
			}
		} else {
			if(mascUsuario == 24) {
				return classe;
			} else {
				return classe = "24";
			}
		}
	}

}
