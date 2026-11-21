class Solution {
    class Pair{
        String word;
        int steps;
        public Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(q.size()>0){
            Pair front = q.poll();
            String word = front.word;
            int steps = front.steps;
            if(word.equals(endWord)){
                return steps;
            }
            char[] arr = new char[word.length()];
            for(int i = 0; i < word.length(); i++){
                arr[i] = word.charAt(i);
            }

            for(int i = 0; i < arr.length; i++){
                char original = arr[i];
                for(char ch= 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, steps+1));
                        set.remove(word);
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}