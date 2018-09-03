/**
 * Author : Anisha Vulli.
 * Date : 03rd Sept 2018.
 */
import java.util.Scanner;
/**
 * Class for scores.
 */
class Scores {
    /**
     * a, b, c values are defined.
     */
    private double a, b, c;
    /**
     * Constructs the object.
     *
     * @param      x     { parameter_description }
     * @param      y     { parameter_description }
     * @param      z     { parameter_description }
     */
    Scores(final double x, final double y, final double z) {
        this.a = x;
        this.b = y;
        this.c = z;
    }

    /**
     * Avarage caluculation method.
     *
     * @return    fiavg { avarage of the marks }
     */

    public double grade() {
        double avg = 0;
        double sum = 0;
        double fiavg = 0;
        final double three = 3;
        final double ten = 10.0;
        sum = a + b + c;
        avg = sum / three;
        fiavg = Math.round(avg * ten) / ten;
        return fiavg;
    }
}
/**
 * Class for student details.
 */
public final class StudentDetails {
    /**
     * Constructs the object.
     */
    private StudentDetails() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name, rollno, and 3 subject marks");
        String name = sc.nextLine();
        String rollno = sc.nextLine();
        double m1 = sc.nextDouble();
        double m2 = sc.nextDouble();
        double m3 = sc.nextDouble();

        Scores obj1 = new Scores(m1, m2, m3);
        System.out.println(obj1.grade());

    }
}
