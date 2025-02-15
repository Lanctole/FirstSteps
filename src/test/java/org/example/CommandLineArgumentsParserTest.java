package org.example;

import org.example.utils.CommandLineArgumentsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLineArgumentsParserTest {

    @Test
    void testFlagsParsing() {
        String[] args = {"-s", "-f", "-a"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertTrue(parser.isShortStatistic());
        assertTrue(parser.isFullStatistic());
        assertTrue(parser.isAppendToExistingFile());
    }

    @Test
    void testValidOutputPath() {
        String[] args = {"-o", "valid/path"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertEquals("valid/path", parser.getOutputPath());
    }

    @Test
    void testInvalidOutputPath() {
        String[] args = {"-o", "*&path"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertEquals(".", parser.getOutputPath());
    }

    @Test
    void testValidPrefix() {
        String[] args = {"-p", "output"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertEquals("output", parser.getPrefix());
    }

    @Test
    void testInvalidPrefix() {
        String[] args = {"-p", "*@prefix!"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertEquals("", parser.getPrefix());
    }

    @Test
    void testFileNames() {
        String[] args = {"file1.txt", "file2.log", "-s", "-o", "output"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        List<String> fileNames = parser.getFileNames();
        assertEquals(2, fileNames.size());
        assertTrue(fileNames.contains("file1.txt"));
        assertTrue(fileNames.contains("file2.log"));
    }

    @Test
    void testIncorrectFlagUsage() {
        String[] args = {"-o"};
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        assertEquals(".", parser.getOutputPath());
    }
}