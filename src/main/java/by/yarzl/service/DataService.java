package by.yarzl.service;

import by.yarzl.db.DataProvider;
import by.yarzl.db.DemoEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

// Вся валидация и работа с конвертированием данных находится на уровне сервиса
public class DataService {
    private final DataProvider dataProvider;
    private final ObjectMapper mapper;

    public DataService() {
        dataProvider = DataProvider.getProvider();
        mapper = new ObjectMapper();
    }

    public String getAllEntitiesForResponse() throws IOException {
        List<DemoEntity> entities = dataProvider.getAllEntities();

        // Пример конверсии сделан на Jackson, в Вашей домашней работе используйте GSON ;)
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, entities);

        return out.toString();
    }

    public void addEntity(String entityString) throws JsonProcessingException {
        // Пример конверсии сделан на Jackson, в Вашей домашней работе используйте GSON ;)
        DemoEntity demoEntity = mapper.readValue(entityString, DemoEntity.class);
        dataProvider.addEntity(demoEntity);
    }

    public void deleteEntity(String id) throws Exception{
        // TODO: Валидация значения
        int intId = Integer.parseInt(id);
        dataProvider.deleteEntityById(intId);
    }
}
