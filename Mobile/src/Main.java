import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Mobile> mobiles = new ArrayList<>();
        List<Mobile.PhoneInformation> phoneInformationList = new ArrayList<>();

        Mobile mobile = new Mobile();
        mobile.readFile(mobiles, phoneInformationList);

        mobile.setPhoneInformation(mobiles, phoneInformationList);

        mobile.print(mobiles);
    }
}