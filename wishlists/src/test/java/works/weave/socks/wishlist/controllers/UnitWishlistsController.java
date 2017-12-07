package works.weave.socks.wishlist.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import works.weave.socks.wishlist.wishlist.WishlistDAO;
import works.weave.socks.wishlist.entities.Wishlist;
import works.weave.socks.wishlist.entities.Item;
import works.weave.socks.wishlist.item.ItemDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UnitWishlistsController {

    @Autowired
    private ItemsController itemsController;

    @Autowired
    private WishlistDAO wishlistDAO;

    @Autowired
    private WishlistsController wishlistsController;


    @Test
    public void shouldGetWishlist() {
        String customerId = "customerIdGet";
        Wishlist wishlist = new Wishlist(customerId);
        wishlistDAO.save(wishlist);
        Wishlist gotWishlist = wishlistsController.get(customerId);
        assertThat(gotWishlist, is(equalTo(wishlist)));
        assertThat(wishlistDAO.findByCustomerId(customerId).get(0), is(equalTo(wishlist)));
    }

    @Test
    public void shouldDeleteWishlist() {
        String customerId = "customerIdGet";
        Wishlist wishlist = new Wishlist(customerId);
        wishlistDAO.save(wishlist);
        wishlistsController.delete(customerId);
        assertThat(wishlistDAO.findByCustomerId(customerId), is(empty()));
    }

    @Test
    public void shouldMergeItemsInWishlistsTogether() {
        String customerId1 = "customerId1";
        Wishlist wishlist1 = new Wishlist(customerId1);
        Item itemId1 = new Item("itemId1");
        wishlist1.add(itemId1);
        wishlistDAO.save(wishlist1);
        String customerId2 = "customerId2";
        Wishlist wishlist2 = new Wishlist(customerId2);
        Item itemId2 = new Item("itemId2");
        wishlist2.add(itemId2);
        wishlistDAO.save(wishlist2);

        wishlistsController.mergeWishlists(customerId1, customerId2);
        assertThat(wishlistDAO.findByCustomerId(customerId1).get(0).contents(), is(hasSize(2)));
        assertThat(wishlistDAO.findByCustomerId(customerId1).get(0).contents(), is(containsInAnyOrder(itemId1, itemId2)));
        assertThat(wishlistDAO.findByCustomerId(customerId2), is(empty()));
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
