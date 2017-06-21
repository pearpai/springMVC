package demo.test.clone;

/**
 * Created by wuyunfeng on 2016/9/27.
 */
public class Student implements Cloneable {

    private String studentName;

    private Glasses glasses;

    private int age;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Glasses getGlasses() {
        return glasses;
    }

    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 对象引用 需要进行深度克隆

        Student student = (Student) super.clone();
        student.glasses = (Glasses)glasses.clone();
        return student;
    }
}
