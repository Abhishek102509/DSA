class Solution {
    public int fib(int n) {
        double magicNo = ((1 + Math.sqrt(5))/2);
        double no = ((1-Math.sqrt(5))/2);
        return (int)((Math.pow(magicNo,n) - Math.pow(no,n))/Math.sqrt(5));
    }
}