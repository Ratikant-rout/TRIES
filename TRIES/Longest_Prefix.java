//STILL ERRROR IN THIS CODE//
public class Longest_Prefix {
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
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eow = true;
    }

    public static String ans = "";

    public static void LongestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 25; i > 0; i--) {
            if (root.Children[i] != null && root.Children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                LongestWord(root.Children[i], temp);
                temp.deleteCharAt(temp.length() - 1); // Use deleteCharAt to remove the last character
            }
        }
    }

    public static void main(String args[]) {
        String words[] = { "a", "banana", "app", "appl", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        LongestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
