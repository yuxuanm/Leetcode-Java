package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

public class Q127 {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		String beginWord = "hit";
		String endWord = "cog";
		int res = new Q127().ladderLength(beginWord, endWord, wordList);

		System.out.println(res);
	}

	private int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;

		int len = beginWord.length();

		HashMap<String, ArrayList<String>> all = new HashMap<String, ArrayList<String>>();

		wordList.forEach(word -> {
			for (int i = 0; i < len; i++) {
				String new_word = word.substring(0, i) + "*" + word.substring(i + 1, len);
				ArrayList<String> list = all.getOrDefault(new_word, new ArrayList<String>());
				list.add(word);
				all.put(new_word, list);
			}
		});

		Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
		Q.add(new Pair<String, Integer>(beginWord, 1));

		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		visited.put(beginWord, true);

		while (!Q.isEmpty()) {
			Pair<String, Integer> node = Q.remove();
			String cur_word = node.getKey();
			if (cur_word == endWord)
				return node.getValue();
			int value = node.getValue();
			for (int i = 0; i < len; i++) {
				String new_word = cur_word.substring(0, i) + "*" + cur_word.substring(i + 1, len);
				ArrayList<String> list = all.getOrDefault(new_word, new ArrayList<String>());
				for (String l : list) {
					if (!visited.containsKey(l)) {
						Q.add(new Pair<String, Integer>(l, value + 1));
						visited.put(l, true);
					}
				}
			}

		}
		return 0;
	}
}
//***************************************************************************************
/**
 * Method 1: backtracking (not finished)
 */
//	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		if(wordList.size()==0||!wordList.contains(endWord))
//			return 0;
//		wordList.remove(beginWord);
//		int res = Integer.MAX_VALUE;
//		
//		for (String s : wordList) {
//			if (diffByOne(beginWord, s)) {
//				List<String> tmpWordList = new ArrayList<String>(wordList);
//				tmpWordList.remove(s);
//				int tmpRes = helper(s, endWord, tmpWordList) +1;
//				if (tmpRes != 0)
//					res = tmpRes < res ? tmpRes : res;
//			}
//		}
//
//		return res == Integer.MAX_VALUE ? 0 : res;
//	}
//
//	public int helper(String curWord, String endWord, List<String> wordList) {
//		if (curWord == endWord)
//			return 1;
//		for (String s : wordList) {
//			if (diffByOne(curWord, s)) {
//				wordList.remove(s);
//				return 1 + helper(s, endWord, wordList);
//			}
//
//		}
//		return 0;
//	}
//
//	public boolean diffByOne(String curWord, String matchWord) {
//		int cnt = 0;
//		for (int i = 0; i < curWord.length(); i++) {
//			if (curWord.charAt(i) != matchWord.charAt(i))
//				cnt++;
//		}
//		return cnt == 1;
//	}
