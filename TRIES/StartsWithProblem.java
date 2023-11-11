public class StartsWithProblem {
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

    public static boolean search(String key) {
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return curr.eow == true;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";
        String prefix2 = "wom";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startsWith(prefix2));
        System.out.println(startsWith(prefix1));

    }

}
