package works.weave.socks.wishlist.wishlist;

import works.weave.socks.wishlist.entities.Wishlist;

import java.util.function.Supplier;

public interface Resource<T> {
    Runnable destroy();

    Supplier<T> create();

    Supplier<T> value();

    Runnable merge(T toMerge);

    class WishlistFake implements Resource<Wishlist> {
        private final String customerId;
        private Wishlist wishlist = null;

        public WishlistFake(String customerId) {
            this.customerId = customerId;
        }

        @Override
        public Runnable destroy() {
            return () -> wishlist = null;
        }

        @Override
        public Supplier<Wishlist> create() {
            return () -> wishlist = new Wishlist(customerId);
        }

        @Override
        public Supplier<Wishlist> value() {
            if (wishlist == null) {
                create().get();
            }
            return () -> wishlist;
        }

        @Override
        public Runnable merge(Wishlist toMerge) {
            return null;
        }
    }
}
