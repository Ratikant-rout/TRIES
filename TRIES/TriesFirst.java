import java.util.*;

public class TriesFirst {
    static class Node {
        Node Children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String arr[] = { "i", "Like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
