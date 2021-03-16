package com.higlowx.algorithm.vector;


import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/**
 * commons-math3包下的向量计算示例
 * <p>
 * api docs:http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/index.html?overview-summary.html
 *
 * @author Dylan.Li
 * @date 2021/3/16
 */

public class RealVectorDemo {


    public static void main(String[] args) {
        RealVector vector1 = new ArrayRealVector(new Double[]{1d,1d});
        RealVector vector2 = new ArrayRealVector(new Double[]{1d,0.5});
        //计算夹角余弦相似度
        System.out.println(vector1.cosine(vector2));
        //获取向量维度
        System.out.println(vector1.getDimension());
        //向量距离
        System.out.println(vector1.getDistance(vector2));
    }

}
