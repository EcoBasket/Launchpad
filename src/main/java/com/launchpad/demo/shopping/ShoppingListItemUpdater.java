package com.launchpad.demo.shopping;

import com.launchpad.demo.models.dynamodb.Item;
import com.launchpad.demo.models.dynamodb.ShoppingList;
import com.launchpad.demo.util.ListUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Supplier;

public class ShoppingListItemUpdater {

    private final Supplier<ShoppingList> originalShoppingListSupplier;

    public ShoppingListItemUpdater(ShoppingList shoppingList) {
        this.originalShoppingListSupplier = () -> shoppingList;
    }

    public ShoppingList addItem(Item item) {
        ShoppingList shopping = originalShoppingListSupplier.get();
        return integrateItemIntoShoppingList(shopping, item);
    }

    public ShoppingList removeItem(String id) {
        ShoppingList shopping = originalShoppingListSupplier.get();
        return removeItemFromShoppingList(shopping, id);
    }

    private ShoppingList integrateItemIntoShoppingList(ShoppingList shopping, Item item) {
        addItemTo(shopping, item);
        updatePriceFor(shopping, item.getPrice());
        updateScoreFor(shopping);
        return shopping;
    }

    private ShoppingList removeItemFromShoppingList(ShoppingList shopping, String id) {
        Item targetItem = getItemWithId(shopping, id);
        removeItemFrom(shopping, targetItem);
        updatePriceFor(shopping, -targetItem.getPrice());
        updateScoreFor(shopping);
        return shopping;
    }

    private Item getItemWithId(ShoppingList shopping, String id) {
        System.out.println(id);
        shopping.getItems().stream().map(Item::getId).forEach(System.out::println);
        return shopping.getItems()
                .stream()
                .filter(item -> item.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Item wasn't found - i mean someone seriously dun fucked up if you get this lmfao " +
                                        "its literally a fucking gui how in the actual fuck did you get this"));
    }

    private ShoppingList removeItemFrom(ShoppingList shopping, Item item) {
        List<Item> itemList = ListUtils.copyOf(shopping.getItems());
        itemList.remove(item);
        shopping.setItems(itemList);
        return shopping;
    }

    // updates price for original shopping list
    private ShoppingList addItemTo(ShoppingList shopping, Item item) {
        List<Item> itemList = ListUtils.copyOf(shopping.getItems()); // in case DynamoDB makes this an immutable list
        itemList.add(item);
        shopping.setItems(itemList);
        return shopping;
    }

    private ShoppingList updateScoreFor(ShoppingList shoppingList) {
        shoppingList.setScore(ScoreProvider.buildScoreFrom(new ShoppingListScoreHandler(shoppingList).getShoppingListScore()));
        return shoppingList;
    }

    private ShoppingList updatePriceFor(ShoppingList shoppingList, Integer price) {
        shoppingList.setPrice(shoppingList.getPrice() + price);
        return shoppingList;
    }
}
