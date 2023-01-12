import java.util.Stack;

/**
 * @author Stephen Connelly
 * sjc2235
 * Programming Assignment 2 - Recursion exercises
 * COMS W3134
 *
 */
public class Recursion {
    static StringBuilder str = new StringBuilder();
    /**
     * Returns the value of x * y, computed via recursive addition.
     * x is added y times. Both x and y are non-negative.
     * @param x  non-negative integer multiplicand 1
     * @param y  non-negative integer multiplicand 2
     * @return   x * y
     */
    public static int recursiveMultiplication(int x, int y){
        if(y==0 || x==0){
            return 0;
        }
        if(y == 1){
            return x;
        }else{
            return x + recursiveMultiplication((x),(y-1));
        }
    }
    /**
     * Reverses a string via recursion.
     *
     * @param s the non-null string to reverse
     * @return a new string with the characters in reverse order
     */
    public static String reverse(String s) {

        if (s.length() == 0){
            String string = str.toString();
            return string;
        }else{
            str.append(s.charAt(s.length()-1));
            return reverse(s.substring(0, s.length()-1));
        }
    }
    private static int maxHelper(int[] array, int index, int max) {
        if(array.length == 1){
            return array[index];
        }
        if (index+1 > array.length-1) {
            return max;
        }else {
            if (array[index] < array[index + 1]) {
                max = array[index + 1];
            }
            index++;
            return maxHelper(array, index, max);
        }
    }
    /**
     * Returns the maximum value in the array.
     * Uses a helper method to do the recursion.
     * @param array  the array of integers to traverse
     * @return       the maximum value in the array
     */
    public static int max(int[] array) {
        return maxHelper(array, 0, Integer.MIN_VALUE);
    }

    /**
     * Returns whether a string is a palindrome, a string that is
     * the same both forward and backward.
     * @param s  the string to process
     * @return   a boolean indicating if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0, length = s.length(), mid = length / 2;
        char letter;
        while(i<mid){
            stack.push(s.charAt(i));
            i++;
        }
        if(length % 2 == 0){}else{
            i = i+1;
        }
        while(!stack.isEmpty()){
            letter = stack.peek();
            stack.pop();
            if(letter == s.charAt(i) || (int) letter == (int) s.charAt(i)){}else{
                return false;
            }
            i++;
        }
        return true;
    }
    private static boolean memberHelper(int key, int[] array, int index){
        if(index < array.length){
            if (key == array[index]){
                return true;
            }else{
                index = index+1;
                return memberHelper(key, array, index);
            }
        }
        return false;
    }
    /**
     * Returns whether or not the integer key is in the array of integers.
     * Uses a helper method to do the recursion.
     * @param key    the value to seek
     * @param array  the array to traverse
     * @return       a boolean indicating if the key is found in the array
     */
    public static boolean isMember(int key, int[] array) {
        return memberHelper(key, array, 0);
    }
    /**
     * Returns a new string where identical chars that are adjacent
     * in the original string are separated from each other by a tilde '~'.
     * @param s  the string to process
     * @return   a new string where identical adjacent characters are separated
     *           by a tilde
     */
    public static String separateIdentical(String s) {
        if(s.length() == 0){
            return s;
        }
        if(s.length() == 1 ){ //stops recursion before index error
            str.append(s.charAt(0)); //adds remaining at index 0 char to str.
            str.reverse();
            String string1 = str.toString();
            return string1;
        }else{
            if(s.charAt(s.length()-1) == s.charAt(s.length()-2)){
                str.append(new char[]{s.charAt(s.length()-1),'~'});
                return separateIdentical(s.substring(0, s.length()-1));
            }else{
                str.append(s.charAt(s.length()-1));
                return separateIdentical(s.substring(0, s.length() - 1));
            }
        }
    }
}
