package algorithm_m.fourAdapter;

/**
 * 括号匹配
 */
public class ParenMatch {

    public static void main(String[] args) {
        ParenMatch parenMatch=new ParenMatch();
        char[] chars = {'(', '(', ')'};
        boolean match=parenMatch.paren(chars,0,chars.length);
        System.out.println(match);
    }

    public boolean paren(char[] chars,int low,int high){
        MyStack<Character> myStack=new MyStack<>();
        while(low<high){
            if(chars[low]=='('){//遇见左括号，右括号入栈
                myStack.push(chars[low]);
                System.out.println("入栈");
            }else{//遇见右括号
                if(myStack.isEmpty()){//如果栈为空，表示没有与右括号匹配的左括号
                    System.out.println("为空");
                    return false;
                }else{
                    myStack.pop();
                    System.out.println("出栈");
                }
            }
            low++;
        }

        //字符数组遍历完成后，如果栈不为空，则说明没有与左括号对应的右括号
        return myStack.isEmpty()?true:false;
    }
}
