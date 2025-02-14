package org.example.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InputParser {
    private String outputPath = ".";
    private String prefix = "";
    private boolean isAppend, isShortStatistic, isFullStatistic;
    private List<String> fileNames = new ArrayList<>();

    public InputParser(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-s" -> isShortStatistic = true;
                case "-f" -> isFullStatistic = true;
                case "-a" -> isAppend = true;
                case "-o", "-p" -> i = parseKeyValueArgument(args, i);
                default -> fileNames.add(args[i]);
            }
        }
    }

    private int parseKeyValueArgument(String[] args, int i) {
        if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
            System.out.println("Ошибка: после " + args[i] + " должно идти значение, а не флаг или пустота.");
            return i;
        }

        String value = args[++i];
        boolean isOutputPath = "-o".equals(args[i - 1]);
        boolean isPrefix = !isOutputPath;

        if (isOutputPath && PathAndFileNameValidator.isValidDirectory(value)) {
            outputPath = value;
        } else if (isPrefix && PathAndFileNameValidator.isValidFileName(value)) {
            prefix = value;
        } else {
            System.out.println("Ошибка: указанный " + (isOutputPath ? "путь" : "префикс") + " некорректен: " + value +
                    (isOutputPath ? " выбран путь по умолчанию" : " используются имена по умолчанию"));
        }
        return i;
    }
}