/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IgorKvakan
 */
public class MoviesTableModel extends AbstractTableModel{
    
    private static final String[] COULMN_NAMES={"Id","Title","Description","Director","Actors","Duration","Genre","PubDate","PicturePath"};

    private List<Movie> movies;

    public void clear() {
        movies.clear();
    }
  



    
    public MoviesTableModel(List<Movie> movies) {
        this.movies = movies;
    }

  

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return Movie.class.getDeclaredFields().length -1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return movies.get(rowIndex).getId();
            case 1:
                return movies.get(rowIndex).getTitle();
            case 2:
                return movies.get(rowIndex).getDescription();
            case 3:
                return movies.get(rowIndex).getDirector();
            case 4:
                return movies.get(rowIndex).getActors(); 
            case 5:
                return movies.get(rowIndex).getDuration();
            case 6:
                return movies.get(rowIndex).getGenre();
            case 7:
                return movies.get(rowIndex).getPubDate();
            case 8:
                return movies.get(rowIndex).getPicturePath();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COULMN_NAMES[columnIndex];
    }
    
    
    
    
}
