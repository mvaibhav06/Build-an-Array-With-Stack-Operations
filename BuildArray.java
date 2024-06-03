import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArray {
    public static List<String> buildArray(int[] target, int n) {
        List<String> out = new ArrayList<>();
        int a = 1;
        int i = 0;
        Stack<Integer> temp = new Stack<>();
        while(i<target.length){
            if(target[i] > a){
                out.add("Push");
                temp.add(a++);
            }else if(target[i] == a){
                while(!temp.isEmpty() && i==0){
                    out.add("Pop");
                    temp.pop();
                }
                if(i==0){
                    out.add("Push");
                    temp.add(a++);
                    i++;
                }else{
                    while(temp.peek() != target[i-1]){
                        out.add("Pop");
                        temp.pop();
                    }
                    out.add("Push");
                    temp.push(a++);
                    i++;
                }
            }

        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4};
        System.out.println(buildArray(nums,4));
    }
}
