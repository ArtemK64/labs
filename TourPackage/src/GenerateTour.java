import java.io.*;
import java.util.*;

public class GenerateTour {
    public List<Sports> sportsTours;
    public List<Shopping> shoppingTours;
    public List<Cruise> cruiseTours;
    public List<Excursion> excursionTours;
    public List<Vacation> vacationTours;

    public GenerateTour(List<Sports> sportsTours, List<Shopping> shoppingTours, List<Cruise> cruiseTours, List<Excursion> excursionTours, List<Vacation> vacationTours) {
        this.sportsTours = sportsTours;
        this.shoppingTours = shoppingTours;
        this.cruiseTours = cruiseTours;
        this.excursionTours = excursionTours;
        this.vacationTours = vacationTours;
    }

    public List<Sports> getSportsTours() {
        return sportsTours;
    }

    public List<Shopping> getShoppingTours() {
        return shoppingTours;
    }

    public List<Cruise> getCruiseTours() {
        return cruiseTours;
    }

    public List<Excursion> getExcursionTours() {
        return excursionTours;
    }

    public List<Vacation> getVacationTours() {
        return vacationTours;
    }

    public void setSportsTours(List<Sports> sportsTours) {
        this.sportsTours = sportsTours;
    }

    public void setShoppingTours(List<Shopping> shoppingTours) {
        this.shoppingTours = shoppingTours;
    }

    public void setCruiseTours(List<Cruise> cruiseTours) {
        this.cruiseTours = cruiseTours;
    }

    public void setExcursionTours(List<Excursion> excursionTours) {
        this.excursionTours = excursionTours;
    }

    public void setVacationTours(List<Vacation> vacationTours) {
        this.vacationTours = vacationTours;
    }

    @Override
    public String toString() {
        return "GenerateTour {" +
                "\n\tsportsTours = " + sportsTours +
                "\n\tshoppingTours = " + shoppingTours +
                "\n\tcruiseTours = " + cruiseTours +
                "\n\texcursionTours = " + excursionTours +
                "\n\tvacationTours = " + vacationTours +
                "\n}";
    }

