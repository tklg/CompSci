package villa7;

/*import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;*/

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void l(String args) {
		System.out.print(args);
	}
	public void i_l(int args) {
		System.out.print(args);
	}
	//--------------------------
	public void nl(String args) {
		System.out.println(args);
	}
	public void i_nl(int args) {
		System.out.println(args);
	}
	//--------------------------
	public void e(String args) {
		System.err.print(args);
	}
	public void i_e(int args) {
		System.err.print(args);
	}
	//--------------------------
	public void ne(String args) {
		System.err.println(args);
	}
	public void i_ne(int args) {
		System.err.println(args);
	}
  /*public static void main(String[] args) {
    AnsiConsole.systemInstall();

    System.out.println(ansi().fg(RED).a("Hello World").reset());
    System.out.println("My Name is Raman");

    AnsiConsole.systemUninstall();
  }*/
}

