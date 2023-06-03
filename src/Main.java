import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
 *
 */
public class Main
{
    public static double areaOfIntersection(int centerX1, int centerY1, int radius1, int centerX2, int centerY2, int radius2)
    {
        double  answer = 0;
        double d = 0;

        d = Math.sqrt(Math.pow((centerX2 - centerX1),2) + Math.pow((centerY2 - centerY1),2));

        if (d == 0) {
            int r = Math.min(radius1, radius2);
            answer = Math.PI * r * r;
        } else if (d <= radius1 + radius2) {
            answer = Math.pow(radius1,2) * Math.acos((Math.pow(d,2) + Math.pow(radius1,2) - Math.pow(radius2,2)) /
                    (2 * d * radius1)) + Math.pow(radius2,2) * Math.acos((Math.pow(d,2) + Math.pow(radius2,2) - Math.pow(radius1,2)) /
                    (2 * d * radius2)) - 0.5 * Math.sqrt((-d + radius1 + radius2) * (d + radius1 - radius2) * (d - radius1 + radius2) *
                    (d + radius1 + radius2));
        }
        answer = BigDecimal.valueOf(answer)
                .setScale(6, RoundingMode.HALF_UP)
                .doubleValue();
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for centerX1
        int centerX1 = in.nextInt();

        // input for centerY1
        int centerY1 = in.nextInt();

        // input for radius1
        int radius1 = in.nextInt();

        // input for centerX2
        int centerX2 = in.nextInt();

        // input for centerY2
        int centerY2 = in.nextInt();

        // input for radius2
        int radius2 = in.nextInt();


        double result = areaOfIntersection(centerX1, centerY1, radius1, centerX2, centerY2, radius2);
        System.out.print(result);

    }
}
