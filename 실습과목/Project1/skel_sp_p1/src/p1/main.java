package p1;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class main {
	public static void main(String[] args) throws IOException {
		
		PrintStream sysout = System.out;
		PrintStream printStream = new PrintStream(new FileOutputStream("log.txt", true)); 
		
		System.out.println("Program start!");
		System.setOut(printStream);

		Manager m = new Manager();
		String[] commands = m.str2commands(m.file2str("command.txt"));
		for (int i = 0; i < commands.length && !m.isEnd; i++) {
			m.run(commands[i]);
		}
        printStream.close();
        
		System.setOut(sysout);
		sysout.println("Program end!");
	}
}
