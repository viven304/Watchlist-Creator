package ui;

import exceptions.AlreadyInWatchlistException;
import jdk.internal.util.xml.impl.Input;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


class gui implements ActionListener, MouseListener {

    Movie conjuring = new Movie(86, "Conjuring", "Genre");
    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
    MovieDatabase movieDatabase = new MovieDatabase();
    Watchlist watchlist = new Watchlist();
    TVShow twd = new TVShow(86, "The Walking Dead", "Horror");
    ArrayList<Episode> twdeps = new ArrayList<>();
    Episode negan = new Episode(80, "Negan", "Horror");
    Episode welost = new Episode(70, "We Lost", "Horror");
    TVShow got = new TVShow(95, "Game of Thrones", "Fantasy");
    ArrayList<Episode> goteps = new ArrayList<>();
    Episode bob = new Episode(99, "Battle of Bastards", "Fantasy");
    TVShowDatabase tvShowDatabase = new TVShowDatabase();
    private static final int INTERVAL = 20;
    private Timer t;
    private JTextArea ta;
    private JTextField tf;
    private String name = " ";
    private Scanner scanner = new Scanner(name);


    public void runBefore() {

        movieDatabase.addTitleToDatabase(conjuring);
        movieDatabase.addTitleToDatabase(interstellar);

        twdeps.add(negan);
        twdeps.add(welost);
        twd.setEpisodes("5", twdeps);
        goteps.add(bob);
        got.setEpisodes("6", goteps);

        tvShowDatabase.addTitleToDatabase(twd);
        tvShowDatabase.addTitleToDatabase(got);
    }


    public gui() throws IOException {
        runBefore();

        //Creating the Frame
        JFrame frame = new JFrame("Watchlist Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("New");
        JMenuItem m22 = new JMenuItem("Save");
        JMenuItem m33 = new JMenuItem("Load");
        m1.add(m11);
        m1.add(m22);
        m1.add(m33);
        m22.addMouseListener(this);
        m33.addMouseListener(this);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Search for title");
        tf = new JTextField(10); // accepts upto 10 characters
        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(add);
        panel.add(remove);
        // Text Area at the Center
        this.ta = new JTextArea();


        JTextArea textArea = new JTextArea(50, 10);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);



        add.addMouseListener(this);

       scannerLoad();

        String choice = "";
        while (true) {
            System.out.println("Choose");
            System.out.println("[1] Load Watchlist [2] New Watchlist [3] quit");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                try {
                    watchlist.load(movieDatabase, tvShowDatabase, "inputfile.txt");
                } catch (AlreadyInWatchlistException alreadyInWatchlistException) {
                }
                watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);
            } else if (choice.equals("2")) {
                watchlist.namingWatchlist();
                watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);

            } else if (choice.equals("3")) {
                break;
            }
        }
        watchlist.save("inputfile.txt");
        System.out.println("thanks for using the WatchListCreator");

    }


    public static void main(String args[]) throws IOException {
        new gui();
    }

    private void scannerLoad() {
        if (!(name.equals(""))) {
           scanner = new Scanner(name);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        name = tf.getText();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}