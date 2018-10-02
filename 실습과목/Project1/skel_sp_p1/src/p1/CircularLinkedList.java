package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CircularLinkedList {
	public WordNode pHead; // Circular Linked List Head Pointer
	private int WordCnt;

	public CircularLinkedList() {
		this.pHead = null;
		WordCnt=0;
	}

	public int getCnt() {
		return WordCnt;
	}
	
	public void Delete(String word) {
		if (this.pHead == null) {
			return;
		} else if (this.pHead.GetNext() == this.pHead) {
			if (word.equals(this.pHead.GetWord())) {
				this.pHead = null;
				return;
			}
		} else {
			WordNode target = this.pHead;
			WordNode parent = this.pHead.GetNext();

			// 부모 찾기
			while ((!word.equals(parent.GetNext().GetWord())) && !(parent.GetNext() == this.pHead)) {
				parent = parent.GetNext();
			}
			// 대상 찾기
			target = parent.GetNext();

			if (target == this.pHead) {
				this.pHead = this.pHead.GetNext();
			}
			// 부모의 next는 target의 next 가리킨다.
			parent.SetNext(target.GetNext());

			// target은 null을 가리켜 지운다.
			target = null;

		}
		return;
	}

	public void Insert(WordNode node) {
		if (this.pHead == null) {
			this.pHead = node;
			this.pHead.SetNext(node);
			WordCnt++;
		} else if (this.pHead.GetNext() == this.pHead) {
			this.pHead.SetNext(node);
			node.SetNext(this.pHead);
			WordCnt++;
		} else {
			WordNode temp = this.pHead;
			WordNode parent = this.pHead.GetNext();
			// 부모 찾기
			while (parent.GetNext() != temp) {
				parent = parent.GetNext();
			}
			// 부모 next는 새로운 노드를 가리킨다.
			parent.SetNext(node);
			node.SetNext(this.pHead);
			WordCnt++;
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

		if (this.pHead == null) {
			System.out.println("Empty.");
		} else if (this.pHead.GetNext() == this.pHead) {
			System.out.println(this.pHead.GetWord()+" "+this.pHead.GetMean());
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				System.out.println(temp.GetWord()+" "+temp.GetMean());
				temp = temp.GetNext();
			}
			System.out.println(temp.GetWord()+" "+temp.GetMean());
		}
		return true;
	}

	public String toString() {
		String resultString = "";
		if (this.pHead == null) {
			resultString += ("Empty\n");
		} else if (this.pHead.GetNext() == this.pHead) {
			resultString += (this.pHead.toString() + "\n");
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				resultString += (temp.toString() + "\n");
				temp = temp.GetNext();
			}
			resultString += (temp.toString() + "\n");
		}
		return resultString;
	}

	public boolean Save() throws IOException {
		BufferedOutputStream bos;
		// 쓸 문자열 = 이전 내용 + 작성한 내용
		// 파일 쓰기
		bos = new BufferedOutputStream(new FileOutputStream("memorized_word.txt"));
		bos.write(this.toString().getBytes("utf-8"));
		bos.close();
		return true;
	}

	public static void main(String[] args) throws IOException {

		CircularLinkedList test = new CircularLinkedList();
		test.Print();

		test.Insert(new WordNode("eagle", "독수리"));
		test.Insert(new WordNode("east", "동쪽"));
		test.Insert(new WordNode("eat", "먹다"));
		test.Insert(new WordNode("file", "더미"));
		test.Insert(new WordNode("five", "다섯"));
		test.Insert(new WordNode("fox", "여우"));

		test.Print();

	}
}
