//$Id$
package by.tarif.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoComplete {
	private TrieNode root;
	public int count;
	public AutoComplete() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
	
	public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
		for(String s: input){
			add(root, s);
		}
		ArrayList<String> res = search(root, word);
		if(res!=null){
			for(String str : res){
			System.out.println(str);
		}
		}
    }

	public ArrayList<String> search(TrieNode root, String word){
		if(root==null){
			return null;
		}
		TrieNode temp = root.children[word.charAt(0)-'a'];
		if(temp == null){
			return null;
		}
		if(word.length()==1){
			ArrayList<String> ans = new ArrayList<>();
			getList(temp,ans,temp.data+"");
			return ans;
		}
		return search(temp, word.substring(1));
	}

	public void getList(TrieNode root, ArrayList<String> ans, String output){
			if(root==null){
				return;
			}
			output = output + root.data;
			if(root.isTerminating){
				ans.add(output);
			}
			for(int i=0;i<root.children.length; i++){
				getList(root.children[i], ans, output);
			}
	}
	class TrieNode{
		char data;
		boolean isTerminating;
		TrieNode children[];
		int childCount;

		public TrieNode(char data) {
			this.data = data;
			isTerminating = false;
			children = new TrieNode[26];
			childCount = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<n;i++) {
			String str = s.nextLine();
			list.add(str);
		}
		String word = s.nextLine();
		AutoComplete ac = new AutoComplete();
		ac.autoComplete(list, word);
	}

}
