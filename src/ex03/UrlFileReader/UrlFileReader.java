package src.ex03.UrlFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UrlFileReader {
    private static final String URLS_FILE = "files_urls.txt";

    public static ArrayList<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(URLS_FILE));
        String line;
        ArrayList<String> urls = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            urls.add(line);
        }
        return urls;
    }
}
