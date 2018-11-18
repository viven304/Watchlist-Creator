//package ui;
//
//import jdk.internal.util.xml.impl.Input;
//
//import javax.swing.*;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class CustomInputStream extends InputStream {
//    private JTextField textField;
//
//    public CustomInputStream(JTextField textField) {
//        this.textField = textField;
//    }
//
//    @Override
//    public void write(int b) throws IOException {
//        // redirects data to the text area
//        textArea.append(String.valueOf((char)b));
//        // scrolls the text area to the end of data
//        textArea.setCaretPosition(textArea.getDocument().getLength());
//        // keeps the textArea up to date
//        textArea.update(textArea.getGraphics());
//    }
//
//    @Override
//    public int read() throws IOException {
//
//    }
//}
//
