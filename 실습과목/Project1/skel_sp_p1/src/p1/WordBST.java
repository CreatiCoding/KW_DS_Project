package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WordBST {

	public WordNode root; // Word BST Root

	public WordNode getRoot() {
		return this.root;
	}
	public WordBST() {
		root = null;
	}

	public void Insert(WordNode node) {
		if (root == null) {
			root = node;
		} else {
			
			WordNode tmp = root;

			WordNode target = root, parent = null;
			
			while(target!=null && !target.GetWord().equals(word)) {
				parent = target;
				target = (target.GetWord().compareTo(word)>0) ? target.GetLeft():target.GetRight();
			}
			
			while (true) {
				System.out.println("insert\t"+node.GetWord());
				if (tmp.GetWord().compareTo(node.GetWord()) > 0) {
					if (tmp.GetLeft() != null) {
						tmp = tmp.GetLeft();
					} else {
						tmp.SetLeft(node);
						break;
					}
				} else if (tmp.GetWord().compareTo(node.GetWord()) < 0) {
					if (tmp.GetRight() != null) {
						tmp = tmp.GetRight();
					} else {
						tmp.SetRight(node);
						break;
					}
				} else {
					System.out.println("동일한 단어가 입력되었습니다");
					return;
				}
				return;
			}
		}
	}

	public WordNode Delete(String word) {
		WordNode target = root, parent = null;
		while(target!=null && !target.GetWord().equals(word)) {
			parent = target;
			target = (target.GetWord().compareTo(word)>0) ? target.GetLeft():target.GetRight();
		}
		// not found
		if(target == null) {
			return null;
		}
		// 리프 노드
		if(target.GetLeft() == null && target.GetRight() == null) {
			if(parent == null) {
				root = null;
			}else if(parent.GetLeft() == target) {
				parent.SetLeft(null);
			}else {
				parent.SetRight(null);
			}
		// 왼쪽이 비어있는 노드
		} else if(target.GetLeft() == null) {
			if(parent == null) {
				root = target.GetRight();
			}else if(parent.GetLeft() == target) {
				parent.SetLeft(target.GetRight());
			}else {
				parent.SetRight(target.GetRight());
			}
		// 오른쪽이 비어있는 노드
		} else if(target.GetRight() == null) {
			if(parent == null) {
				root = target.GetLeft();
			}else if(parent.GetLeft() == target) {
				parent.SetLeft(target.GetLeft());
			}else {
				parent.SetRight(target.GetLeft());
			}
		// 둘다 있는 노드
		} else {
			WordNode prevprev = target, prev = target.GetRight(), current = target.GetRight().GetLeft();
			while(current!=null) {
				prevprev = prev;
				prev = current;
				current = current.GetLeft();
			}
			
			target.SetMean(prev.GetMean());
			target.SetWord(prev.GetWord());
			if(prevprev == target) {
				prevprev.SetRight(prev.GetRight());
			}else {
				prevprev.SetLeft(prev.GetRight());
			}
		}
		return target;
	}

	public WordNode Search(String word) {
		

		WordNode target = root, parent = null;
		
		while(target!=null && !target.GetWord().equals(word)) {
			parent = target;
			target = (target.GetWord().compareTo(word)>0) ? target.GetLeft():target.GetRight();
		}
		
		return target;
	}

	public boolean Print() throws IOException {
		Preorder(root);
		return true;
	}

	public boolean Save() throws IOException {
		return false;
	}

	public void Preorder(WordNode node) throws IOException {
		if (node == null)
			return;
		System.out.println("word: " + node.GetWord() +", mean: "+node.GetMean());
		Preorder(node.GetLeft());
		Preorder(node.GetRight());
	}

	public static void main(String[] args) throws IOException {

		WordBST w = new WordBST();
		w.Insert(new WordNode("apple", "사과"));
		w.Insert(new WordNode("banana", "바나나"));
		w.Insert(new WordNode("cat", "고양이"));
		w.Print();
		WordNode root = w.getRoot();
		System.out.println(root.GetWord());
		System.out.println(root.GetRight().GetWord());
		System.out.println(root.GetRight().GetRight().GetWord());
		//System.out.println(root.GetLeft().GetWord());
	}
}
