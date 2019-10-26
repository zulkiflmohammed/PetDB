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
                    System.out.println("--------------------------");
                    System.out.printf("|%3s | %-10s|%4s |\n", "ID", "Name", "Age");
                    System.out.println("--------------------------");
                    for (PetEntry pets: pet) {
                        System.out.printf(
                                "|%3s | %-10s|%4s |\n",
                                pets.getID(),
                                pets.getName(),
                                pets.getAge()
                        );
                        System.out.println("--------------------------");

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
                case 3:
                    Scanner sc4= new Scanner(System.in);
                    System.out.println("--------------------------");
                    System.out.printf("|%3s | %-10s|%4s |\n", "ID", "Name", "Age");
                    System.out.println("--------------------------");
                    for (PetEntry pets: pet) {
                        System.out.printf(
                                "|%3s | %-10s|%4s |\n",
                                pets.getID(),
                                pets.getName(),
                                pets.getAge()
                        );
                        System.out.println("--------------------------");

                    }

                    System.out.println("Enter the pet ID you want to update: ");
                    int updateID= sc4.nextInt();

                    PetEntry pUpdate= pet.get(updateID-1);


                    System.out.println("Enter new name and age: ");
//                    String updatedPet= sc4.nextLine();

//                    Scanner updated= new Scanner(updatedPet);
                    String newName= sc4.next();
                    int newAge= sc4.nextInt();

                    System.out.println(pUpdate.getName() +" " + pUpdate.getAge() + " changed to " + newName + " " + newAge );

                    pUpdate.setAge(newAge);
                    pUpdate.setName(newName);
//                    for(PetEntry p : pet){
//                        if(p.ID == updateID){
//                            String name= p.getName();
//                            int age= p.getAge();
//
//                            System.out.println("Enter new name and age: ");
//                            String updatedPet= sc4.nextLine();
//
//                            Scanner updated= new Scanner(updatedPet);
//                            String newName= updated.next();
//                            int newAge= updated.nextInt();
//                            p.setAge(newAge);
//                            p.setName(newName);
//
//                            System.out.println(name +" " + age + "changed to " + updatedPet );
//
//                        }
//                    }
                    break;
                case 4:
                    Scanner sc3= new Scanner(System.in);
                    System.out.println("--------------------------");
                    System.out.printf("|%3s | %-10s|%4s |\n", "ID", "Name", "Age");
                    System.out.println("--------------------------");
                    for (PetEntry pets: pet) {
                        System.out.printf(
                                "|%3s | %-10s|%4s |\n",
                                pets.getID(),
                                pets.getName(),
                                pets.getAge()
                        );
                        System.out.println("--------------------------");

                    }

                    System.out.println("Enter the pet ID you want to remove: ");
                    int removeID= sc3.nextInt();

                    PetEntry pRemove= pet.get(removeID-1);
                    System.out.println(pRemove.getName() + " " + pRemove.getAge() + " has been removed");

                    pet.remove(removeID-1);
                    break;
                case 5:
                    Scanner sc1= new Scanner(System.in);
                    System.out.print("Select pet name: ");
                    String pickName = sc1.nextLine();
                    boolean found = false;
                    System.out.println("--------------------------");
                    System.out.printf("|%3s | %-10s|%4s |\n", "ID", "Name", "Age");
                    System.out.println("--------------------------");
                    for(PetEntry p : pet){
                        if(p.name.equals(pickName)){
                            System.out.printf(
                                    "|%3s | %-10s|%4s |\n",
                                    p.getID(),
                                    p.getName(),
                                    p.getAge()

                            );
                            System.out.println("--------------------------");
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("No pet with that name.");
                    }
                    break;

                case 6:
                    Scanner sc2= new Scanner(System.in);
                    System.out.print("Select pet age: ");
                    int pickAge = sc2.nextInt();
                    boolean isFound= false;
                    System.out.println("--------------------------");
                    System.out.printf("|%3s | %-10s|%4s |\n", "ID", "Name", "Age");
                    System.out.println("--------------------------");

                    for(PetEntry p : pet){
                        if(p.age==pickAge){

                            System.out.printf(
                                    "|%3s | %-10s|%4s |\n",
                                    p.getID(),
                                    p.getName(),
                                    p.getAge()

                            );
                            System.out.println("--------------------------");

                            isFound = true;
                        }
                    }
                    if(!isFound){
                        System.out.println("No pet with that name.");
                    }
                    break;
                case 7:
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
