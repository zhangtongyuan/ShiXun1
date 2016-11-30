package com.example;

/**
 * 作用: 用java语言编程:有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 作者: 张桐源
 * 日期: 2016/11/30
 */
public class Ti4 {
  /*  private int[] a = {1, 2, 3, 4};//定义数组并赋值
    private int num = 0;//定义组成三位数的个数
    private int hundredNum = 0;//定义组成的三位数

    //hundred-百位, tens-十位, units-个位
    public int hundNumber(int hundred, int tens, int units) {
        return 100 * hundred + 10 * tens + 1 * units;
    }

    public static void main(String[] args) {
        Ti4 t = new Ti4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int m = 0; m < 4; m++) {
                    if (t.a[i] != t.a[j] && t.a[j] != t.a[m] && t.a[m] != t.a[i]) {
                        t.hundredNum = t.hundNumber(t.a[i], t.a[j], t.a[m]);
                        t.num++;
                        System.out.println(t.hundredNum);
                    }
                }
            }
        }
        System.out.println("Total: " + t.num);
    }*/
  public static void main(String[] args) {
      int count = 0;
      for (int i = 1; i < 5; i++) {
          for (int j = 1; j < 5; j++) {
              for (int k = 1; k < 5; k++) {
                  if(i!=j && j!=k && i!=k){
                      count ++;
                      System.out.println(i*100+j*10+k);
                  }
              }
          }
      }
      System.out.println("共有"+count+"个数");
  }
}