package demo.test.clone;

/**
 * Created by wuyunfeng on 2016/9/27.
 */
public class Glasses implements Cloneable {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
