package com.moflying.playground;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOPlayground {
    private static final String RELATIVE_FILE_PATH = "src/main/resources/ids.txt";

    /**
     * 从文件中一次性读取所有行
     *
     * @return 文件中所有行的列表
     */
    private static List<String> readAllLinesFromFile() {
        try {
            URI uri = Paths.get(PathPlayground.getWorkingDir(), RELATIVE_FILE_PATH).toUri();
            return Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    /**
     * 以 stream 的形式从文件中读取 lines
     */
    private static void playLinesReadingToStream() throws IOException {
        try (Stream<String> lineStream = Files.lines(Paths.get(RELATIVE_FILE_PATH))) {
            List<Integer> result = lineStream
                    .map(Integer::valueOf)
                    .filter(x -> x > 2000)
                    .collect(Collectors.toList());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(readAllLinesFromFile().size());
        playLinesReadingToStream();
    }
}
