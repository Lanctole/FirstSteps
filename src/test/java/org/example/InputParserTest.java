package org.example;

import org.example.utils.InputParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputParserTest {

    @Test
    void testFlagsParsing() {
        String[] args = {"-s", "-f", "-a"};
        InputParser parser = new InputParser(args);
        assertTrue(parser.isShortStatistic());
        assertTrue(parser.isFullStatistic());
        assertTrue(parser.isAppend());
    }

    @Test
    void testValidOutputPath() {
        String[] args = {"-o", "valid/path"};
        InputParser parser = new InputParser(args);
        assertEquals("valid/path", parser.getOutputPath());
    }

    @Test
    void testInvalidOutputPath() {
        String[] args = {"-o", "*&path"};
        InputParser parser = new InputParser(args);
        assertEquals(".", parser.getOutputPath());
    }

    @Test
    void testValidPrefix() {
        String[] args = {"-p", "output"};
        InputParser parser = new InputParser(args);
        assertEquals("output", parser.getPrefix());
    }

    @Test
    void testInvalidPrefix() {
        String[] args = {"-p", "*@prefix!"};
        InputParser parser = new InputParser(args);
        assertEquals("", parser.getPrefix());
    }

    @Test
    void testFileNames() {
        String[] args = {"file1.txt", "file2.log", "-s", "-o", "output"};
        InputParser parser = new InputParser(args);
        List<String> fileNames = parser.getFileNames();
        assertEquals(2, fileNames.size());
        assertTrue(fileNames.contains("file1.txt"));
        assertTrue(fileNames.contains("file2.log"));
    }

    @Test
    void testIncorrectFlagUsage() {
        String[] args = {"-o"};
        InputParser parser = new InputParser(args);
        assertEquals(".", parser.getOutputPath());
    }
}