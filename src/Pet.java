import java.util.List;

public class Pet {

    String name;
    String colour;
    List<String> toys;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", toys=" + toys +
                '}';
    }

    public Pet(String name, String colour, List<String> toys) {

        this.name = name;
        this.colour = colour;
        this.toys = toys;
    }

}
