// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestDataManager {

    private static final ThreadLocal<TestConfig> configThreadLocal = new ThreadLocal<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
    private static final ThreadLocal<String> timestampThreadLocal = ThreadLocal.withInitial(() -> LocalDateTime.now().format(formatter));
    private static final ConcurrentHashMap<String, Object> testData = new ConcurrentHashMap<>();

    public static void setStringTestData(String testDataName, String data) {
        testData.put(testDataName, data);
    }

    public static String getStringTestData(String testDataName) {
        return (String) testData.get(testDataName);
    }

    public static void clearAllTestData() {
        testData.clear();
    }

    public static String getTimestamp() {
        return timestampThreadLocal.get();
    }

    public static void updateTimestamp() {
        timestampThreadLocal.set(LocalDateTime.now().format(formatter));
    }

    public static TestConfig getTestConfig() {
        if (configThreadLocal.get() == null) {
            try {
                String path = System.getProperty("user.dir") + "/src/test/resources/data/test_config.yml";
                InputStream stream = new FileInputStream(path);
                TestConfig testConfig = new Yaml().loadAs(stream, TestConfig.class);
                configThreadLocal.set(testConfig);
            } catch (FileNotFoundException e) {
                throw new Error(e);
            }
        }
        return configThreadLocal.get();
    }

    public static Map<String, Object> getMapFromYamlFile(String fileName) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
        try (InputStream stream = new FileInputStream(path)) {
            Yaml yaml = new Yaml();
            return yaml.load(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new Error("Error reading the file", e);
        }
    }

    public static byte[] getBytesFromFile(String fileName, String extension) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + extension;
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("File not found: " + path);
        }
        byte[] fileBytes = new byte[(int) file.length()];
        try (FileInputStream stream = new FileInputStream(file)) {
            stream.read(fileBytes);
        } catch (IOException e) {
            throw new Error(e);
        }
        return fileBytes;
    }

    public static void saveToFile(String fileName, String extension, byte[] fileBytes) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + extension;
        try (FileOutputStream stream = new FileOutputStream(path)) {
            stream.write(fileBytes);
            stream.flush();
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
