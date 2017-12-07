package works.weave.socks.wishlist.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import works.weave.socks.wishlist.wishlist.WishlistDAO;
import works.weave.socks.wishlist.entities.Wishlist;
import works.weave.socks.wishlist.entities.Item;
import works.weave.socks.wishlist.item.ItemDAO;
import works.weave.socks.wishlist.repositories.WishlistRepository;
import works.weave.socks.wishlist.repositories.ItemRepository;

import java.util.List;

@Configuration
public class BeanConfiguration {
    @Bean
    @Autowired
    public WishlistDAO getWishlistDao(WishlistRepository wishlistRepository) {
        return new WishlistDAO() {
            @Override
            public void delete(Wishlist wishlist) {
                wishlistRepository.delete(wishlist);
            }

            @Override
            public Wishlist save(Wishlist wishlist) {
                return wishlistRepository.save(wishlist);
            }

            @Override
            public List<Wishlist> findByCustomerId(String customerId) {
                return wishlistRepository.findByCustomerId(customerId);
            }
        };
    }

    @Bean
    @Autowired
    public ItemDAO getItemDao(ItemRepository itemRepository) {
        return new ItemDAO() {
            @Override
            public Item save(Item item) {
                return itemRepository.save(item);
            }

            @Override
            public void destroy(Item item) {
                itemRepository.delete(item);
            }

            @Override
            public Item findOne(String id) {
                return itemRepository.findOne(id);
            }
        };
    }
}
