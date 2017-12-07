package works.weave.socks.wishlist.wishlist;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import works.weave.socks.wishlist.entities.Wishlist;
import works.weave.socks.wishlist.entities.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class UnitWishlistContentsResource {
    private final String customerId = "testId";
    private final WishlistDAO.Fake fakeDAO = new WishlistDAO.Fake();
    private final Resource<Wishlist> fakeWishlistResource = new Resource.WishlistFake(customerId);

    @Test
    public void shouldAddAndReturnContents() {
        WishlistContentsResource contentsResource = new WishlistContentsResource(fakeDAO, () -> fakeWishlistResource);
        Item item = new Item("testId");
        contentsResource.add(() -> item).run();
        assertThat(contentsResource.contents().get(), IsCollectionWithSize.hasSize(1));
        assertThat(contentsResource.contents().get(), containsInAnyOrder(item));
    }

    @Test
    public void shouldStartEmpty() {
        WishlistContentsResource contentsResource = new WishlistContentsResource(fakeDAO, () -> fakeWishlistResource);
        assertThat(contentsResource.contents().get(), IsCollectionWithSize.hasSize(0));
    }

    @Test
    public void shouldDeleteItemFromWishlist() {
        WishlistContentsResource contentsResource = new WishlistContentsResource(fakeDAO, () -> fakeWishlistResource);
        Item item = new Item("testId");
        contentsResource.add(() -> item).run();
        assertThat(contentsResource.contents().get(), IsCollectionWithSize.hasSize(1));
        assertThat(contentsResource.contents().get(), containsInAnyOrder(item));
        Item item2 = new Item(item.itemId());
        contentsResource.delete(() -> item2).run();
        assertThat(contentsResource.contents().get(), IsCollectionWithSize.hasSize(0));
    }
}
