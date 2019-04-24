public class Astronaut {

    public Astronaut(String grade, String helmetColour, Person person) {
        this.grade = grade;
        this.helmetColour = helmetColour;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Astronaut{" +
                "grade='" + grade + '\'' +
                ", helmetColour='" + helmetColour + '\'' +
                ", person=" + person +
                '}';
    }

    String grade;
    String helmetColour;
    Person person;
}
