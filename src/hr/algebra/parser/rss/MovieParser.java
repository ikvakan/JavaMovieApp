/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.parser.rss;

import hr.algebra.factory.ParseFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Movie;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author IgorKvakan
 */
public class MovieParser {
    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx";
    private static final int TIMEOUT = 10000;
    private static final String REQUEST_METHOD = "GET";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final Random RANDOM = new Random();
    
   public static List<Movie> parse() throws IOException, XMLStreamException {
        List<Movie> movies = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL, TIMEOUT, REQUEST_METHOD);
        XMLEventReader reader = ParseFactory.createStaxParser(con.getInputStream());

        Optional<TagType> tagType = Optional.empty();
        Movie movie = null;
        StartElement startElement = null;
   
        while (reader.hasNext()) {           
           
       }
        
   
        return movies;
   
   }
    
    
    private enum TagType {

        ITEM("item"), 
        TITLE("title"), 
        DURATION("trajanje"),
        DESCRIPTION("description"), 
        ENCLOSURE("enclosure"),
        GENRE("zanr"),
        DIRECTOR("redatelj"),
        ACTORS("glumci"),
        PUB_DATE("pubDate");

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
