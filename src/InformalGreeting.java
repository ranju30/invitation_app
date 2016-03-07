import java.util.List;

public class InformalGreeting {
    private String fileName;
    private String countryName;
    private String drinkCondition;

    public InformalGreeting(String[] args) {
        this.fileName = args[0];
        this.countryName = args[1];
        this.drinkCondition = args[2];
    }


    public void getInformalRepresentation() {
        ReadFile readFile = new ReadFile(fileName);
        List<String> lines = readFile.getList();
        for (String line : lines) {
            String[] array = line.split(",");
            Gender g = array[2].contains("Female") ? Gender.Female : Gender.Male;
            Age age = new Age(array[3]);
            Boolean conditionOfDrinking = age.isLegal(drinkCondition);
            if(array[6].contains(countryName) && conditionOfDrinking) {
                Guest eachGuest = new Guest(array[0], array[1], g, array[3], array[4], array[5], array[6]);
                System.out.println(eachGuest.getInformalLegalAgedGuest());
            }
        }
    }
}