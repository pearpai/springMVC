package demo.test.clone;

/**
 * Created by wuyunfeng on 2016/9/27.
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10);
        student.setStudentName("xiaobai");

        Glasses glasses = new Glasses();
        glasses.setColor("red");

        student.setGlasses(glasses);


        try {
            Student student1 = (Student)student.clone();
            student1.setAge(20);
            student1.getGlasses().setColor("blue");

            System.out.println(student.getGlasses().getColor());
            System.out.println(student1.getGlasses().getColor());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
