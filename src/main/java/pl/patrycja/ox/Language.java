package pl.patrycja.ox;

public enum Language {
    PL("PL"), EN("US");

    private String countryCode;

    Language(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
