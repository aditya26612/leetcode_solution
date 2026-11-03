// 33 ms | 61.5 MB
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Trie {

    TrieNode root;

    public Trie() {
       root= new TrieNode();

    }
    
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }
    
    public boolean search(String word) {

        TrieNode current=root;

        for(int i=0;i<word.length();i++){

            if( current.children[word.charAt(i)-'a']!=null){
            current=current.children[word.charAt(i)-'a'];
            }
            else{
                return false;
            }

        }

        // if(current.isEnd==true){
        //       return true;  
        //     }

        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode current=root;

        for(int i=0;i<prefix.length();i++){

            // if(i==prefix.length()-1 && current.children[prefix.charAt(i)-'a']!=null){
            //     return true;
            // }

            if( current.children[prefix.charAt(i)-'a']!=null){
            current=current.children[prefix.charAt(i)-'a'];
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */