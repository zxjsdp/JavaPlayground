package com.moflying.playground;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOPlayground {
    private static final String relativeFilePath = "src/main/resources/ids.txt";

    /**
     * 从文件中一次性读取所有行
     *
     * @return 文件中所有行的列表
     */
    private static List<String> readAllLinesFromFile() {
        try {
            URI uri = Paths.get(PathPlayground.getWorkingDir(), relativeFilePath).toUri();
            return Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(readAllLinesFromFile().size());
    }
}
