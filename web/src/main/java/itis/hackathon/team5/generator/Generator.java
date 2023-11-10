package itis.hackathon.team5.generator;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.Random;

public class Generator {
    private static final Random random = new Random();

    public static String getString(String fileName) throws IOException {
        Dataset dataset = new Dataset(fileName);
        return dataset.getNext();
    }

//    from 0 until bound
    public static Integer getInt(int bound) {
        return random.nextInt(bound);
    }

    public static Integer getInt(int from, int bound) {
        return random.nextInt(bound - from) + from;
    }

// from 0 until bound
    public static BigInteger getBigInt(BigInteger bound) {
        BigInteger randomNumber;
        do {
            randomNumber = new BigInteger(bound.bitLength(), random);
        } while (randomNumber.compareTo(bound) >= 0);
        return randomNumber;
    }


//    String format "yyyy-mm-dd hh:mm:ss"
    public static Timestamp getTimestamp(String from, String to) {
        long offset = Timestamp.valueOf(from).getTime();
        long end = Timestamp.valueOf(to).getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + random.nextInt(100) * diff / 100);
    }

    public static Boolean getBoolean() {
        return random.nextBoolean();
    }

    public static Double getDouble() {
        return random.nextDouble();
    }

    public static Float getFloat() {
        return random.nextFloat();
    }

    public static String getPhone() {
        return  "+7 (9" +
                 (random.nextInt(90) + 10) +
                ")-" +
                (random.nextInt(900) + 100) +
                "-" +
                (random.nextInt(90) + 10) +
                "-" +
                (random.nextInt(90) + 10);
    }
}
