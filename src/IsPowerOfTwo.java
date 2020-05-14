/**
 * @author Chris.Li
 * @desc
 * @date 2020/5/14
 */

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return 0 < n && (0 == (n & (n - 1)));
    }

    public static void main(String[] args) {
        System.out.println("1: " + new IsPowerOfTwo().isPowerOfTwo(1));
        System.out.println("0: " + new IsPowerOfTwo().isPowerOfTwo(0));
        System.out.println("2: " + new IsPowerOfTwo().isPowerOfTwo(2));
        System.out.println("8: " + new IsPowerOfTwo().isPowerOfTwo(8));
        System.out.println("7: " + new IsPowerOfTwo().isPowerOfTwo(7));

    }
}
