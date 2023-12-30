import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.Method;

public class DataManager {
    private LinkedList<Object> processors;
    private ExecutorService service;
    private HashMap<String, Integer> data;
    private StringBuilder outputData;
    public DataManager() {
        processors = new LinkedList<>();
        service = Executors.newFixedThreadPool(10);
        data = new HashMap<>();
        outputData = new StringBuilder();
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        File file = new File(source);
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] dataSet = line.split(" ");
                data.put(dataSet[0], Integer.parseInt(dataSet[1]));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processData() {
        ArrayList<Future<String>> futures = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int i = 0;
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.getAnnotation(DataProcessor.class) != null) {
                    indexes.add(0);
                    futures.add(service.submit(() -> {
                        try {
                            return (String) method.invoke(processor, data);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }));
                    indexes.set(i, futures.size());
                    i++;
                }
            }
        }
        int j = 0;
        for (Future<String> f : futures) {
            try {
                outputData.append(f.get());
                j++;
                for (int index: indexes) {
                    if (j == index) {
                        outputData.append("\n");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public void saveData(String outputFile) {
        File file = new File(outputFile);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}