package p1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Manager {

	public CircularLinkedList cll; // MEMORIZED Circular Linked List
	public AlphabetBST bst; // MEMORIZING BST
	public Queue queue; // TO_MEMORIZE Queue
	public String cmd; // command
	public boolean isEnd;
	public Manager() {
		cll = new CircularLinkedList();
		bst = new AlphabetBST();
		queue = new Queue();
		cmd = "";
		isEnd = false;
	}
	public String printError(int Code) {
		return "";
	}
	
	public String file2str(String fileName) {
		BufferedInputStream bis;
		// 이어 쓰기를 위한 파일 읽기
		StringBuffer pre_contents = new StringBuffer("");
		try {
			bis = new BufferedInputStream(new FileInputStream(fileName));
			byte buffer[] = new byte[1024];
			while ((bis.read(buffer)) != -1) {
				pre_contents.append(new String(buffer, "utf-8"));
			}
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre_contents.toString();
	}

	public String[] str2commands(String contents) {
		String[] line = contents.split("\n");
		return line;
	}

	public CircularLinkedList str2Cll(String contents) {
		CircularLinkedList cll = new CircularLinkedList();
		String[] line = contents.split("\n");
		for (int i = 0; i < line.length - 1; i++) {
			String[] token = line[i].split("\t");
			if (!token[0].equals("w"))
				break;
			cll.Insert(new WordNode(token[1], token[2]));
		}
		return cll;
	}

	public Queue str2Queue(String contents) {
		Queue queue = new Queue();
		String[] line = contents.split("\n");
		for (int i = 0; i < line.length - 1; i++) {
			String[] token = line[i].split("\t");
			if (!token[0].equals("w"))
				break;
			queue.Push(new WordNode(token[1], token[2]));
		}
		return queue;
	}

	public WordBST str2WordBST(String contents) {
		WordBST result = new WordBST();
		String[] line = contents.split("\n");
		for (int i = 0; i < line.length - 1; i++) {
			String[] token = line[i].split("\t");
			if (!token[0].equals("w"))
				break;
			result.Insert(new WordNode(token[1], token[2]));
		}
		return result;
	}

	public AlphabetBST str2AlphabetBST(String contents) {
		AlphabetBST result = new AlphabetBST();

		String[] line = contents.split("\n");
		char index = '\0';
		for (int i = 0; i < line.length - 1; i++) {
			String[] token = line[i].split("\t");
			if (token[0].equals("a")) {
				index = token[1].charAt(0);
			} else if (token[0].equals("w") && (index != '\0')) {
				result.Search(index).GetBST().Insert(new WordNode(token[1], token[2]));
			} else {
				break;
			}
		}

		return result;
	}

	public void run(String command) throws IOException {
		String[] split = command.trim().split(" ");
		this.cmd = command.trim();

		if (split[0] == null || "".equals(split[0])) {
			return;
		}

		switch (split[0].charAt(0)) {
		case 'L':
			if ("LOAD".equals(split[0])) {
				if (this.LOAD()) {
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Success");
				} else {
					System.out.println("======== ERROR ========");
					System.out.println("100");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'A':
			if ("ADD".equals(split[0])) {
				if (this.ADD()) {
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Success");
				} else {
					// 에러 200
					System.out.println("======== ERROR ========");
					System.out.println("200");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'M':
			if ("MOVE".equals(split[0])) {
				if (this.MOVE()) {
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Success");
				} else {
					System.out.println("======== ERROR ========");
					System.out.println("300");
				}

				System.out.println("=======================\n");
			}
			break;
		case 'S':
			if ("SAVE".equals(split[0])) {
				if(this.SAVE()) {
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Success");
				} else {
					// 에러 100
					System.out.println("======== ERROR ========");
					System.out.println("400");
				}
				System.out.println("=======================\n");
			} else if ("SEARCH".equals(split[0])) {
				if(!this.SEARCH()) {
					System.out.println("======== ERROR ========");
					System.out.println("600");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'T':
			if ("TEST".equals(split[0])) {
				if(this.TEST()) {
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Pass");
				}else {
					System.out.println("======== ERROR ========");
					System.out.println("500");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'P':
			if ("PRINT".equals(split[0])) {
				if(!this.PRINT()) {
					System.out.println("======== ERROR ========");
					System.out.println("700");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'U':
			if ("UPDATE".equals(split[0])) {

				if (!this.UPDATE()) {
					System.out.println("======== ERROR ========");
					System.out.println("300");
				}
				System.out.println("=======================\n");
			}
			break;
		case 'E':
			if ("EXIT".equals(split[0])) {
				if (split.length < 2 || split[1] == null || "".equals(split[1])) {
					// 코드 작성
					System.out.println("======== " + split[0] + " ========");
					System.out.println("Success");
					System.out.println("=======================\n");
					isEnd = true;
				} else {
					System.out.println("======== ERROR ========");
					System.out.println("0");
					System.out.println("=======================\n");
				}
			}
			break;
		default:
			break;
		}
	}

	public boolean LOAD() throws IOException {
		String[] split = this.cmd.split(" ");
		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			// TO DO
			// Exception for not existing file.
			if (!(new File("to_memorize_word.txt").exists()) || !(new File("memorizing_word.txt").exists())
					|| !(new File("memorized_word.txt").exists())) {
				return false;
				// Exception for not empty data structure.
			} else if (!this.queue.isEmpty() || (bst.getCnt() != 0) || (bst.getCnt() != 0)) {
				return false;
				// Do The Command
			} else {
				this.queue = this.str2Queue(this.file2str("to_memorize_word.txt"));
				this.bst = this.str2AlphabetBST(this.file2str("memorizing_word.txt"));
				this.cll = this.str2Cll(this.file2str("memorized_word.txt"));
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean ADD() throws IOException {
		String[] split = this.cmd.split(" ");
		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			// Exception for not existing file.
			if (!(new File("word.txt").exists())) {
				return false;
				// Do The Command
			} else {
				String contents = this.file2str("word.txt");
				String[] words = contents.trim().split("\n");
				// Exception for not empty file.
				if (words[0].equals("")) {
					return false;
				} else {
					for (int i = 0; i < words.length; i++) {
						String[] word = words[i].split("\t");
						if (queue.Search(word[0]) == null)
							queue.Push(new WordNode(word[0], word[1]));
						else
							continue;
					}
					return true;
				}
			}
		} else {
			// 에러 200
			return false;
		}
	}

	public boolean MOVE() {
		String[] split = this.cmd.split(" ");
		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			// 에러 300
			return false;
		} else {
			try {
				int num = Integer.parseInt(split[1]);
				// 1 memorizing number overflow than 100;
				// 2 to memorize word is empty
				// 3 not enough words in 'to memorize word'
				if ((num + bst.getCnt() > 100) || queue.isEmpty() || num > queue.getCnt()) {
					return false;
				} else {
					// 코드 작성
					for (int i = 0; i < num; i++) {
						WordNode temp = queue.Pop();
						bst.InsertWord(temp);
					}
					return true;
				}
			} catch (NumberFormatException e) {
				// 에러 300
				return false;
			}
		}
	}

	public boolean SAVE() throws IOException {
		String[] split = this.cmd.split(" ");
		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			// Exception for not existing file.
			if (!(new File("to_memorize_word.txt").exists()) || !(new File("memorizing_word.txt").exists())
					|| !(new File("memorized_word.txt").exists())) {
				return false;
			} else {
				// 코드 작성
				if(	this.queue.Save() && this.bst.Save() && this.cll.Save() )
					return true;
				else
					return false;
			}
		} else {
			return false;
		}
	}

	public boolean TEST() {
		String[] split = this.cmd.split(" ");
		// Error 500
		if (split.length < 3 || split[1] == null || "".equals(split[1]) || split[2] == null
				|| "".equals(split[2])) {
			return false;
			// Error 500
		} else {
			AlphabetNode temp = bst.Search(split[1].toUpperCase().charAt(0));
			// Not Found Error
			if (temp == null || temp.GetBST() == null || temp.GetBST().Search(split[1]) == null) {
				return false;
				// Found But Not Correct
			} else if (!split[2].equals(temp.GetBST().Search(split[1]).GetMean())) {
				return false;
			} else {
				WordNode target = temp.GetBST().Delete(split[1]);
				this.cll.Insert(target);
				return true;
			}
		}
	}

	public boolean SEARCH() throws IOException {
		String[] split = this.cmd.split(" ");

		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			// 에러 100
			return false;
		} else {
			// 코드 작성
			if (queue.Search(split[1]) != null) {
				System.out.println("======== " + split[0] + " ========");
				System.out.println(split[1] + " " + queue.Search(split[1]).GetMean());
			} else if (cll.Search(split[1]) != null) {
				System.out.println("======== " + split[0] + " ========");
				System.out.println(split[1] + " " + cll.Search(split[1]).GetMean());
			} else if (bst.Search(split[1].toUpperCase().charAt(0)) == null) {
				// 못찾
				return false;
			} else if (bst.Search(split[1].toUpperCase().charAt(0)).GetBST() == null) {
				// 못찾
				return false;
			} else if (bst.Search(split[1].toUpperCase().charAt(0)).GetBST().Search(split[1]) == null) {
				// 못찾
				return false;
			} else {
				String mean = bst.Search(split[1].toUpperCase().charAt(0)).GetBST().Search(split[1]).GetMean();
				System.out.println("======== " + split[0] + " ========");
				System.out.println(split[1] + " " + mean);
			}
		}
		return true;
	}

	public boolean PRINT() throws IOException {
		String[] split = this.cmd.split(" ");

		if (split.length < 2 || split[1] == null || "".equals(split[1])) {
			return false;
		} else {
			if ("TO_MEMORIZE".equals(split[1])) {
				if (split[2] != null) {
					return false;
				} else {
					System.out.println("======== " + split[0] + " ========");
					this.queue.Print();
					return true;
				}
			} else if ("MEMORIZED".equals(split[1])) {
				if (split.length == 3 && split[2] != null) {
					return false;
				} else if(this.cll.getCnt() == 0){
					return false;
				}else {
					System.out.println("======== " + split[0] + " ========");
					this.cll.Print();
					return true;
				}
			} else if ("MEMORIZING".equals(split[1])) {
				System.out.println("======== " + split[0] + " ========");
				this.bst.Print();
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean UPDATE() throws IOException {
		String[] split = this.cmd.split(" ");
		// Error 500
		if (split.length < 3 || split[1] == null || "".equals(split[1]) || split[2] == null
				|| "".equals(split[2])) {
			return false;
			// Error 500
		} else {
			// 코드 작성
			WordNode temp;
			if (queue.Search(split[1]) != null) {
				temp = queue.Search(split[1]);
			} else if (cll.Search(split[1]) != null) {
				temp = cll.Search(split[1]);
			} else if (bst.Search(split[1].toUpperCase().charAt(0)) == null) {
				// 못찾
				System.out.println(1);
				return false;
			} else if (bst.Search(split[1].toUpperCase().charAt(0)).GetBST() == null) {
				// 못찾
				System.out.println(2);
				return false;
			} else if (bst.Search(split[1].toUpperCase().charAt(0)).GetBST().Search(split[1]) == null) {
				// 못찾
				System.out.println(3);
				return false;
			} else {
				temp = bst.Search(split[1].toUpperCase().charAt(0)).GetBST().Search(split[1]);
			}
			System.out.println("======== " + split[0] + " ========");
			System.out.println(split[1] + " " + temp.GetMean() + " -> " + split[2]);
			temp.SetMean(split[2]);
			return true;
		}
	}
}
