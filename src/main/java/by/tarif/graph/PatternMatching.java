//$Id$
package by.tarif.graph;

import java.util.ArrayList;

public class PatternMatching {

	private TrieNode root;
	public int count;
	public PatternMatching() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}


	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
		for(String s : vect){
			for(int i=0;i<s.length();i++){
				s=s.substring(i);
				addWord(s, this.root);
			}
		}
		return search(root, pattern);
	}

	public void addWord(String word, TrieNode root){
		if(word == null || word.length() == 0){
			return;
		}
		char c = word.charAt(0);
		TrieNode temp = root.children[c-'a'];
		if(temp == null){
			temp = new TrieNode(c);
			root.children[c-'a'] = temp;
		}
		addWord(word.substring(1), temp);
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

}
