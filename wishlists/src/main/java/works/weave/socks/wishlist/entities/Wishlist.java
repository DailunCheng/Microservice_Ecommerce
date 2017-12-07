package works.weave.socks.wishlist.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
public class Wishlist {
    @NotNull
    public String customerId; // Public instead of getters/setters.
    @Id
    private String id;
    @DBRef
    private List<Item> items = new ArrayList<>();

    public Wishlist(String customerId) {
        this.customerId = customerId;
    }

    public Wishlist() {
        this(null);
    }

    public List<Item> contents() {
        return items;
    }

    public Wishlist add(Item item) {
        items.add(item);
        return this;
    }

    public Wishlist remove(Item item) {
        items.remove(item);
        return this;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wishlist wishlist = (Wishlist) o;

        if (customerId != null ? !customerId.equals(wishlist.customerId) : wishlist.customerId != null) return false;
        if (id != null ? !id.equals(wishlist.id) : wishlist.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
