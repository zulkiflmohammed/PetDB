import java.util.concurrent.atomic.AtomicInteger;

public class PetEntry {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int ID;
    private int age;
    private String name;

    public PetEntry(String name, int age) {
        this.ID = count.incrementAndGet();
        this.age = age;
        this.name = name;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
