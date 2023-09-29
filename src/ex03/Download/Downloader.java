package src.ex03.Download;

import java.io.*;
import java.net.*;

class Downloader extends Thread {
    private final int KB = 1024;
    private String url;
    private int fileNumber;

    public Downloader(String url, int fileNumber) {
        this.url = url;
        this.fileNumber = fileNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start download file number " + fileNumber);
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream("file" + fileNumber + ".jpg");

            byte[] buffer = new byte[KB];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println(Thread.currentThread().getName() + " finish download file number " + fileNumber);
        } catch (IOException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }
}