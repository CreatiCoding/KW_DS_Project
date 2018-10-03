package p1;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class main {
	public static void main(String[] args) throws IOException {
		
		/**
		 * For saving in log file.
		 * if comment 13, 14, 16, 17, 24, 25, 27, 28 then print contents in console not in log.txt
*/
		 
		PrintStream sysout = System.out;
		PrintStream printStream = new PrintStream(new FileOutputStream("log.txt", true)); 
		
		System.out.println("Program start!");
		System.setOut(printStream);
		Manager m = new Manager();
		// load command then run
		String[] commands = m.str2commands(m.file2str("command.txt"));
		for (int i = 0; i < commands.length && !m.isEnd; i++) {
			m.run(commands[i]);
		}
        printStream.close();
        
		System.setOut(sysout);
		sysout.println("Program end!");
	}
}
