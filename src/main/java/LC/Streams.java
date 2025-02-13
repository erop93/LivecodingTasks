import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        String filePath = "example.txt";
        String filterWord = "Java";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines
                    .filter(l -> l.contains(filterWord))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("error");
        }

    }
}

