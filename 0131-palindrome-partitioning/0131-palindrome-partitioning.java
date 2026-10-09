class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        solve(s, 0, "", ans, new ArrayList<>());

        return ans;
    }

    public void solve(String s, int idx, String temp,
                      List<List<String>> ans, List<String> list) {

        if (idx == s.length()) {
            if (temp.isEmpty()) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = idx; i < s.length(); i++) {

            temp += s.charAt(i);

            if (isPalindrome(temp)) {

                list.add(temp);

                solve(s, i + 1, "", ans, list);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
