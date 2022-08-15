import java.util.Objects;

public class Encyclopedia extends Book implements Edition {
    public String topic;

    public Encyclopedia(String title, String dateOfCreation, String language, String topic) {
        super(title, dateOfCreation, language);
        this.topic = topic;
    }

    public Encyclopedia() {}

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Encyclopedia {" +
                "title = " + title +
                ", dateOfCreation = " + dateOfCreation +
                ", language = " + language +
                ", topic = " + topic +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Encyclopedia that = (Encyclopedia) o;
        return Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topic);
    }

    public void giveBook() {
        System.out.println("The encyclopedia was given");
    }

    public void returnBook() {
        System.out.println("The encyclopedia was returned");
    }

    public void readBook() {
        System.out.println("The encyclopedia is reading");
    }
}