package enums;
public enum UrlsSite {
    ACCEPT_DEVOCEAN("https://accept.devocean.pro/"),
    LIASTUDIO_STORE("https://liastudio.store");

    private final String url;

    UrlsSite(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}