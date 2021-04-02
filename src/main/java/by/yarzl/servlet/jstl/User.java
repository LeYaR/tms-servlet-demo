package by.yarzl.servlet.jstl;

import java.util.Random;

import static by.yarzl.servlet.RandomProvider.getRandom;

public class User {
    private int id;
    private String name;
    private boolean banned;
    private int period;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        Random r = getRandom();
        banned = r.nextBoolean();
        if (banned) {
            period = r.nextInt(id) + 1;
        }
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
