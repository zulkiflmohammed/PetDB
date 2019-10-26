import java.util.ArrayList;

public class PetsCollection {
    private ArrayList<PetEntry> entries;

    public PetsCollection(ArrayList<PetEntry> entries) {
        this.entries = entries;
    }

    public ArrayList<PetEntry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<PetEntry> entries) {
        this.entries = entries;
    }


    //    public static PetsCollection petsCollection(ArrayList pets) {
//        ArrayList<PetEntry> entries = new ArrayList<>();
//
//        return new PetsCollection(entries);
//    }
}
