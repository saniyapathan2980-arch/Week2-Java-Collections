import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlaylist {

    public static void main(String[] args) {

        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        ListIterator<String> it = playlist.listIterator();

        boolean isPlayingForward = true;

        while (true) {
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Play Next Song");
            System.out.println("3. Play Previous Song");
            System.out.println("4. Remove Current Song");
            System.out.println("5. Display Playlist");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ADD SONG
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    playlist.add(song);
                    it = playlist.listIterator();
                    System.out.println("Song added!");
                    break;

                // PLAY NEXT
                case 2:
                    if (!isPlayingForward) {
                        if (it.hasNext()) it.next();
                        isPlayingForward = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Now Playing: " + it.next());
                    } else {
                        System.out.println("End of playlist");
                    }
                    break;

                // PLAY PREVIOUS
                case 3:
                    if (isPlayingForward) {
                        if (it.hasPrevious()) it.previous();
                        isPlayingForward = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Now Playing: " + it.previous());
                    } else {
                        System.out.println("Start of playlist");
                    }
                    break;

                // REMOVE SONG
                case 4:
                    try {
                        it.remove();
                        System.out.println("Song removed!");
                    } catch (Exception e) {
                        System.out.println("No song to remove");
                    }
                    break;

                // DISPLAY PLAYLIST
                case 5:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty");
                    } else {
                        System.out.println("Playlist Songs:");
                        for (String s : playlist) {
                            System.out.println("- " + s);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Music Player Closed 🎧");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}1