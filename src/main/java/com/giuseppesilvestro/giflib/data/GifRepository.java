package com.giuseppesilvestro.giflib.data;

import com.giuseppesilvestro.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 1,  LocalDate.of(2015,  2, 13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", 3, LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
            new Gif("book-dominos", 1,  LocalDate.of(2015, 9, 15), "Craig Dennis", false),
            new Gif("compiler-bot", 2, LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 2, LocalDate.of(2015, 2, 13), "Grace Hopper", false),
            new Gif("infinite-andrew", 3, LocalDate.of(2015, 8, 23), "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif :
                ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public Gif findByNameFunctionally(String name) {
        return ALL_GIFS.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        return ALL_GIFS.stream()
                .filter(e -> e.getCategoryId() == id)
                .collect(Collectors.toList());
    }

    public List<Gif> getFavorites() {
        List<Gif> favorites = new ArrayList<>();
        for (Gif gif :
                ALL_GIFS) {
            if (gif.isFavorite()) {
                favorites.add(gif);
            }
        }
        return favorites;
    }

    public List<Gif> searchGifs(String name) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif :
                ALL_GIFS) {
            if (gif.getName().toLowerCase().contains(name)) {
                gifs.add(gif);
            }
        }
        return gifs;
    }
}