/**
 * Created by vincent on 2017/6/3.
 */
public class TestDoWhile {
    public static void main(String[] args) {
        //範例:取亂數，一直取到要大於5為止
        double random;
        //do while至少會執行一次
        do{
            random = Math.random()*10;
            System.out.println(random);
        }
        while ( random < 5 );
    }
}
