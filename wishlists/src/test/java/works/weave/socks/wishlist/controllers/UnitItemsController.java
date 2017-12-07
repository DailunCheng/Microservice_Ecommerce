package works.weave.socks.wishlist.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import works.weave.socks.wishlist.wishlist.WishlistDAO;
import works.weave.socks.wishlist.entities.Item;
import works.weave.socks.wishlist.item.ItemDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UnitItemsController {

    @Autowired
    private ItemsController itemsController;

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private WishlistsController wishlistsController;

    @Test
    public void whenNewItemAdd() {
        Item item = new Item("id", "itemId", 1, 0F);
        String customerId = "customerIdAdd";
        itemsController.addToWishlist(customerId, item);
        assertThat(itemsController.getItems(customerId), is(hasSize(1)));
        assertThat(itemsController.getItems(customerId), is(org.hamcrest.CoreMatchers.hasItem(item)));
    }

    @Test
    public void whenExistIncrementQuantity() {
        Item item = new Item("id", "itemId", 1, 0F);
        String customerId = "customerIdIncrement";
        itemsController.addToWishlist(customerId, item);
        itemsController.addToWishlist(customerId, item);
        assertThat(itemsController.getItems(customerId), is(hasSize(1)));
        assertThat(itemsController.getItems(customerId), is(org.hamcrest.CoreMatchers.hasItem(item)));
        assertThat(itemDAO.findOne(item.id()).quantity(), is(equalTo(2)));
    }

    @Test
    public void shouldRemoveItemFromWishlist() {
        Item item = new Item("id", "itemId", 1, 0F);
        String customerId = "customerIdRemove";
        itemsController.addToWishlist(customerId, item);
        assertThat(itemsController.getItems(customerId), is(hasSize(1)));
        itemsController.removeItem(customerId, item.itemId());
        assertThat(itemsController.getItems(customerId), is(hasSize(0)));
    }

    @Test
    public void shouldSetQuantity() {
        Item item = new Item("id", "itemId", 1, 0F);
        String customerId = "customerIdQuantity";
        itemsController.addToWishlist(customerId, item);
        assertThat(itemsController.getItems(customerId).get(0).quantity(), is(equalTo(item.quantity())));
        Item anotherItem = new Item(item, 15);
        itemsController.updateItem(customerId, anotherItem);
        assertThat(itemDAO.findOne(item.id()).quantity(), is(equalTo(anotherItem.quantity())));
    }

    @Configuration
    static class ItemsControllerTestConfiguration {
        @Bean
        public ItemsController itemsController() {
            return new ItemsController();
        }

        @Bean
        public WishlistsController wishlistsController() {
            return new WishlistsController();
        }

        @Bean
        public ItemDAO itemDAO() {
            return new ItemDAO.Fake();
        }

        @Bean
        public WishlistDAO wishlistDAO() {
            return new WishlistDAO.Fake();
        }
    }
}
