package org.example.services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class FileWriterService {
    private final Path outputDirectory;
    private final String prefix;
    private final boolean appendMode;
    private final Map<String, BufferedWriter> writers = new HashMap<>();

    public FileWriterService(String outputDirectory, String prefix, boolean appendMode) {
        this.outputDirectory = Paths.get(outputDirectory);
        this.prefix = prefix;
        this.appendMode = appendMode;
    }

    public void writeToFile(String type, String line) {
        try {
            BufferedWriter writer = writers.computeIfAbsent(type, this::openWriter);
            if (writer != null) {
                writer.write(line);
                writer.newLine();
            } else {
                System.out.println("Ошибка записи в файл: не удалось открыть writer для типа " + type);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e);
        }
    }

    private BufferedWriter openWriter(String type) {
        try {
            Path directory = outputDirectory;
            if (Files.notExists(directory)) {
                try {
                    Files.createDirectories(directory);
                } catch (IOException e) {
                    System.out.println("Не удалось создать директорию. Используется текущая директория.");
                    directory = Paths.get(".");
                }
            }
            Path filePath = directory.resolve(prefix + type + "s.txt");
            if (Files.notExists(filePath)) {
                return Files.newBufferedWriter(filePath, StandardOpenOption.CREATE);
            } else {
                return Files.newBufferedWriter(filePath, appendMode ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла " + type + ": " + e.getMessage());
            return null;
        }
    }

    public void closeWriters() {
        for (BufferedWriter writer : writers.values()) {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла: " + e.getMessage());
            }
        }
    }
}
