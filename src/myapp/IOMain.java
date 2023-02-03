package myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOMain {

    public static void main(String args[]) throws IOException  {

        System.out.printf("args.length: %d\n", args.length);
        for (String a : args) {
            System.out.printf(">>> %s\n", a);
        }
        
        // get a ref to the file
        Path p = Paths.get(args[0]);

        // get the actual file object
        File f = p.toFile();
        System.out.printf("Exists? %b\n", f.exists());
        System.out.printf("Is file? %b\n", f.isFile());
        System.out.printf("Is directory? %b\n", f.isDirectory());
        System.out.printf("Can read? %b\n", f.canRead());
        System.out.printf("Full path: %s\n", f.getAbsolutePath());

        InputStream is = new FileInputStream(f);
        OutputStream os = new FileOutputStream("Copy of %s".formatted(args[0]));
        byte[] buffer = new byte[1024]; // 1K buffer
        int size = 0;

        while ((size = is.read(buffer)) >= 0) {
            os.write(buffer, 0, size);
        }

        os.flush();
        os.close();

        is.close();

    }
    
}
