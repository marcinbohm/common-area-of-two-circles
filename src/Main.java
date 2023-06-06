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
    public static double areaOfIntersection(int centerX1, int centerY1, int radius1, int centerX2, int centerY2, int radius2) {
        
        // Validate input
        if (radius1 < 0 || radius2 < 0) {
            throw new IllegalArgumentException("Radius values must be non-negative.");
        }
        
        double d = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));

        if (d == 0) {
            int r = Math.min(radius1, radius2);
            return Math.PI * r * r;
        }

        if (d > radius1 + radius2) {
            return 0.0;
        }

        double angle1 = Math.acos((d * d + radius1 * radius1 - radius2 * radius2) / (2 * d * radius1));
        double angle2 = Math.acos((d * d + radius2 * radius2 - radius1 * radius1) / (2 * d * radius2));
        double intersectionArea = radius1 * radius1 * angle1 + radius2 * radius2 * angle2 - 0.5 * Math.sqrt((-d + radius1 + radius2) * (d + radius1 - radius2) * (d - radius1 + radius2) * (d + radius1 + radius2));

        return BigDecimal.valueOf(intersectionArea).setScale(6, RoundingMode.HALF_UP).doubleValue();
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
