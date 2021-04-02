package by.yarzl.servlet;

import java.util.Random;

public class RandomProvider {

    private static final Random R = new Random();

    public static Random getRandom() {
        return R;
    }
}
