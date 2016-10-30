package com.moflying.playground;

import java.io.File;
import java.nio.file.Paths;

public class PathPlayground {
    /**
     * 获取当前项目的绝对路径
     */
    private static String playGetWorkingDir() {
        String workingDir = System.getProperty("user.dir");
        return workingDir;
    }

    /**
     * 尝试获得合并后的路径
     */
    private static void playPathJoin() {
        System.out.println(new File(
                playGetWorkingDir(),
                "src/main/java/com/moflying/playground/PathPlayground.java"
        ).getPath());

        System.out.println(joinPath(
                playGetWorkingDir(),
                "src/main/java/com/moflying/playground/PathPlayground.java"));

        System.out.println(joinPath(
                playGetWorkingDir(),
                "src/main/java/com",
                "moflying/playground/PathPlayground.java"));
    }

    /**
     * 使用 java.nio.file.Paths.get() 根据多个已有路径合并为新的路径（推荐）
     *
     * @param path1 路径1
     * @param path2 路径2
     * @param path3 路径3
     * @return 合并后的路径
     */
    public static String joinPath (String path1, String path2, String path3) {
        return Paths.get(path1, path2, path3).toAbsolutePath().toString();
    }

    /**
     * 根据两个已有路径合并为新的路径（不推荐，应该使用 Paths.get(String path1, String path2, String path3, ...)）
     *
     * @param path1 路径1
     * @param path2 路径2
     * @return 合并后的路径
     */
    public static String joinPath (String path1, String path2) {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }

    public static void main(String[] args) {
//        playGetWorkingDir();
        playPathJoin();
    }
}
