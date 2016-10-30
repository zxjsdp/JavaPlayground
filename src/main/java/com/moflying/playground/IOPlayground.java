package com.moflying.playground;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOPlayground {
    private static final String relativeFilePath = "src/main/java/com/moflying/playground/ids.txt";

    private static List<String> playReadAllLinesFromFile() {
        try {
            URI uri = Paths.get(PathPlayground.getWorkingDir(), relativeFilePath).toUri();
            return Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(playReadAllLinesFromFile().size());
    }
}
