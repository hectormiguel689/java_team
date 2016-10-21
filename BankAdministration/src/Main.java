
public class Main {

	public static LoginDialog loginWindow = new LoginDialog();
	public static boolean accessGranted;
	public static void main(String[] args){
		loginWindow.setVisible(true);
			
		if(accessGranted){
			System.out.println("Here");
			
		}
	}
	public void disposeLoginWindoe(){
		accessGranted = loginWindow.isGranted();
		loginWindow.setVisible(false);
	}
}
