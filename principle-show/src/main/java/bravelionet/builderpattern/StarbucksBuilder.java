package bravelionet.builderpattern;

/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:15
 * @Description : 抽象 builder, 饮料机
 */
public abstract  class StarbucksBuilder {


    /**
     * 定义产品
     */
    protected Starbucks starbucks;


    public Starbucks getStarbucks(){
        // 获取产品原材料
        return this.starbucks;
    }

    /**
     *
     * 创建获取原材料
     */
    public void createStarbucks(){
        Starbucks starbucks = new Starbucks();
        this.starbucks = starbucks;
        System.out.println(" 创建产品 ..." );
    }


    /**
     * 创建星巴克容量
     */
    public abstract void buildSize();

    /**
     * 可以饮用
     */
    public abstract void buildDrink();



}
