package src.ex03.Main;

import src.ex03.ArgumentProcessor.*;
import src.ex03.Download.*;
import src.ex03.UrlFileReader.*;

import java.util.ArrayList;
import java.io.*;

public class Program {

    public static void main(String[] args) {
        try {
            ArrayList<String> urls = UrlFileReader.read();
            int threadsCount = ArgumentProcessor.getCount(args);
            MultithreadingDownloader.download(urls, threadsCount);
        } catch (IOException | InterruptedException e) {
            System.err.println("Something went wrong when reading a file or working with a threads");
        }
    }
}