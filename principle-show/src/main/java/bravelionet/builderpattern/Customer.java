package bravelionet.builderpattern;

/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:32
 * @Description : 客户
 */
public class Customer {

    public static void main(String[] args) {
        StarbucksBuilder starbucksBuilder = new CoffeeBuilder();
        Waiter waiter = new Waiter(starbucksBuilder);
        waiter.constructStarbucks();
        Starbucks starbucks1 = waiter.getstarbucksDrink();
        System.out.println("starbucks1 = " + starbucks1);

        TeaBuilder teaBuilder = new TeaBuilder();
        waiter.setStarbucksBuilder(teaBuilder);
        waiter.constructStarbucks();
        Starbucks starbucks2 = waiter.getstarbucksDrink();
        System.out.println("starbucks2 = " + starbucks2);


    }
}
