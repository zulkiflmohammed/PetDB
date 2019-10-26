import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<PetEntry> pet = new ArrayList<PetEntry>();

        System.out.println("Pet Database Program");
        boolean isRunning=true;
        while(isRunning){

            menuDisplay();
            System.out.println("Your choice: ");
            int userChoice= myScanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("-----------------------------------------------------------------");
//                    System.out.printf("%-30s %10s %10s %10s\n", "ID", "Name", "Age", "Quantity");
                    System.out.println("-----------------------------------------------------------------");
                    for (PetEntry pets: pet) {
                        System.out.printf(
                                "|%3s | %-10s|%4s |\n",
                                pets.getID(),
                                pets.getName(),
                                pets.getAge(),
                                pets.getAge()

                        );
                    }
                    break;
                case 2:
                    int counter=0;
                    boolean isMore=true;
                    while(isMore){
                        Scanner sc= new Scanner(System.in);
                        System.out.println("add pet (name, age): ");
                        String userInput= sc.nextLine();

                        if (userInput.equals("done")) {
                            isMore = false;
                        }
                        else {
                            Scanner getData= new Scanner(userInput);

                            counter++;
                            String name= getData.next();
                            int age= getData.nextInt();
                            pet.add(new PetEntry(name, age));
                        }

                    }
                    System.out.println(counter + " pets have been added.");
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    break;
            }

        }
    }

    //method for menu display
    public static void menuDisplay() {
        System.out.println("What would you like to do?");
        System.out.println("\t 1) View all pets");
        System.out.println("\t 2) Add more pets");
        System.out.println("\t 3) Update an existing pet");
        System.out.println("\t 4) Remove an existing pet");
        System.out.println("\t 5) Search pets by name");
        System.out.println("\t 6) Search pets by age");
        System.out.println("\t 7) Exit Program");
    }

    public static void addPet() {
        Scanner sc2= new Scanner(System.in);
        ArrayList<PetEntry> pet = new ArrayList<PetEntry>();

//        boolean isRunning=true;
//        int counter=0;
//        while(isRunning){
//            counter++;
//            System.out.println("add pet (name, age): ");
//            String userInput= sc2.nextLine();
//            if (userInput.equals("done")) {
//                isRunning=false;
//            }else {
//                String[] data= userInput.split(" ");
//                String name= data[0];
//                int age= Integer.parseInt(data[1]);
//                pet.add(new PetEntry(name, age));
//                PetsCollection petsCollection= new PetsCollection(pet);
//            }
//
//
//        }
    }

    public static void viewAllPets() {

    }


}
