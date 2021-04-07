package bravelionet.builderpattern;

/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:24
 * @Description : 制作咖啡
 */
public class CoffeeBuilder extends StarbucksBuilder {
    @Override
    public void buildSize() {
        starbucks.setSize("大杯");
        System.out.println("制作咖啡 ..");
    }

    @Override
    public void buildDrink() {
        starbucks.setDrink("制作完成");
        System.out.println("制作完成 ...");
    }
}
