public class Show implements Comparable<Show> {
    private String showId;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private String listedIn;
    private String description;

    public Show(String showId, String type, String title, String director, String cast, String country,
                String dateAdded, int releaseYear, String rating, String duration, String listedIn, String description) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }

    public String getShowId() { return showId; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getCast() { return cast; }
    public String getCountry() { return country; }
    public String getDateAdded() { return dateAdded; }
    public int getReleaseYear() { return releaseYear; }
    public String getRating() { return rating; }
    public String getDuration() { return duration; }
    public String getListedIn() { return listedIn; }
    public String getDescription() { return description; }

    public void setShowId(String showId) { this.showId = showId; }
    public void setType(String type) { this.type = type; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setCast(String cast) { this.cast = cast; }
    public void setCountry(String country) { this.country = country; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public void setRating(String rating) { this.rating = rating; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setListedIn(String listedIn) { this.listedIn = listedIn; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public int compareTo(Show other) {
        return this.showId.compareTo(other.showId);
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", country='" + country + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", listedIn='" + listedIn + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}