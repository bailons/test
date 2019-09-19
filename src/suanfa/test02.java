package suanfa;

/**
 *     *
 *    ***
 *   *****
 *  *******
 *   *****
 *    ***
 *     *
 **/
public class test02 {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            for(int y=0;y<4-1-i;y++){
                System.out.print(" ");
            }
            for(int t=0;t<2*i-1;t++){
                System.out.print("*");
            }
        }
        System.out.println();
    }
}
