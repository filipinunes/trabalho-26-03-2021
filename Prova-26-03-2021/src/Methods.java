import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Methods {
	public List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<>();

		StringTokenizer tokenizer = new StringTokenizer(str, ".");
		while (tokenizer.hasMoreElements()) {
			tokens.add(tokenizer.nextToken());
		}
		
		return tokens;
	}
	
	public String converte(String ip) {
		List<String> teste = new ArrayList<>();
		teste = getTokens(ip);
		String convertido = "";
		for(int i=0; i<teste.size();i++) {
			int conv = Integer.parseInt(teste.get(i));
			int conv2 = Integer.parseInt(Integer.toBinaryString(conv));
			if(i==teste.size()-1) {
				convertido = convertido + String.format("%08d", conv2);
			} else {
			convertido = convertido + String.format("%08d.", conv2);
			}
		}	
		return convertido;
	}
	
	public String identMasc(String ip) {
		String mascara = ip.substring(0,2);
		String classe = "";
		if(Integer.parseInt(mascara) == 0 || Integer.parseInt(mascara) == 1) {
			classe = "A";
		} else if (Integer.parseInt(mascara) == 10) {
			classe = "B";
		} else {
			classe = "C";
		}
		return classe;
	
	}

}
