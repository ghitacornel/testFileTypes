package utils;

import java.util.Objects;

public class FileUtils {

    public static String read(String fileName) {
        try {
            return new String(Objects.requireNonNull(FileUtils.class.getClassLoader().getResourceAsStream(fileName)).readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException("cannot read file " + fileName, e);
        }
    }
}
