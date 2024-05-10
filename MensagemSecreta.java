public class MensagemSecreta {
	
	public static void main(String[] args) {
		String msg = "10010110 11110111 01010110 00000001 00010111 00100110 01010111 00000001 00010111 01110110 01010111 00110110 11110111 11010111 01010111 00000011";
		String[] msgSeparada = msg.split(" ");	
		mudaBits(msgSeparada);
		imprimiMsg(msgSeparada);
		
		
	 
		
	}
	
	public static void  mudaBits(String[] msg) {
		
		for(int i=0; msg.length > i; i++) {
			char[] msgAux = msg[i].toCharArray();
			if(msgAux[6] == '0') {
				msgAux[6]='1';
			}else {
				msgAux[6]='0';
			}
			if(msgAux[7]=='0') {
				msgAux[7] = '1';
			}else {
				msgAux[7] = '0';
			}
			
			msg[i] = new String(msgAux);
			
			}		
	}
	
	public static void imprimiMsg(String[] msg) {
		for(int i = 0; msg.length > i; i++) {
			String bitsIniciais = msg[i].substring(0,4);
			String bitsFinais = msg[i].substring(4,8);		
			//passando para inteiro
			int binarioParaInteiro = Integer.parseInt(bitsFinais+bitsIniciais,2);
			
			//imprimi msgDescriptografada
			System.out.print((char)binarioParaInteiro);			
		}
	}

}
