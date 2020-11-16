package com.giuseppesilvestro.giflib.data;

import com.giuseppesilvestro.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Fun"),
            new Category(2, "Tech"),
            new Category(3, "People")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category category :
                ALL_CATEGORIES) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public Category findByIdFunctionally(int id) {
        return ALL_CATEGORIES.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
