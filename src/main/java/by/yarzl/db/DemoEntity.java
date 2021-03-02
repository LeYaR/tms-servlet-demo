package by.yarzl.db;

// Для работы движков конвертации в JSON необходимо определить сеттеры и геттеры для всех полей,
// даже для тех, которые не используются явно
public class DemoEntity {
    private int id;
    private String name;

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
