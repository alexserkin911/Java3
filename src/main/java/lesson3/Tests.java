package lesson3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class Tests {

    public static void main(String[] args) throws IOException {

//        InputStream stream = Tests.class.getResourceAsStream("data.txt");
//        String s = "-1";
//        while ((s = IoUtils.readWord(stream)) != null) {
//            System.out.println(s);
//        }

        OutputStream os = new FileOutputStream("out.txt", true);
        IoUtils.writeString(os,"Hello data");

    }
}
