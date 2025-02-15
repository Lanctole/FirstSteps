package org.example.services;

import org.example.types.ValueType;
import org.example.utils.TypeDetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessor {
    private final FileWriterService fileWriterService;
    private final StatisticService statisticService;
    private final boolean isNeedStatistic, isFullStatistic;

    public FileProcessor(String outputDirectory, String prefix, boolean appendMode, boolean isFullStatistic, boolean isShortStatistic) {
        this.fileWriterService = new FileWriterService(outputDirectory, prefix, appendMode);
        this.statisticService = new StatisticService();
        this.isNeedStatistic = isShortStatistic || isFullStatistic;
        this.isFullStatistic = isFullStatistic;
    }

    public void processFiles(List<String> fileNames) {
        for (String fileName : fileNames) {
            processFile(fileName);
        }
        fileWriterService.closeWriters();
        if (isNeedStatistic) {
            statisticService.printStatistics(isFullStatistic);
        }
    }

    private void processFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private void processLine(String line) throws IOException {
        ValueType type = TypeDetector.getType(line);
        if (isNeedStatistic) {
            processStatistic(type, line);
        }
        fileWriterService.writeToFile(type.name().toLowerCase(), line);
    }

    private void processStatistic(ValueType type, String line) {
        switch (type) {
            case INTEGER ->
                    statisticService.addValueToStatistic(ValueType.INTEGER, Long.parseLong(line.trim()), isFullStatistic);
            case FLOAT ->
                    statisticService.addValueToStatistic(ValueType.FLOAT, Double.parseDouble(line.trim()), isFullStatistic);
            case STRING -> statisticService.addValueToStatistic(ValueType.STRING, line, isFullStatistic);
        }
    }
}