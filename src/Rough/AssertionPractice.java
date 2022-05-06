package Rough;

import org.junit.Assert;
import org.junit.Test;

public class AssertionPractice {

    public static void main(String[] args) {
        String Branch = "CSE";
        int year = 2;
        switch (year) {
            case 1:
                System.out.println("elective courses :Advance English,Algebra");
                break;
            case 2:
                switch (Branch) {
                    case "CSE":

                    case "CCE":
                        System.out.println("elective courses:Machine Learning Big Data");
                        break;
                    case "ECE":
                        System.out.println("elective courses:Antenna Engineering");
                        break;

                    default:
                        System.out.println("Eelective courses:Optimization");
                }
        }
    }

}
