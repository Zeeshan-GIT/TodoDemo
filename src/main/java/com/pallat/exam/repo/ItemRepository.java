package com.pallat.exam.repo;

import com.pallat.exam.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    JdbcTemplate template;

    /* Getting all Items from table */
    public List<Item> getAllItems() {
        List<Item> items = template.query("select Id, Name from Item",
                (result, rowNum) -> new Item(result.getInt("id"), result.getString("name")));
        return items;
    }

    /* Updating a specific item by item id from table */
    public int updateItem(int itemId, String name) {
        System.out.println("inside update");
        String query = "UPDATE Item SET Name = ? where id = ?";
        return template.update(query, name, itemId);
    }

    /* Adding an item into database table */
    public int addItem(int id, String name) {
        String query = "INSERT INTO Item VALUES(?,?)";
        return template.update(query, id, name);
    }

    /* delete an item from database */
    public int deleteItem(int id) {
        String query = "DELETE FROM Item WHERE Id =?";
        return template.update(query, id);
    }
}