import java.awt.Cursor;

import javax.swing.*;

public class Texto extends JTextField {
    public Texto() {
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }

    public Texto(String txt) {
        setText(txt);
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }

}