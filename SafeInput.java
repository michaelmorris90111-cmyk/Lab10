import java.util.Scanner;


public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" +prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("Please enter a valid integer.");
            }
        } while (!done);
        return retInt;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" +prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("Please enter a valid number.");
            }
        } while (!done);
        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retRangedInt = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retRangedInt = pipe.nextInt();
                if (retRangedInt >= low && retRangedInt <= high) {
                    done = true;
                }
                else  {
                    trash = pipe.nextLine();
                    System.out.println("Please enter a valid integer within the range.");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid integer within the range.");
            }
        } while (!done);
        return retRangedInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retRangedDouble = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retRangedDouble = pipe.nextDouble();
                if (retRangedDouble >= low && retRangedDouble <= high) {
                    done = true;
                }
                else  {
                    trash = pipe.nextLine();
                    System.out.println("Please enter a valid number within the range.");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid number within the range.");
            }
        } while (!done);
        return retRangedDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retYNConfirm = false;
        boolean done = false;
        String response = "";
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.next();
            if (response.equalsIgnoreCase("Y")) {
                retYNConfirm = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N")) {
                retYNConfirm = false;
                done = true;
            }
            else  {
                System.out.println("You Entered: " + response + ", Please enter Y or N.");
            }
        } while (!done);
        return retYNConfirm;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean done = false;

        while (!done) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextLine()) {
                input = pipe.nextLine();
                if (input.matches(regEx)) {
                    done = true;
                } else {
                    System.out.println("Invalid input. Please match the pattern: " + regEx);
                }
            }
        }
        return input;
    }
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int borderStars = 3;
        int innerWidth = totalWidth - (2 * borderStars);

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");

        int spaceNeeded = innerWidth - msg.length();
        int leftPadding = spaceNeeded / 2;
        int rightPadding = spaceNeeded - leftPadding;

        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }

        System.out.print("***");
        System.out.println();

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}