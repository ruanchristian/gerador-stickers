public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new IMDBExtractor()),
    IMDB_TOP_TVS("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new IMDBExtractor()),
    NASA_PICS("https://api.nasa.gov/planetary/apod?api_key=tkQx4CSbfGBiyDwwS0tpzS8najNLdkVj1J4bOeXR&start_date=2023-03-27", new NasaExtractor());

    private String url;
    private Extractor extractor;

    API(String url, Extractor extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return this.url;
    }

    public Extractor getExtractorType() {
        return this.extractor;
    }
}
