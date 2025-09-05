class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> answer = new ArrayList<>();
         
         int top=0, left =0, right = m-1,bottom = n-1;

         while(top<=bottom && left<=right){
            for(int i =left; i<=right; i++){
                answer.add(matrix[top][i]);
            }
            top++;
            for(int i =top; i<=bottom; i++){
                answer.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left;i--){
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i =bottom; i>=top; i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
         }
         return answer;
    }
}