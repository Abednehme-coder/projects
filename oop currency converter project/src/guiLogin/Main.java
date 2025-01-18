package guiLogin;

public class Main {

	public static void main(String[] args) {
		Dollar Dl = new Dollar(1,89500,0.93830642);
		
		LL Ll = new LL(1,0.00001086795,0.000010197467);
		
		Euro Eu = new Euro(1,97803.965,1.0657499);
		
		Gold Gl = new Gold (2397.69,0.0004174622);
		
		Oil Ol = new Oil (87.39,0.56);
		
		Silver Sl = new Silver (28.78,0.0347672088);
		
		new Menu(Dl,Ll,Eu,Gl,Ol,Sl);
	}

}	
