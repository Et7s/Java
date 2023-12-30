public class Main {
    public static void main(String[] args) {
        //Создаем DataManager
        DataManager manager = new DataManager();

        First processor1 = new First();
        Second processor2 = new Second();
        GGww processor3 = new GGww();

        //Регистрируем обработчик данных
        manager.registerDataProcessor(processor1);
        manager.registerDataProcessor(processor2);
        manager.registerDataProcessor(processor3);
        //Загружаем данные из файла 123
        manager.loadData("src/123.txt");
        //Обрабатываем данные параллельно с использованием Stream API
        manager.processData();
        //Сохраняем обработанные данные в новый файл 321
        manager.saveData("src/321.txt");
    }
}