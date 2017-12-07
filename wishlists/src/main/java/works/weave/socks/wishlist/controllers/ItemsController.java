package works.weave.socks.wishlist.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import works.weave.socks.wishlist.wishlist.WishlistDAO;
import works.weave.socks.wishlist.wishlist.WishlistResource;
import works.weave.socks.wishlist.entities.Item;
import works.weave.socks.wishlist.item.FoundItem;
import works.weave.socks.wishlist.item.ItemDAO;
import works.weave.socks.wishlist.item.ItemResource;

import java.util.List;
import java.util.function.Supplier;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(value = "/wishlists/{customerId:.*}/items")
public class ItemsController {
    private final Logger LOG = getLogger(getClass());

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private WishlistsController wishlistsController;
    @Autowired
    private WishlistDAO wishlistDAO;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{itemId:.*}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Item get(@PathVariable String customerId, @PathVariable String itemId) {
        return new FoundItem(() -> getItems(customerId), () -> new Item(itemId)).get();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Item> getItems(@PathVariable String customerId) {
        return wishlistsController.get(customerId).contents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Item addToWishlist(@PathVariable String customerId, @RequestBody Item item) {
        // If the item does not exist in the wishlist, create new one in the repository.
        FoundItem foundItem = new FoundItem(() -> wishlistsController.get(customerId).contents(), () -> item);
        if (!foundItem.hasItem()) {
            Supplier<Item> newItem = new ItemResource(itemDAO, () -> item).create();
            LOG.debug("Did not find item. Creating item for user: " + customerId + ", " + newItem.get());
            new WishlistResource(wishlistDAO, customerId).contents().get().add(newItem).run();
            return item;
        } else {
            Item newItem = new Item(foundItem.get(), foundItem.get().quantity() + 1);
            LOG.debug("Found item in wishlist. Incrementing for user: " + customerId + ", " + newItem);
            updateItem(customerId, newItem);
            return newItem;
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{itemId:.*}", method = RequestMethod.DELETE)
    public void removeItem(@PathVariable String customerId, @PathVariable String itemId) {
        FoundItem foundItem = new FoundItem(() -> getItems(customerId), () -> new Item(itemId));
        Item item = foundItem.get();

        LOG.debug("Removing item from wishlist: " + item);
        new WishlistResource(wishlistDAO, customerId).contents().get().delete(() -> item).run();

        LOG.debug("Removing item from repository: " + item);
        new ItemResource(itemDAO, () -> item).destroy().run();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PATCH)
    public void updateItem(@PathVariable String customerId, @RequestBody Item item) {
        // Merge old and new items
        ItemResource itemResource = new ItemResource(itemDAO, () -> get(customerId, item.itemId()));
        LOG.debug("Merging item in wishlist for user: " + customerId + ", " + item);
        itemResource.merge(item).run();
    }
}
