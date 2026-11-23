class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int fr=0 ; int fc=0 ; int lr=n-1 ; int lc=n-1;
        int count = 1;
        while(fr<=lr && fc<=lc){
            for(int j = fc ; j <= lc ; j ++){
                matrix[fr][j] = count++;
            }
                fr++;
                if(fr>lr || fc>lc){
                    break;
                }
            
                  for(int i = fr ; i <= lr ; i ++){
                matrix[i][lc] = count++;}
                lc--;
                if(fr>lr || fc>lc){
                    break;
                }
            
                  for(int j = lc ; j >= fc ; j --){
                matrix[lr][j] = count++;}
                lr--;
                if(fr>lr || fc>lc){
                    break;
                
            }
                         for(int i = lr ; i >= fr ; i --){
                matrix[i][fc] = count++;}
                fc++;
             
            
        }
        return matrix;
    }
}