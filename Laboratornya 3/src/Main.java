public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Капитанская дочка", "А.С. Пушкин", 100000000);
        Book book2 = new Book("Дело о конокрадстве", "М.Г. Розовский", 10000);
        Book book3 = new Book("Чайка по имени Джонатан Ливингстон", "Ричард Бах", 600000);

        HashTable<Long, Book> hashTable = new HashTable<>();

        hashTable.put(9785928733247L, book1);
        hashTable.put(5969702889L, book2);
        hashTable.put(9785907097261L, book3);


        System.out.println(hashTable.get(9785928733247L));
        hashTable.remove(9785928733247L);
        System.out.println(hashTable.get(9785928733247L));

        System.out.println("Количество элементов таблицы: " + hashTable.size());
        System.out.println("Пустая таблица: " + hashTable.isEmpty());
        hashTable.printTable();
        System.out.println("9785928733247L".hashCode());
        System.out.println("5969702889L".hashCode());
        System.out.println("9785907097261L".hashCode());
        System.out.println("978590709726L".hashCode());

    }
}