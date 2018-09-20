package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CircularLinkedList {
	public WordNode pHead; // Circular Linked List Head Pointer

	public CircularLinkedList() {
		this.pHead = null;
	}

	public void Insert(WordNode node) {
		if (this.pHead == null) {
			this.pHead = node;
		} else if (this.pHead.GetNext() == null) {
			this.pHead.SetNext(node);
			node.SetNext(this.pHead);
			this.pHead = node;
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				temp = temp.GetNext();
			}
			node.SetNext(this.pHead);
			temp.SetNext(node);
			this.pHead = node;
		}
	}

	public WordNode Search(String word) {
		WordNode cur = this.pHead;
		if (cur == null) {
			return null;
		} else if (cur.GetNext() == null) {
			if (word.equals(cur.GetWord())) {
				return cur;
			} else {
				return null;
			}
		} else {
			System.out.println(cur.GetWord());
			if (word.equals(cur.GetWord())) {
				return cur;
			} else {
				while (cur.GetNext() != this.pHead) {
					if (word.equals(cur.GetWord())) {
						return cur;
					} else {
						cur = cur.GetNext();
					}
				}
				if (word.equals(cur.GetWord())) {
					return cur;
				} else {
					return null;
				}
			}
		}
	}

	public boolean Print() throws IOException {
		String resultString = "";
		if (this.pHead == null) {
			resultString += ("It is empty.\n");
		} else if (this.pHead.GetNext() == null) {
			resultString += ("word: " + this.pHead.GetWord() + ", mean: " + this.pHead.GetMean() + "\n");
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				resultString += ("word: " + temp.GetWord() + ", mean: " + temp.GetMean() + "\n");
				temp = temp.GetNext();
			}
			resultString += ("word: " + temp.GetWord() + ", mean: " + temp.GetMean() + "\n");
		}
		System.out.print(resultString);
		return true;
	}

	public String toString(String format) {
		
		String resultString = "";
		if (this.pHead == null) {
			resultString += ("");
		} else if (this.pHead.GetNext() == null) {
			resultString += (this.pHead.GetWord() + "\t" + this.pHead.GetMean() + "\n");
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				resultString += (temp.GetWord() + "\t" + temp.GetMean() + "\n");
				temp = temp.GetNext();
			}
			resultString += (temp.GetWord() + "\t" + temp.GetMean() + "\n");
		}
		
		return resultString;
	}
	
	public boolean Save() throws IOException {
		
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("memorized_word.txt");
			out = new ObjectOutputStream(fos);
			out.writeObject((Object)this);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("에러가 발생하였습니다.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("hello world!");
		// Manager manager = new Manager();
		// manager.run("command.txt");

		System.out.println("\n[create list]");
		CircularLinkedList test = new CircularLinkedList();
		test.Print();

		System.out.println("\n[insert apple]");
		WordNode node = new WordNode();
		node.SetWord("apple");
		node.SetMean("사과");
		test.Insert(node);
		test.Print();

		System.out.println("\n[insert banana]");
		node = new WordNode();
		node.SetWord("banana");
		node.SetMean("바나나");
		test.Insert(node);
		test.Print();

		System.out.println("\n[insert cat]");
		node = new WordNode();
		node.SetWord("cat");
		node.SetMean("고양이");
		test.Insert(node);
		test.Print();

		System.out.println("\n[search banana]");
		node = test.Search("apple");
		System.out.println("word: " + node.GetWord() + ", mean: " + node.GetMean());
		test.Print();
		
		test.Save();
		
	}
}
