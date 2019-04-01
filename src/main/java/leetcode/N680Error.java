package leetcode;

public class N680Error {


    /**
     * 错误 因为一下方法可能会删除左边一个暂时成功后，之后出错
     *                  而删除右边一个就成功了。
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        boolean isPalindrome = true;
        System.out.println(s.length());
        int head = 0, tail = s.length() - 1;
        boolean skiped=false;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                if(!skiped){
                    head++;
                    if(head<=tail&&s.charAt(head) != s.charAt(tail)){
                        head--;
                        tail--;
                        if(head<=tail&&s.charAt(head) != s.charAt(tail)){
                            isPalindrome = false;
                            break;
                        }else{

                            System.out.println("skip tail"+"---"+tail+":"+s.charAt(tail));
                        }
                    }else{
                        System.out.println("skip head"+"---"+head+":"+s.charAt(head));
                    }
                    skiped=true;
                }else{
                    isPalindrome = false;
                    break;
                }
            }else{
            }
            head++;
            tail--;
        }
        System.out.println((head)+"--"+(tail));
        System.out.println(s.charAt(head)+"--"+s.charAt(tail));
        System.out.println(s + " is palindrome : " + isPalindrome);
        return isPalindrome;
    }

}
