package io.reader;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class WriteByOutputStreamWriter {
    public static void main(String[] args) {

        System.out.println(Charset.defaultCharset());
        try(FileOutputStream fis = new FileOutputStream("C:\\java\\char_1.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fis, "UTF8");
            //BufferedWriter bw = new BufferedWriter(osw)
        ){
        	
            osw.write("中文測試2");
            
            //OutputStreamWriter內建有Buffer,8192bytes
            //buffer被清空的條件有兩個1.滿了2.close被呼叫了
            //強制清空要呼叫flush()
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
