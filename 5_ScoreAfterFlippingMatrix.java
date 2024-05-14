class Solution {
    public int matrixScore(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
        }

        for(int j=1;j<m;j++){
            int nz=0;
            int no=0;
            for(int i=0;i<n;i++){
                if(grid[i][j]==0)nz++;
                else no++;
            }
            if(nz>no){
                //flip
                for(int i=0;i<n;i++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }

            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
         int x=1;
        for(int k=m-1;k>=0;k--){
            sum+=grid[i][k]*x;
            x=x*2;
        }
     
    }

    return sum;
    }
}
