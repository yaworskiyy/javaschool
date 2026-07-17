package hw_14;

import java.util.ArrayList;
import java.util.List;

public class Task14_1 {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        System.out.println("До сортировки:");
        movies.forEach(System.out::println);

        movies.sort(new MovieRatingComparator());

        System.out.println("\nПосле сортировки (по возрастанию рейтинга):");
        movies.forEach(System.out::println);
    }
}
