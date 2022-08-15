import java.util.List;

public interface Employee {
    void givePromotion();
    <T> void print(List<T> list);
}