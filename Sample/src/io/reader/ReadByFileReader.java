package io.reader;

import java.io.*;
import java.nio.charset.Charset;

public class ReadByFileReader {
    public static void main(String[] args) throws IOException {

        System.out.println("JVM Encoding＝"+Charset.defaultCharset());

        try(FileReader fr = new FileReader("C:\\java\\char_UTF8.txt")){
            
            //改成InputSteamReader
            /*  FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "MS950");
                BufferedReader br = new BufferedReader(isr)
                */
                int c;
                while ((c = fr.read()) != -1) {
                    System.out.println((char) c);
                }
            //}

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
