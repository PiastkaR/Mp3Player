package com.mp3player.controller;

import com.mp3player.mp3.Mp3Song;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

import java.io.File;
import java.io.IOException;

public class ContentPaneController {

    private static final String TITLE_COLUMN = "Title";
    private static final String AUTHOR_COLUMN = "Author";
    private static final String ALBUM_COLUMN = "Album";

    @FXML
    private TableView<Mp3Song> contentTable;

    public void initialize() {
        configureTableColumns();
        createTestData();
    }

    private void configureTableColumns() {
        TableColumn<Mp3Song, String> titleColumn = new TableColumn<Mp3Song, String>(TITLE_COLUMN);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Mp3Song, String> authorColumn = new TableColumn<Mp3Song, String>(AUTHOR_COLUMN);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Mp3Song, String> albumColumn = new TableColumn<Mp3Song, String>(ALBUM_COLUMN);
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));

        contentTable.getColumns().add(titleColumn);
        contentTable.getColumns().add(authorColumn);
        contentTable.getColumns().add(albumColumn);
    }

    private void createTestData() {
        ObservableList<Mp3Song> items = contentTable.getItems();
        Mp3Song mp3SongFromPath = createMp3SongFromPath("scott_holmes_music_stylish_groove.mp3");
        items.add(mp3SongFromPath);
    }

    private Mp3Song createMp3SongFromPath(String filePath) {
        File file = new File(filePath);
        try {
            System.out.println("path: " + file.getAbsolutePath() + "space: " + file.getTotalSpace());
            MP3File mp3File = new MP3File(file);
            String absolutePath = file.getAbsolutePath();
            String title = mp3File.getID3v2Tag().getSongTitle();
            String author = mp3File.getID3v2Tag().getLeadArtist();
            String album = mp3File.getID3v2Tag().getAlbumTitle();
            return new Mp3Song(title, author, album, absolutePath);
        } catch (IOException | TagException e) {
            e.printStackTrace();
            return null; //ignore
        }
    }
}