package com.higlowx.algorithm.zuochengyun;

/**
 * @author Dylan.Li
 * @date 2021/2/25
 * <p>
 * 给定一个整数N，构建出长度为N的自然数数组arr，使的任意三个位置下标i、j、k（i<j<k）都满足 arr[i] + arr[k] != 2 * arr[j]
 */

public class Zcy01 {

    public int[] solution(int n) {

        // 暂且将arr[i],arr[j],arr[k]赋值给a,b,c三个值
        // arr[i]+arr[k]!=2*arr[j] -> a+c!=2b -> (a+1)+(c+1)=2+a+c != 2+2b=2(b+1) -> (a+1)+(c+1)!=2(b+1)
        // 说明，可以围绕题中的约束不等式推导出其他的 变种不等式
        // 比如，(a-1)+(c-1)=a+c-2 != 2b-2=2(b-1) -> (a-1)+(c-1)!=2(b-1)
        // 将上述结果再加工，2(a-1)+2(c-1)!=2*2(b-1)，再加工，(2(a-1)+1)+(2(c-1)+1) != 2*(2(b-1)+1)
        // (2(a-1)+1)+(2(c-1)+1) != 2*(2(b-1)+1)很容易证明，如下
        // (2(a-1)+1)+(2(c-1)+1)
        //   = (2a-2+1)+(2c-2+1)
        //   = (2a-1)+(2c-1)
        //   = 2(a+c)-2
        // 将a+c用2b替换，得到 2(a+c)-2 != 2(2b) -2
        // 变化2(2b)-2，有 2(2b)-2 = 2(2b-1) = 2(2b-2+1) = 2(2(b-1)+1)
        // 最终有 (2(a-1)+1)+(2(c-1)+1) != 2(2(b-1)+1)
        //
        // 带入一个长度为3的且满足不等关系的数组，模拟一下上面的过程
        // {1,3,2} -> {1-1,3-1,2-1} -> {0,2,1} -> {2*0,2*2,2*1} -> {0,4,2} -> {0+1,4+1,2+1} -> {1,5,3}
        // finally: {1,3,2} -> {1,5,3}，满足不等式！！
        //
        // 我们惊奇的发现，自然数中第1个奇数是1，第3个奇数是5，第2个奇数是3，上述过程实际上就是运用 既定不等式，变形推导出的 新的不等式，且符合奇数计算规律
        // 我们将其称为，“奇变化”
        // 同理，也可推导出，“偶变化”后，不等式依旧成立
        // Q：为什么要引入“奇变化”和“偶变化”两种概念呢？
        // A：
        // 举个栗子，还是最初的数组{1,3,2}
        // 奇变化有{1,5,3}，偶变化有{0,4,2}，两个数组都满足不等式
        // Q：一个大胆的设想，如果直接将两个数组前后合并到一起，还会满足不等式吗？
        // A：满足。{1,5,3,0,4,2}中，前三个元素满足不等式，后三个也满足，唯一需要分析的特殊临界位置在“i、j、k中至少有一个落在奇数侧，至少一个落在偶数侧”
        // 比如i在奇数侧，j和k在偶数侧，arr[i]+arr[k]是奇数加偶数，一定是奇数，而且2*arr[j]一定是偶数，“奇数一定不等于偶数”呀！！Prefect！！

        // 回到本题，如果要得到一个长度为N的满足不等关系的自然数数组，我们只需要找个最小长度且满足条件的数组，然后奇变化数组拼上偶变化数组，就得到了一个两倍大小的新数组，循环往复，即可得到解

        if (n < 3) {
            return null;
        }
        return make(n);
    }

    private int[] make(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int halfSize = (n + 1) / 2;
        int[] baseArr = make(halfSize);
        int[] resultArr = new int[2 * halfSize];
        for (int i = 0; i < halfSize; i++) {
            resultArr[i] = 2 * (baseArr[i] - 1) + 1;
        }
        for (int i = 0; i < halfSize; i++) {
            resultArr[halfSize + i] = 2 * (baseArr[i] - 1);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Zcy01 ins = new Zcy01();
        for (int i = 0; i < 1000; i++) {
            int[] arr = ins.solution(i);
            boolean validate = ins.validate(arr);
            System.out.println("i:" + i + ", " + validate);
        }
    }

    public boolean validate(int[] arr) {
        if (null == arr) {
            return false;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[k] == 2 * arr[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
