import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    List<Person> People = new ArrayList();

    @Test
    public void youngerThanEighteen() {
        fullList();
        List<Person> filterList = People.stream()
                .filter(x -> x.age < 18)
                .collect(Collectors.toList());

        filterList.stream()
                .forEach(x -> System.out.println(x.age));
    }

    @Test
    public void sortGender() {
        fullList();
        List<Person> sortList = People.stream()
                .sorted((a, b) -> a.gender.compareTo(b.gender))
                .collect(Collectors.toList());

        sortList.stream()
                .forEach(x -> System.out.println(x.gender));
    }

    @Test
    public void sortAges() {
        fullList();
        People.stream()
                .forEach(x -> System.out.println(x.age));

        List<Person> sortList = People.stream()
//                .sorted((a,b) -> a.age.compareTo(b.age))
                .sorted(Comparator.comparing(Person::getAge))
                .limit(2)
                .collect(Collectors.toList());

        sortList.stream()
                .forEach(x -> System.out.println("sorted: " + x.age));
    }

    @Test
    public void distinctList() {
        List<Integer> Numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        Numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void reduceList() {
        fullList();

        Optional<Person> reduce = People.stream().reduce((a, b) -> new Person(a.name + b.name));

        Integer reduce1 = People.stream().map(x -> x.getAge()).reduce(0, (a, b) -> a + b);

        List<Integer> Numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        long numbers = Numbers.stream().reduce(0,(a,b) -> a+b);
        long fun_numbers = Numbers.stream().reduce(0,(a,b) -> a+b);

        System.out.println(reduce1);
    }



    @Test
    public void countList() {
        List<Integer> Numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        long numbers = Numbers.stream()
                .distinct()
                .count();
        System.out.println(numbers);
    }


    @Test
    public void mapList() {
        fullList();
        People.stream()
                .map(x -> x.favouriteColour)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void astroList(){
        fullList();
        People.stream()
                .map(x -> new Astronaut("1", x.favouriteColour, x))
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void getToys() {
        fullList();
        System.out.println(People.stream()
                .flatMap(person -> person.pet.stream())
                .flatMap(pet -> pet.toys.stream())
//                .filter(toy -> toy.equals("bone"))
                .collect(Collectors.toList())
        );}

    @Test
    public void getToys_map() {
        fullList();
        System.out.println(People.stream()
                .flatMap(person -> person.pet.stream())
                .map(x -> x.toys)  //  .flatMap(pet -> pet.toys.stream()))
                .collect(Collectors.toList())
        );}

    @Test
    public void getToys_findAny() {
        fullList();
        System.out.println(People.stream()
                .flatMap(person -> person.pet.stream())
                .findAny()
        );}

    @Test
    public void getToys_noneMatch() {
        fullList();
        System.out.println(People.stream()
                .flatMap(person -> person.pet.stream())
                .flatMap(pet -> pet.toys.stream())
                .noneMatch(toy -> toy.equals("bone")));
        }


    @Test
    public void test(){
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    public void fullList() {
        Person P1 = new Person();
        P1.age = 15;
        P1.name = "John";
        P1.favouriteColour = "blue";
        P1.gender = "male";
        P1.pet = Arrays.asList(new Pet ("Dave", "brown", Arrays.asList("bone", "frisbee", "rubber chicken")));

        Person P2 = new Person();
        P2.age = 20;
        P2.name = "Jess";
        P2.favouriteColour = "yellow";
        P2.gender = "female";
        P2.pet = Arrays.asList(new Pet ("Steve", "yellow", Arrays.asList("mirror", "frisbee")));


        Person P3 = new Person();
        P3.age = 17;
        P3.name = "Jack";
        P3.favouriteColour = "red";
        P3.gender = "male";
        P3.pet = Arrays.asList( new Pet ("Cooper", "black", Arrays.asList("bone", "frisbee")),
                                new Pet ("Mitsy", "grey", Arrays.asList("bone", "fishing rod", "shoes")));

        Person P4 = new Person();
        P4.age = 10;
        P4.name = "Lisa";
        P4.favouriteColour = "green";
        P4.gender = "female";
        P4.pet = Arrays.asList(new Pet ("Fern", "brown", Arrays.asList("sock", "frisbee", "rubber chicken")));

        Person P5 = new Person();
        P5.age = 10;
        P5.name = "Tim";
        P5.favouriteColour = "green";
        P5.gender = "male";
        P5.pet = Arrays.asList( new Pet ("Donald", "black", Arrays.asList("bone", "frisbee")),
                                new Pet ("Zoey", "black and white", Arrays.asList("bone", "frisbee", "torch")));

        People.add(P1);
        People.add(P2);
        People.add(P3);
        People.add(P4);
        People.add(P5);
    }


}
