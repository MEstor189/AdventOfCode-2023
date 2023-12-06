package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day6 {

    public static void main(String[] args) {

        long time = 41968894L;
        long distance = 214178911271055L;

        for (long j = 0; j <= time; j++) {
            long newDistance = j * (time - j);
            if (newDistance > distance) {
                long erg = time - j - j + 1;
                System.out.println(erg);
                break;
            }
        }
    }
}
