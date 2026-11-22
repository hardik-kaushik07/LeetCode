class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i)!='A' && str.charAt(i)!='a' && str.charAt(i)!='E'
            && str.charAt(i)!='e' && str.charAt(i)!='I' && str.charAt(i)!='i'
            && str.charAt(i)!='O' && str.charAt(i)!='o' && str.charAt(i)!='U' && str.charAt(i)!='u'){
                i++;
                continue;
            }
            if(str.charAt(j)!='A' && str.charAt(j)!='a' && str.charAt(j)!='E'
            && str.charAt(j)!='e' && str.charAt(j)!='I' && str.charAt(j)!='i'
            && str.charAt(j)!='O' && str.charAt(j)!='o' && str.charAt(j)!='U' && str.charAt(j)!='u'){
                j--;
                continue;
            }

            char ch = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, ch);
            i++; j--;
        }
        return str.toString();
    }
}