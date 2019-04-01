package top100Test;

import leetcode.topic100.longestPalindrome.isPalindrome;

public class IsPalindromeTest {

    @org.junit.Test
    public void test1() throws Exception {
        isPalindrome.isPalindrome1("aba");
        isPalindrome.isPalindrome1("abba");
    }

    @org.junit.Test
    public void test2() throws Exception {
        isPalindrome.isPalindrome2("aba");
        isPalindrome.isPalindrome2("abba");
        isPalindrome.isPalindrome2("acba");
    }





}
