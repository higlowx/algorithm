package com.dylanlee.algorithm;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * @author Dylan.Lee
 * @date 2020/5/26
 * @since
 */

public class JianZhiOffer01 {

    public boolean solution(int target, int[][] array) {
        //取左下角坐标
        int y = array.length - 1;
        int x = 0;
        int count = 0;
        while (true) {
            count++;
            System.out.println("第" + count + "次查找");
            System.out.println("x:" + x + " y:" + y);
            if (x > array[0].length - 1 || y < 0) {
                return false;
            }
            //此处注意是array[y][x]
            int node = array[y][x];
            if (target == node) {
                return true;
            } else if (target > node) {
                x++;
            } else {
                y--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{2, 3, 4}, {5, 9, 16}, {8, 18, 32}};
        System.out.println(array[0].length - 1);
        System.out.println(array.length);
        System.out.println(array[2][1]);
        System.out.println(new JianZhiOffer01().solution(1, array));
    }

}
