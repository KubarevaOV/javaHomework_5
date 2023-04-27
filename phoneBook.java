import java.util.*;

public class phoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();
    
    public static void main(String[] args) {
        boolean isFinish = false;
        phoneBook phoneBook = new phoneBook();
        Scanner sc = new Scanner(System.in);

        while (!isFinish) {
            System.out.println("Введите 1) Добавление номера 2) Вывод всего");
            int action = sc.nextInt();

            if (action == 1) {
                System.out.println("Введите ФИО");
                String name = sc.next();
                System.out.println("Введите номер");
                String number = sc.next();
                phoneBook.addNumber(name, number);
            } else if (action == 2) {
                phoneBook.printAll();
                break;
            }
        }
    }

    public void addNumber(String name, String number) {
        List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<>());
        numbers.add(number);
        phoneBook.put(name, numbers);
    }

    public void printAll() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            System.out.println(name + ": " + String.join(", ", numbers));
        }
    }
}

