package bravelionet.builderpattern;

/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:25
 * @Description : 服务员, 指挥者 (构建者)
 */
public class Waiter {

    private StarbucksBuilder starbucksBuilder;

    public Waiter (StarbucksBuilder starbucksBuilder){
        this.starbucksBuilder = starbucksBuilder;
    }

    public void setStarbucksBuilder(StarbucksBuilder starbucksBuilder) {
        this.starbucksBuilder = starbucksBuilder;
    }

    /**
     * 先进行获取原材料
     */
    public Starbucks getstarbucksDrink(){
        return starbucksBuilder.getStarbucks();
    }


    public void constructStarbucks(){
        starbucksBuilder.createStarbucks();
        starbucksBuilder.buildSize();
        starbucksBuilder.buildDrink();
    }


}
