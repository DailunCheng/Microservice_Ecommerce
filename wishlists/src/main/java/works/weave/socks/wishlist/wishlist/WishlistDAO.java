package works.weave.socks.wishlist.wishlist;

import works.weave.socks.wishlist.entities.Wishlist;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WishlistDAO {
    void delete(Wishlist wishlist);

    Wishlist save(Wishlist wishlist);

    List<Wishlist> findByCustomerId(String customerId);

    class Fake implements WishlistDAO {
        private Map<String, Wishlist> wishlistStore = new HashMap<>();

        @Override
        public void delete(Wishlist wishlist) {
            wishlistStore.remove(wishlist.customerId);
        }

        @Override
        public Wishlist save(Wishlist wishlist) {
            return wishlistStore.put(wishlist.customerId, wishlist);
        }

        @Override
        public List<Wishlist> findByCustomerId(String customerId) {
            Wishlist wishlist = wishlistStore.get(customerId);
            if (wishlist != null) {
                return Collections.singletonList(wishlist);
            } else {
                return Collections.emptyList();
            }
        }
    }
}
