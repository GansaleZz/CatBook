package util;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public final class TestUtil {

    public static long getRandomLong() {
        Random random = new Random();

        return random.nextLong();
    }

    public static String getRandomString(int length) {
        byte[] bytes = new byte[length];
        new Random().nextBytes(bytes);

        return new String(bytes, StandardCharsets.UTF_8);
    }

}
