package works.weave.socks.wishlist.wishlist;

import org.junit.Test;
import works.weave.socks.wishlist.entities.Wishlist;
import works.weave.socks.wishlist.entities.Item;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UnitWishlistResource {

    private final String customerId = "testId";
    private final WishlistDAO.Fake fake = new WishlistDAO.Fake();

    @Test
    public void whenWishlistExistsUseThat() {
        Wishlist wishlist = new Wishlist(customerId);
        fake.save(wishlist);
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        assertThat(wishlistResource.value().get(), equalTo(wishlist));
    }

    @Test
    public void whenWishlistDoesntExistCreateNew() {
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        assertThat(wishlistResource.value().get(), is(notNullValue()));
        assertThat(wishlistResource.value().get().customerId, is(equalTo(customerId)));
    }

    @Test
    public void whenDestroyRemoveItem() {
        Wishlist wishlist = new Wishlist(customerId);
        fake.save(wishlist);
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        wishlistResource.destroy().run();
        assertThat(fake.findByCustomerId(customerId), is(empty()));
    }

    @Test
    public void whenDestroyOnEmptyStillEmpty() {
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        wishlistResource.destroy().run();
        assertThat(fake.findByCustomerId(customerId), is(empty()));
    }

    @Test
    public void whenCreateDoCreate() {
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        wishlistResource.create().get();
        assertThat(fake.findByCustomerId(customerId), is(not(empty())));
    }

    @Test
    public void contentsShouldBeEmptyWhenNew() {
        WishlistResource wishlistResource = new WishlistResource(fake, customerId);
        wishlistResource.create().get();
        assertThat(wishlistResource.contents().get().contents().get(), is(empty()));
    }

    @Test
    public void mergedItemsShouldBeInWishlist() {
        String person1 = "person1";
        String person2 = "person2";
        Item person1Item = new Item("item1");
        Item person2Item = new Item("item2");
        WishlistResource wishlistResource = new WishlistResource(fake, person1);
        wishlistResource.contents().get().add(() -> person1Item).run();
        WishlistResource wishlistResourceToMerge = new WishlistResource(fake, person2);
        wishlistResourceToMerge.contents().get().add(() -> person2Item).run();
        wishlistResource.merge(wishlistResourceToMerge.value().get()).run();
        assertThat(wishlistResource.contents().get().contents().get(), hasSize(2));
        assertThat(wishlistResource.contents().get().contents().get().get(0), anyOf(equalTo(person1Item), equalTo
                (person2Item)));
        assertThat(wishlistResource.contents().get().contents().get().get(1), anyOf(equalTo(person1Item), equalTo
                (person2Item)));
        assertThat(wishlistResourceToMerge.contents().get().contents().get(), hasSize(1));
    }
}
