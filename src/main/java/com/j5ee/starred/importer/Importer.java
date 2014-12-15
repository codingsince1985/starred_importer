package com.j5ee.starred.importer;

import com.google.gson.Gson;
import com.j5ee.starred.importer.domain.Item;
import com.mongodb.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Importer {
    public static void main(String[] args) {
        Importer.class.getClass().getClassLoader();
        InputStream is = ClassLoader.getSystemResourceAsStream("starred.json");
        try {
            String jsonString = IOUtils.toString(is);
            System.out.println(jsonString.length());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            System.out.println(jsonObject.getItems().size());

            MongoClient client = new MongoClient(new ServerAddress("localhost",
                    27017));
            DB database = client.getDB("reader");
            DBCollection collection = database.getCollection("starred");

            List<Item> items = jsonObject.getItems();
            int count = 0;
            for (Item item : items) {
                String title = item.getTitle();
                String content = null;
                if (item.getSummary() == null && item.getContent() == null) {
                    System.out.println(item.getTitle());
                    continue;
                }

                if (item.getSummary() != null) {
                    content = item.getSummary().getContent();
                } else if (item.getContent() != null) {
                    content = item.getContent().getContent();
                }

                String link = item.getAlternate().get(0).getHref();

                String feedTitle = item.getOrigin().getTitle();
                String pubDate = new Date(item.getPublished() * 1000L)
                        .toString();

                BasicDBObject object = new BasicDBObject();
                object.append("_id", ++count).append("title", title)
                        .append("description", content).append("link", link)
                        .append("feedTitle", feedTitle)
                        .append("pubDate", pubDate);
                collection.insert(object);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
