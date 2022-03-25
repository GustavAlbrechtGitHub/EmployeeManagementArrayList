package ManagementPackage;

import java.util.Scanner;

public class Utilities {

    static Scanner sc = new Scanner(System.in);

    public static int getIntInput(){

        int input = sc.nextInt();
        sc.nextLine();

        return input;
    }

    public static double getDoubleInput(){

        double input = sc.nextDouble();
        sc.nextLine();

        return input;
    }

    public static String getStringInput(){

        String input = sc.nextLine();

        return input;
    }

    public static String fixString(int wantedSize, String stringToFix){
        if (stringToFix.length()< wantedSize){
            while(stringToFix.length()<wantedSize){
                stringToFix = stringToFix + " ";

            }
            return stringToFix+"  ";
        }
        else
            return stringToFix.substring(0, wantedSize)+"  ";

    }


}
