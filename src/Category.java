public enum Category {
    ELECTRONICS("Электроника"),
    CLOTHES("Одежда"),
    BOOKS("Книги");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
