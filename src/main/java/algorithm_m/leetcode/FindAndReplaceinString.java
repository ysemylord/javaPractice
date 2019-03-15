package algorithm_m.leetcode;

public class FindAndReplaceinString {
    public static void main(String[] args) {

    }

    private static void replace(String originString,int index,String souce,String replaceStr){

        boolean contain=true;
        for (int i = 0; i <souce.length() ; i++) {
            if(souce.charAt(i)!=originString.charAt(index+0)){
                contain=false;
                break;
            }
        }

        if(true){
           // originString.
        }

    }
}
