package by.yarzl.servlet.jstl;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    public List<User> getUsers() {
        List<User> res = new ArrayList<>();
        User u1 = new User(1, "Bob");
        User u2 = new User(2, "Dina");
        User u3 = new User(3, "Alex");
        User u4 = new User(4, "John");
        User u5 = new User(5, "Ann");
        User u6 = new User(6, "Helen");
        User u7 = new User(7, "Jack");

        res.add(u1);
        res.add(u2);
        res.add(u3);
        res.add(u4);
        res.add(u5);
        res.add(u6);
        res.add(u7);

        return res;
    }
}
