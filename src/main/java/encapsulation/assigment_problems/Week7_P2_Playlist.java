package encapsulation.assigment_problems;

import java.util.Arrays;

public class Week7_P2_Playlist {

    static class Playlist {
        private final String[] songs;
        private int songCount;

        Playlist(int maximumSongs) {
            songs = new String[maximumSongs];
            songCount = 0;
        }

        void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
