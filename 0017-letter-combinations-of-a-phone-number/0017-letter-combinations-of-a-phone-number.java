class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {" ", " ", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();

        solve(digits, mapping, ans, "", 0);
        return ans;
    }
    public void solve(String digits, String[] mapping, List<String> ans, String s, int idx){

        if(idx == digits.length()){
            ans.add(s);
            return;
        }
        int  val = digits.charAt(idx) - '0';
        String map = mapping[val];

        for(int  i = 0; i < map.length(); i++){

            s += map.charAt(i);

            solve(digits, mapping, ans, s, idx+1);

            s = s.substring(0, s.length()-1);
        }

    }
}