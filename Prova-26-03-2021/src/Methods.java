import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Methods {
		//separa o endereco em blocos e retorna um array
		public List<String> sepTokens(String str) {
			List<String> tokens = new ArrayList<>();
			
			//Separa o IP da mascIP informada pelo usuario;
			StringTokenizer tokenizer = new StringTokenizer(str, "/");
			while (tokenizer.hasMoreElements()) {
				tokens.add(tokenizer.nextToken());
			}
	
			return tokens;
		}
		
		public List<String> getTokens(String tks){
			
			List<String> tokens = new ArrayList<>();
			
			StringTokenizer tokenizerIP = new StringTokenizer(tks, ".");
			while (tokenizerIP.hasMoreElements()) {
				tokens.add(tokenizerIP.nextToken());
			}
			return tokens;
		}
	
	//converte o numero IP de decimal para binario
	public String converte(String endereco) {
		List<String> ipMasc = new ArrayList<>();
		ipMasc = sepTokens(endereco);
		
		List<String> IPList = new ArrayList<>();
		IPList = getTokens(ipMasc.get(0));
		
		String IPconvertido = "";
		
		//Percorre o array pegando somente o IP e converte pra binario
		for(int i=0; i<4;i++) {
			int intIP = Integer.parseInt(IPList.get(i));
			int binIP = Integer.parseInt(Integer.toBinaryString(intIP));
			if(i==3) {
				IPconvertido = IPconvertido + String.format("%08d", binIP);
			} else {
			IPconvertido = IPconvertido + String.format("%08d.", binIP);
			}
		}

		if(endereco.contains("/")){
			IPconvertido += "/" + ipMasc.get(1);
		}	
		return IPconvertido;
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
	public int verifMasc(String endereco) {
		String convert;
		int classe = 0;
		
		convert = endereco.substring(0,2);
		int mascIP = Integer.parseInt(convert);
		convert = endereco.substring(endereco.length()-2,endereco.length());
		if(convert.contains("/")){
			convert = endereco.substring(1,2);
		}
		int mascUsuario = Integer.parseInt(convert);
		
		if(mascIP == 0 || mascIP == 1) {
			if(mascUsuario == 8) {
				return classe;
			} else {
				return classe = 8;
			}
		} else if (mascIP == 10) {
			if(mascUsuario == 16) {
				return classe;
			} else {
				return classe = 16;
			}
		} else {
			if(mascUsuario == 24) {
				return classe;
			} else {
				return classe = 24;
			}
		}
	}

}
