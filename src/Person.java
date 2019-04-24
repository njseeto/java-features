import java.util.List;

public class Person {

String name;
Integer age;
String favouriteColour;
String gender;
List<Pet> pet;

    public Person() {
    }


    public Person(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favouriteColour='" + favouriteColour + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
