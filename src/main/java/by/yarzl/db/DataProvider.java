package by.yarzl.db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProvider {

    private final List<DemoEntity> entities = new ArrayList<>();
    private static volatile DataProvider provider;
    // Это поле используется для генерации ID, Вам оно не понадобится, поскольку ID генерирует база данных
    private static final AtomicInteger atomicId = new AtomicInteger(1);

    // Строки кода с 13 по 27 отвечают за создание DataProvider только в одном экземпляре, чтобы избежать потери данных при работе через разные потоки
    // При реализации работы с JDBC слоем эта функциональность Вам не понадобится, Ваши данные хранятся в базе а не в оперативной памяти
    private DataProvider() {
    }

    public static DataProvider getProvider() {
        DataProvider localProvider = provider;
        if (localProvider == null) {
            synchronized (DataProvider.class) {
                localProvider = provider;
                if (localProvider == null) {
                    provider = localProvider = new DataProvider();
                }
            }
        }
        return localProvider;
    }

    public List<DemoEntity> getAllEntities() {
        // TODO: реализовать получение всех записей через слой БД
        return entities;
    }

    public void addEntity(DemoEntity entity) {
        // TODO: реализовать добавление записи в слое БД
        entity.setId(atomicId.getAndIncrement());
        entities.add(entity);
    }

    public void deleteEntityById(int id) throws Exception{
        // TODO: реализовать удаление через слой БД
        DemoEntity toDelete = entities.stream().filter(entity -> entity.getId() == id).findFirst().orElseThrow(() -> new Exception("No entity with id: " + id));
        entities.remove(toDelete);
    }
}
