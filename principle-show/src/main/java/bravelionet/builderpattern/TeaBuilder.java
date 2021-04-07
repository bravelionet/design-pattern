package bravelionet.builderpattern;

/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:20
 * @Description : 泡茶
 */
public class TeaBuilder extends StarbucksBuilder {

    @Override
    public void buildSize() {
        starbucks.setSize("中杯");
        System.out.println(" 泡茶 中杯 ..");
    }

    @Override
    public void buildDrink() {
        starbucks.setDrink("泡茶完毕");
        System.out.println("可以进饮用 ..");
    }
}
