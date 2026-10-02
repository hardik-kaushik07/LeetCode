class Solution {
    public void generate(int n , int l , int r , List<String> ans , String s){
        if(r==n){ans.add(s); return;}
        if(l<n){generate(n,l+1,r,ans,s+"(");}
        if(r<l){generate(n,l,r+1,ans,s+")");}
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0,0,ans,"");
        return ans;
    }
}