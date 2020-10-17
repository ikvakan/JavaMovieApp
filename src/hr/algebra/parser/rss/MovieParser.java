/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.parser.rss;

import hr.algebra.factory.ParseFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Movie;
import hr.algebra.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author IgorKvakan
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.cinestarcinemas.rs/rss.aspx?id=415";

    private static final int TIMEOUT = 10000;
    private static final String REQUEST_METHOD = "GET";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    private static final String ITEM_ELEMENT = "item";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final Random RANDOM = new Random();
    
    private static Set<String> pictures= new TreeSet<>((s1,s2)->s1.compareTo(s2));

    public static List<Movie> parse() throws IOException, XMLStreamException {
        List<Movie> movies = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL, TIMEOUT, REQUEST_METHOD);
        XMLEventReader reader = ParseFactory.createStaxParser(con.getInputStream());

        Optional<TagType> tagType = Optional.empty();
        Movie movie = null;
        StartElement startElement = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    tagType = TagType.from(qName);

                    if (qName == ITEM_ELEMENT) {
                        movie = new Movie();
                        movies.add(movie);
                    }

                    break;
                case XMLStreamConstants.CHARACTERS:
                case XMLStreamConstants.CDATA:
                    if (tagType.isPresent()) {
                        Characters characters = event.asCharacters();

                        String data = characters.getData().trim();

                        switch (tagType.get()) {

                            case TITLE:
                                if (movie != null && !data.isEmpty()) {
                                    movie.setTitle(data);
                                }
                                break;
                            case DESCRIPTION:
                                if (movie != null && !data.isEmpty()) {
                                    Document doc = Jsoup.parse(data);
                                    movie.setDescription(doc.text());
                                }
                                break;
                            case DIRECTOR:
                                if (movie != null && !data.isEmpty()) {
                                    movie.setDirector(data);
                                }
                                break;
                            case ACTORS:
                                if (movie != null && !data.isEmpty()) {
                                    movie.setActors(data);
                                }
                                break;
                            case DURATION:
                                if (movie != null && !data.isEmpty()) {
                                    movie.setDuration(data);
                                }
                                break;
                            case GENRE:
                                if (movie != null && !data.isEmpty()) {
                                    movie.setGenre(data);
                                }
                                break;
                            case PUB_DATE:
                                if (movie != null && !data.isEmpty()) {
                                    //LocalDateTime pubDateTime=LocalDateTime.parse(data,DATE_FORMATTER);
                                    movie.setPubDate(data);
                                }
                                break;
                            case PICTUR_PATH:
                                if (movie != null && !data.isEmpty()) {
                                    pictures.add(data);
                                    
                                    handlePicture(movie, data);
                                }
                                break;

                        }
                    }
                    break;
            }
        }
        
        createPictureAssets();
        return movies;

    }

    private static void handlePicture(Movie movie, String data) throws IOException {
        String ext = data.substring(data.lastIndexOf("."));
        if (ext.length() > 4) {
            ext = EXT;
        }
        String pictureName = Math.abs(RANDOM.nextInt()) + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        

        
        //FileUtils.copyFromUrl(data, localPicturePath);

        

        movie.setPicturePath(localPicturePath);
    }



    private static void createPictureAssets() throws IOException {
        if (pictures.size()== 0) {
            return;
        }
        for (String picture : pictures) {
            FileUtils.copyFromUrl(picture, getDestination(picture));
        }
        
    }

    private static String getDestination(String picture) {
        String ext = picture.substring(picture.lastIndexOf("."));
        if (ext.length() > 4) {
            ext = EXT;
        }
        String pictureName = Math.abs(RANDOM.nextInt()) + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        
        return localPicturePath;
    }

    private enum TagType {

        ITEM("item"),
        TITLE("title"),
        PUB_DATE("datumprikazivanja"),
        DESCRIPTION("description"),
        DIRECTOR("redatelj"),
        ACTORS("glumci"),
        DURATION("trajanje"),
        GENRE("zanr"),
        PICTUR_PATH("plakat");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }
}
