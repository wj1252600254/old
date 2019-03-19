import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 对称的二叉树 {
    public static void main(String[] args) {
        int[] a1=new int[2];
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String a=in.nextLine();
        String[] strings1 = a.split(" ");
        a1[0]=Integer.valueOf(strings1[0]);
        a1[1]=Integer.valueOf(strings1[1]);
        String b=in.nextLine();
        String[] strings = b.split(" ");
        for(String s:strings){
            arr.add(Integer.valueOf(s));
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<a1[0];i++){
            int p=arr.get(i);
            if(p==0){
                set.clear();
            }
            if(set.size()==a1[1]){
                int q=arr.get(i-1);
                for(int j=i;j>=0;j--){
                    if(arr.get(j)==q){
                        System.out.println(i-j+1);
                        return;
                    }
                }
                set.add(p);
            }
        }
    }


}
