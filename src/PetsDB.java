import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PetsDB {
    public String fileName;
    private ArrayList<Pet> pets;
    private int size;

    public PetsDB()
    {

        this.fileName = "pets.txt";
        this.pets = new ArrayList<>();
        this.size = 0;
    }

    public void load() {

        try{
            //intake file
            Scanner input = new Scanner(new File(fileName));
            //iterate through file and separate by line and "," and store them accordingly
            while (input.hasNextLine()){
                size++;
                String line= input.nextLine();
                String[] data= line.split(",");

                String name= data[0];
                int age= Integer.parseInt(data[1]);
                this.pets.add(new Pet(name, age));            }
        }
        //error for file
        catch(Exception e) {
            System.out.println("Error!");
            System.out.println("Error details: " + e.getMessage());
        }


    }

    public void viewAllPets()
    {
        if(this.pets.isEmpty())
            System.out.println("Error: Sorry, there are no pets to show!\n");
        else
        {
            System.out.println("+-----------------------+");
            System.out.printf("| %2s | %-10s | %3s |\n", "ID", "NAME", "AGE");
            System.out.println("+-----------------------+");

            for(int i = 0; i < size; i++)
            {
                System.out.printf("| %2d | %-10s | %3d |\n", i, this.pets.get(i).getName(), this.pets.get(i).getAge());
            }
            System.out.println("+-----------------------+\n"
                    + size + " rows in set.\n");
        }
    }

    public void addNewPets(){
        Scanner sc= new Scanner(System.in);
        String line;

        do {
            System.out.println("add pet(name, age: )");
            line = sc.nextLine().trim();
            if(line.equalsIgnoreCase("done"))
                break;

            //check for database size limit
            if (size>5){
                System.out.println("Error: Database is full.\n");
                return;
            }

            String name;
            int age;
            while(line.split(" ").length != 2 || isDigit(line.split(" ")[0]) ||
                    (Integer.parseInt(line.split(" ")[1])< 1) || Integer.parseInt(line.split(" ")[1]) > 20){

                //check if user input is not 2
                if(line.split(" ").length != 2){
                    System.out.println("Error: " + line + " is not a valid input.");
                    System.out.println("add pet(name, age: ");
                    line= sc.nextLine().trim();
                    break;
                }

                //check user
                if(isDigit(line.split(" ")[0])){
                    System.out.println("Error: " + line + " is not a valid input.");
                    System.out.println("add pet(name, age: ");
                    line= sc.nextLine().trim();
                    break;
                }
                if(Integer.parseInt(line.split(" ")[1])< 1 || Integer.parseInt(line.split(" ")[1]) > 20){
                    System.out.println("Error: " + line.split(" ")[1] + " is not a valid age.");
                    System.out.println("add pet(name, age: ");
                    line= sc.nextLine().trim();
                    break;
                }
            }

            String[] data= line.split(" ");
            name = data[0];
            age = Integer.parseInt(data[1]);

            this.pets.add(new Pet(name, age));
            size++;

        }while(!line.equalsIgnoreCase("done"));

        System.out.println(size + " pets added.\n");
    }

    //remove pet
    public void removePet(){
        //display all pets
        viewAllPets();

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the pet ID to remove: ");
        int id = sc.nextInt();

        while(id < 0 || id > size) {
            System.out.println("Error:  ID " + id + " does not exist. \n");
            System.out.println("Re-enter the pet ID to remove: ");
            id = sc.nextInt();
        }
        String oldName = this.pets.get(id).getName();
        int oldAge = this.pets.get(id).getAge();

        this.pets.remove(id);
        size--;
        System.out.println(oldName + " " + oldAge + " is removed.\n");

    }

    //save pets data to file
    public void writeToFile(){
        FileWriter fileWriter;
        PrintWriter printWriter;

        try{
            fileWriter = new FileWriter(new File(fileName));
            printWriter = new PrintWriter(fileWriter);

            for(Pet pet: this.pets) {
                printWriter.write(pet.getName() + "," + pet.getAge() + System.lineSeparator());
            }
            printWriter.flush();
            fileWriter.close();
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error: Writing to file" + fileName + " - " + e.getMessage());
        }
    }

    //checks if input is a number
    private boolean isDigit(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


    //    public static PetsCollection petsCollection(ArrayList pets) {
//        ArrayList<PetEntry> entries = new ArrayList<>();
//
//        return new PetsCollection(entries);
//    }
}
