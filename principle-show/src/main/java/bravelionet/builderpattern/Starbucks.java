package bravelionet.builderpattern;
/**
 * @Author : Lionet
 * @Date : 2021/4/1  16:13
 * @Description : 代建产品
 */
public class Starbucks {

    private String size;


    private String drink;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Starbucks{" +
                "size='" + size + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
