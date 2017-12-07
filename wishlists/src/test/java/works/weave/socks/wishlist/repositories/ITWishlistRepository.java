package works.weave.socks.wishlist.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import works.weave.socks.wishlist.entities.Wishlist;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class ITWishlistRepository {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Before
    public void removeAllData() {
        wishlistRepository.deleteAll();
    }

    @Test
    public void testWishlistSave() {
        Wishlist original = new Wishlist("customerId");
        Wishlist saved = wishlistRepository.save(original);

        assertEquals(1, wishlistRepository.count());
        assertEquals(original, saved);
    }

    @Test
    public void testWishlistGetDefault() {
        Wishlist original = new Wishlist("customerId");
        Wishlist saved = wishlistRepository.save(original);

        assertEquals(1, wishlistRepository.count());
        assertEquals(original, saved);
    }

    @Test
    public void testSearchCustomerById() {
        Wishlist original = new Wishlist("customerId");
        wishlistRepository.save(original);

        List<Wishlist> found = wishlistRepository.findByCustomerId(original.customerId);
        assertEquals(1, found.size());
        assertEquals(original, found.get(0));
    }
}
