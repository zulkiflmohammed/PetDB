import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PetsDB petDB = new PetsDB();
        int choice;


        System.out.println();
        do
        {
            menuDisplay();
            choice = Integer.parseInt(sc.nextLine().trim());
            switch(choice)
            {
                case 1:
                {
                    System.out.println();
                    petDB.viewAllPets();
                    break;
                }
                case 2:
                {
                    System.out.println();
                    petDB.addNewPets();
                    break;
                }
                case 3:
                {
                    System.out.println();
                    petDB.removePet();
                    break;
                }
                case 4:
                {
                    petDB.writeToFile();
                    System.out.println("\nGoodbye!\n");
                    System.exit(0);
                }
                default:
                    System.out.println("\nInvalid choice!\n");
            }
        }while(choice != 4);
    }

    //method for menu display
    public static void menuDisplay() {
        System.out.print("What would you like to do?\n"
                + "1. View all pets\n"
                + "2. Add new pets\n"
                + "3. Remove a pet\n"
                + "4. Exit program\n"
                + "Your choice: ");
    }



}
