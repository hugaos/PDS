package ex2;

import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    private Movie(MovieBuilder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevision = builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }

    // Builder class
    public static class MovieBuilder {
        private final String title;
        private final int year;
        private final Person director;
        private final Person writer;
        private String series;
        private List<Person> cast;
        private List<Place> locations;
        private List<String> languages;
        private List<String> genres;
        private boolean isTelevision;
        private boolean isNetflix;
        private boolean isIndependent;

        public MovieBuilder(String title, int year, Person director, Person writer) {
            this.title = title;
            this.year = year;
            this.director = director;
            this.writer = writer;
        }

        public MovieBuilder series(String series) {
            this.series = series;
            return this;
        }

        public MovieBuilder cast(List<Person> cast) {
            this.cast = cast;
            return this;
        }

        public MovieBuilder locations(List<Place> locations) {
            this.locations = locations;
            return this;
        }

        public MovieBuilder languages(List<String> languages) {
            this.languages = languages;
            return this;
        }

        public MovieBuilder genres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public MovieBuilder isTelevision(boolean isTelevision) {
            this.isTelevision = isTelevision;
            return this;
        }

        public MovieBuilder isNetflix(boolean isNetflix) {
            this.isNetflix = isNetflix;
            return this;
        }

        public MovieBuilder isIndependent(boolean isIndependent) {
            this.isIndependent = isIndependent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