    public static GenerateTour readFile(List<Sports> sportsList, List<Shopping> shoppingList, List<Cruise> cruiseList, List<Excursion> excursionList, List<Vacation> vacationList) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine()) {
            case "Sports":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        sportsList.add(new Sports(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                arrayOfFileLine[5].split("_")
                        ));
                    }
                }
            case "Shopping":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        shoppingList.add(new Shopping(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                Integer.parseInt(arrayOfFileLine[5])
                        ));
                    }
                }
            case "Cruise":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        cruiseList.add(new Cruise(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                arrayOfFileLine[5]
                        ));
                    }
                }
            case "Excursion":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        excursionList.add(new Excursion(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                Integer.parseInt(arrayOfFileLine[5])
                        ));
                    }
                }
            case "Vacation":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        vacationList.add(new Vacation(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                arrayOfFileLine[5]
                        ));
                    }
                }
        }
        return new GenerateTour(sportsList, shoppingList, cruiseList, excursionList, vacationList);
    }

    public static void generateVariationsForClient(GenerateTour generateTour) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What kind of tour do you want to choose?");
        System.out.println("sports / shopping / cruise / excursion / vacation");
        System.out.print("Input: ");
        String inputTour = scanner.next().toLowerCase();

        String inputTransport = "";
        if (!inputTour.equalsIgnoreCase("cruise")) {
            System.out.println("What kind of transport to you to choose?");
            System.out.println("train / plane");
            System.out.print("Input: ");
            inputTransport = scanner.next().toLowerCase();
        }

        System.out.println("What kind of nutritional do you want to have?");
        System.out.println("vegetarian / dietary");
        System.out.print("Input: ");
        String inputNutrition = scanner.next().toLowerCase();

        System.out.println("How many days do you want to have?");
        System.out.println("10 / 12");
        System.out.print("Input: ");
        int inputDays = scanner.nextInt();

        switch (inputTour) {
            case "sports" -> {
                List<Sports> resultSportsList = new ArrayList<>();
                for (Sports sports : generateTour.getSportsTours()) {
                    if (sports.getTypeOfTransport().equalsIgnoreCase(inputTransport) && sports.getTypeOfFood().equalsIgnoreCase(inputNutrition) && sports.getDays() == inputDays) {
                        resultSportsList.add(sports);
                    }
                }
                if (resultSportsList.isEmpty()) {
                    System.out.println("There are no variants or you wrote a wrong input");
                }
                else if (resultSportsList.size() > 1) {
                    System.out.println("Results sorted by price:");
                    Tour.print(Sports.sortByPrice(resultSportsList));
                }
                else {
                    Tour.print(Sports.sortByPrice(resultSportsList));
                }
            }
            case "shopping" -> {
                List<Shopping> resultShoppingList = new ArrayList<>();
                for (Shopping shopping : generateTour.getShoppingTours()) {
                    if (shopping.getTypeOfTransport().equalsIgnoreCase(inputTransport) && shopping.getTypeOfFood().equalsIgnoreCase(inputNutrition) && shopping.getDays() == inputDays) {
                        resultShoppingList.add(shopping);
                    }
                }
                if (resultShoppingList.isEmpty()) {
                    System.out.println("There are no variants or you wrote a wrong input");
                }
                else if (resultShoppingList.size() > 1) {
                    System.out.println("Results sorted by price:");
                    Tour.print(Shopping.sortByPrice(resultShoppingList));
                }
                else {
                    Tour.print(Shopping.sortByPrice(resultShoppingList));
                }
            }
            case "cruise" -> {
                List<Cruise> resultCruiseList = new ArrayList<>();
                for (Cruise cruise : generateTour.getCruiseTours()) {
                    if (cruise.getTypeOfFood().equalsIgnoreCase(inputNutrition) && cruise.getDays() == inputDays) {
                        resultCruiseList.add(cruise);
                    }
                }
                if (resultCruiseList.isEmpty()) {
                    System.out.println("There are no variants or you wrote a wrong input");
                }
                else if (resultCruiseList.size() > 1) {
                    System.out.println("Results sorted by price:");
                    Tour.print(Cruise.sortByPrice(resultCruiseList));
                }
                else {
                    Tour.print(Cruise.sortByPrice(resultCruiseList));
                }
            }
            case "excursion" -> {
                List<Excursion> resultExcursionList = new ArrayList<>();
                for (Excursion excursion : generateTour.getExcursionTours()) {
                    if (excursion.getTypeOfTransport().equalsIgnoreCase(inputTransport) && excursion.getTypeOfFood().equalsIgnoreCase(inputNutrition) && excursion.getDays() == inputDays) {
                        resultExcursionList.add(excursion);
                    }
                }
                if (resultExcursionList.isEmpty()) {
                    System.out.println("There are no variants or you wrote a wrong input");
                }
                else if (resultExcursionList.size() > 1) {
                    System.out.println("Results sorted by price:");
                    Tour.print(Excursion.sortByPrice(resultExcursionList));
                }
                else {
                    Tour.print(Excursion.sortByPrice(resultExcursionList));
                }
            }
            case "vacation" -> {
                List<Vacation> resultVacationList = new ArrayList<>();
                for (Vacation vacation : generateTour.getVacationTours()) {
                    if (vacation.getTypeOfTransport().equalsIgnoreCase(inputTransport) && vacation.getTypeOfFood().equalsIgnoreCase(inputNutrition) && vacation.getDays() == inputDays) {
                        resultVacationList.add(vacation);
                    }
                }
                if (resultVacationList.isEmpty()) {
                    System.out.println("There are no variants or you wrote a wrong input");
                }
                else if (resultVacationList.size() > 1) {
                    System.out.println("Results sorted by price:");
                    Tour.print(Vacation.sortByPrice(resultVacationList));
                }
                else {
                    Tour.print(Vacation.sortByPrice(resultVacationList));
                }
            }
            default -> System.out.println("Incorrect input");
        }
    }
}