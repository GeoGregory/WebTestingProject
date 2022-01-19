package test.java.org.framework.pom;

public enum SortOptions {
    A_TO_Z("Name (A to Z)"),
    Z_TO_A("Name (Z to A"),
    LOW_TO_HIGH("Price (low to high)"),
    HIGH_TO_LOW("Price (high to low");

    private final String sortBy;

    public String getSortOption(){return sortBy;}

    SortOptions(String sortBy){
        this.sortBy = sortBy;
    }
}
