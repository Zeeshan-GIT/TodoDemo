package com.pallat.exam.controller;

import com.pallat.exam.model.Item;
import com.pallat.exam.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getAllItems() {
        return itemRepo.getAllItems();
    }

    @RequestMapping("/updateItem")
    @ResponseBody
    public String updateItem(@RequestParam("itemId") int itemId, @RequestParam("name") String name) {
        if (itemRepo.updateItem(itemId,name) >= 1) {
            return "Item Updated Successfully";
        } else {
            return "Something went wrong !";
        } 
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id, @RequestParam("name") String name) {
        if (itemRepo.addItem(id, name) >= 1) {
            return "Item Added Successfully";
        } else {
            return "Something went wrong !";
        }
    }

    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId) {
        if (itemRepo.deleteItem(itemId) >= 1) {
            return "Item Deleted Successfully";
        } else {
            return "Something went wrong !";
        }
    }
}