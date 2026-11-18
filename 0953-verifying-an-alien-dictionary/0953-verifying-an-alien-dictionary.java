class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; i++){
            String  sa = words[i];
            String  sb = words[i+1];

            int len = Math.min(sa.length(), sb.length());
            for(int j = 0; j < len; j++){
                if(sa.charAt(j) != sb.charAt(j)){
                    if(map.get(sa.charAt(j))>map.get(sb.charAt(j))){
                        return false;
                    }
                    break;
                }
            }
            if(sa.length() > sb.length() && sa.startsWith(sb)){
                return false;
            }
        }
        return true;
    }
}