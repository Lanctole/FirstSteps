package org.example;

import org.example.services.FileProcessor;
import org.example.utils.InputParser;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        InputParser input = new InputParser(args);
        FileProcessor fileProcessor = new FileProcessor(input.getOutputPath(), input.getPrefix(), input.isAppend(),
                input.isFullStatistic(), input.isShortStatistic());
        fileProcessor.processFiles(input.getFileNames());
    }
}