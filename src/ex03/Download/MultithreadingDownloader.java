package src.ex03.Download;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingDownloader {
    public static void download(ArrayList<String> urls, int threadsCount) throws InterruptedException {
        List<Downloader> threads = new ArrayList<>();

        for (int i = 0; i < urls.size(); i += threadsCount) {
            for (int j = 0; j < threadsCount && (i + j < urls.size()); j++) {
                Downloader thread = new Downloader(urls.get(i + j), i + j + 1);
                thread.start();
                threads.add(thread);
            }

            for (Downloader thread : threads) {
                thread.join();
            }
        }

    }
}
