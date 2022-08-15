import java.util.Objects;

public class Guide extends Book implements Edition {
    public String type;

    public Guide(String title, String dateOfCreation, String language, String type) {
        super(title, dateOfCreation, language);
        this.type = type;
    }

    public Guide() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Guide {" +
                "title = " + title +
                ", dateOfCreation = " + dateOfCreation +
                ", language = " + language +
                ", type = " + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guide guide = (Guide) o;
        return Objects.equals(type, guide.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    public void giveBook() {
        System.out.println("The guide was given");
    }

    public void returnBook() {
        System.out.println("The guide was returned");
    }

    public void readBook() {
        System.out.println("The guide is reading");
    }
}