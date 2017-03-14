import java.io.*;
import java.lang.*;

public class Main{
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		File arquivoDeSaida = new File("saida.txt");
		FileOutputStream fos = new FileOutputStream(arquivoDeSaida);
		
		String entrada = "";
		String saida = "";
		int qtdParentesesAbertos = 0;
		int i = 0;
		_1:
		while((entrada = br.readLine()) != null){
			i++;
			char[] expressao = entrada.toCharArray();
			
			for(int j = 0; j < expressao.length; j++){
				switch(expressao[j]){
					case '(':
						qtdParentesesAbertos++;
						break;
					case ')':
						qtdParentesesAbertos--;
						break;
				}
				if(qtdParentesesAbertos < 0){
					saida += "incorrect\r\n";
					qtdParentesesAbertos=0;
					continue _1;
				}
			}
			if(qtdParentesesAbertos == 0){
					saida += "correct\r\n";
			}
			else{
				saida += "incorrect\r\n";
			}
			qtdParentesesAbertos=0;
		}
		fos.write((i + "\n").getBytes());
		fos.write(saida.getBytes());
		fos.close();
	}
}