package org.example;

import org.example.services.FileProcessor;
import org.example.utils.CommandLineArgumentsParser;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        CommandLineArgumentsParser input = new CommandLineArgumentsParser(args);
        exitIfInputFilesIsEmpty(input);
        FileProcessor fileProcessor = new FileProcessor(input.getOutputPath(), input.getPrefix(), input.isAppendToExistingFile(),
                input.isFullStatistic(), input.isShortStatistic());
        fileProcessor.processFiles(input.getFileNames());
    }

    private static void exitIfInputFilesIsEmpty(CommandLineArgumentsParser input) {
        if (input.getFileNames().isEmpty()) {
            System.out.println("Список входных файлов пуст. Пожалуйста, перезапустите утилиту с корректными аргументами");
            System.exit(0);
        }
    }
}