package ui;

import exceptions.AlreadyInWatchlistException;
import exceptions.NotInTheWatchlistException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class gui {

    Movie conjuring = new Movie(86, "Conjuring", "Genre");
    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
    MovieDatabase movieDatabase;
    Watchlist watchlist = new Watchlist();
    TVShow twd = new TVShow(86, "The Walking Dead", "Horror");
    ArrayList<Episode> twdeps = new ArrayList<>();
    Episode negan = new Episode(80, "Negan", "Horror");
    Episode welost = new Episode(70, "We Lost", "Horror");
    TVShow got = new TVShow(95, "Game of Thrones", "Fantasy");
    ArrayList<Episode> goteps = new ArrayList<>();
    Episode bob = new Episode(99, "Battle of Bastards", "Fantasy");
    TVShowDatabase tvShowDatabase;
    private static final int INTERVAL = 20;
    private Timer t;
    private JTextArea ta;
    private TextField tf;
    private Scanner scanner;
    String input;
    private final PipedInputStream inPipe = new PipedInputStream();
    private final PipedInputStream outPipe = new PipedInputStream();
    PrintWriter inWriter;
    private JButton add;
    private JButton remove;
    private JMenuItem m33;
    private JMenuItem m22;
    private JMenuItem m11;

    public void runBefore() {
        movieDatabase = new MovieDatabase();
        tvShowDatabase = new TVShowDatabase();
        scanner = new Scanner(System.in);
        input = "";
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
        m11 = new JMenuItem("New");
        m22 = new JMenuItem("Save");
        m33 = new JMenuItem("Load");
        m1.add(m11);
        m1.add(m22);
        m1.add(m33);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Search for title");
        tf = new TextField(10); // accepts upto 10 characters
        add = new JButton("Add");
        remove = new JButton("Remove");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(add);
        panel.add(remove);
        // Text Area at the Center
        this.ta = new JTextArea();

        handler handler = new handler();
        tf.addActionListener(handler);
        add.addActionListener(handler);
        remove.addActionListener(handler);
        m33.addActionListener(handler);
        m22.addActionListener(handler);
        m11.addActionListener(handler);

        runBefore();
//        System.setIn(inPipe);
//        try {
//            System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
//            inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
//        }
//        catch(IOException e) {
//            System.out.println("Error: " + e);
//            return;
//        }


        JTextArea textArea = new JTextArea(50, 10);
        textArea.append(watchlist.displayEntireWatchlist());
//        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
//        System.setOut(printStream);
//        System.setErr(printStream);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);


//        String choice = "";
//
//        while (true) {
//                System.out.println("Choose");
//                System.out.println("[1] Load Watchlist [2] New Watchlist [3] quit");
//                choice = scanner.nextLine();
//                if (choice.equals("1")) {
//                    try {
//                        watchlist.load(movieDatabase, tvShowDatabase, "inputfile.txt");
//                    } catch (AlreadyInWatchlistException alreadyInWatchlistException) {
//                    }
//                    watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);
//                } else if (choice.equals("2")) {
//                    watchlist.namingWatchlist();
//                    watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);
//
//                } else if (choice.equals("3")) {
//                    break;
//                }
//        }
//        watchlist.save("inputfile.txt");
//        System.out.println("thanks for using the WatchListCreator");


    }


    private class handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = "";
            if (e.getSource() == tf) {
                VisualEntertainment movie = movieDatabase.searchfortitlebyname(e.getActionCommand());
                s = movie.displayinGui();
                JOptionPane.showMessageDialog(null, s);
            } else if (e.getSource() == add) {
                try {
                    watchlist.addTitle(movieDatabase.searchfortitlebyname(tf.getText()));
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (AlreadyInWatchlistException e1) {
                    JOptionPane.showMessageDialog(null, "Already in watchlist");
                }
            } else if (e.getSource() == remove) {
                try {
                    watchlist.removeTitle(movieDatabase.searchfortitlebyname(tf.getText()));
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (NotInTheWatchlistException e1) {
                    JOptionPane.showMessageDialog(null, "Not in watchlist");
                }
            } else if (e.getSource() == m33) {
                try {
                    watchlist.load(movieDatabase, tvShowDatabase, "inputfile.txt");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error 404");
                } catch (AlreadyInWatchlistException e1) {
                }

            }
            else if (e.getSource() == m22) {
                try {
                    watchlist.save("inputfile.txt");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error 404");
                }
            }
            else if (e.getSource() == m11) {
                watchlist = new Watchlist();
            }
        }
    }


    public static void main(String args[]) throws IOException {
        new gui();
    }


}