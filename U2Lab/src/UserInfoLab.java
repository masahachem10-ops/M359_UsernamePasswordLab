import java. util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        String firstName = "";
        String lastName = "";
        String userName = "";
        String pass = "";
        String creditCardNum = "";

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your first name below: ");
        firstName = input.nextLine();
        System.out.println("Enter your last name below: ");
        lastName = input.nextLine();


        userName = generateUsername(firstName, lastName);

        System.out.println(userName);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:

        System.out.println("Enter your password:");
        pass = input.nextLine();
        System.out.println(validatePassword(pass));



        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.

        if(validatePassword(pass)){
            System.out.println("Enter your credit card number:");
            creditCardNum = input.nextLine();
            System.out.println(maskCreditCard(creditCardNum));
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing
        if(validatePassword(pass) && maskCreditCard(creditCardNum) != "N/A"){
            System.out.println("Final Details: ");
            System.out.println("Username: \t " + userName);
            System.out.println("Credit Card: " + maskCreditCard(creditCardNum));
        }
    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String output = "";

        if(firstName.length() < 3){
            output += firstName;

            if(lastName.length() < 3){
                output += lastName;
            }
            else{
                output += lastName.substring(0, 3);
            }
        }
        else{
            output += firstName.substring(0, 3);

            if(lastName.length() < 3){
                output += lastName;
            }
            else{
                output += lastName.substring(0, 3);
            }
        }


        output = output.toLowerCase();

        return output;
    }
    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid

        if(password.length() >= 8){
            if(password.equals(password.toLowerCase())){
                System.out.println("password doesn't contain uppercase characters");
                return false;
            }
            else{
                if(containsDigit(password)){
                    return true;
                }
                else{
                    System.out.println("password doesn't contain a digit");
                    return false;
                }
            }
        }
        else{
            System.out.println("password is less than 8 letters");
            return false;
        }
    }
    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        if(creditCardNumber.length() == 16 && allDigits(creditCardNumber)){
            return "**** **** **** " + creditCardNumber.substring(12);
        }
        else{
            return "N/A";
        }
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
