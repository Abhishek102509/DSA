class Solution {
    public int maxSubArray(int[] nums) {
       int maxSum =Integer.MIN_VALUE;
       int curr = 0;
       for(int n : nums){
         curr +=n;
        maxSum =Math.max(maxSum,curr);
        if(curr<0)
        {
            curr=0;
        } 
       
       }
       return maxSum;
} 
}




// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = Integer.MIN_VALUE;
       
//        for(int i=0; i<nums.length;i++){
//         int currSum = 0;
//         for(int j =i;j<nums.length;j++){
//             currSum = currSum+nums[j];
//             maxSum = Math.max(currSum,maxSum);

//         }
//        }
//     return maxSum;
//     }
// } 