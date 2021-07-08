public class Q73SetMatrixZeros{
    /**
     * Method 1: Iteration
     * two for loops
     */
    public void setZeroes(int[][] matrix) {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(matrix[i][j]==0){
                    if(map.containsKey(i))
                        map.get(i).add(j);
                    else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(j);
                        map.put(i, list);
                    }
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            for (int i:list)
                helper(key, i, matrix);
        }
    }

    private void helper(int row, int col, int [][] matrix){
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(i==row || j == col)
                    matrix[i][j]=0;
                else
                    continue;
            }
        }
    }
}