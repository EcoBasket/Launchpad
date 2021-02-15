package com.launchpad.demo.controllers;

import com.launchpad.demo.models.RequestBodyItem;
import com.launchpad.demo.models.dynamodb.ShoppingList;
import com.launchpad.demo.services.ShoppingListService;
import com.launchpad.demo.util.AmazonExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/shopping/add/{id}")
    public ResponseEntity<ShoppingList> addItem(@PathVariable(name = "id") String id, @RequestBody RequestBodyItem shoppingList) {
        return AmazonExceptionHandler.handle(() -> ResponseEntity.ok(shoppingListService.addItem(id, shoppingList)));
    }

    @DeleteMapping("/shopping/delete/{shoppingListId}/{itemId}")
    public ResponseEntity<ShoppingList> deleteItem(@PathVariable(name = "shoppingListId") String shoppingListId, @PathVariable(name = "itemId") String itemId) {
        return AmazonExceptionHandler.handle(() -> ResponseEntity.ok(shoppingListService.deleteItem(shoppingListId, itemId)));
    }

    @GetMapping("/shopping/{id}")
    public ResponseEntity<?> getShoppingList(@PathVariable(name = "id") String shoppingListId) {
        return AmazonExceptionHandler.handle(() -> {
            Optional<ShoppingList> shoppingListOptional = shoppingListService.getShoppingList(shoppingListId);

            if (shoppingListOptional.isPresent())
                return ResponseEntity.ok(shoppingListOptional.get());
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }
}
