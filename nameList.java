import java.util.*;

public class nameList {
    public static void main(String[] args) {
        String[] persons = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        Map<String, Integer> nameCount = new HashMap<>();

        for (String person : persons) {
            String name = person.split(" ")[0];
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCount.entrySet());
        sortedNames.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        System.out.println("Повторяющиеся имена с количеством повторений:");
        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
