package AlbunsMusicais.View;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Mascaras {
    DefaultFormatterFactory dff;
    public MaskFormatter mascaraData (JFormattedTextField textField) throws ParseException {
        MaskFormatter mask;
        mask = new MaskFormatter("##/##/####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        dff = new DefaultFormatterFactory(mask);
        textField.setFormatterFactory(dff);

        return mask;
    }
    public MaskFormatter mascaraDuracao(JFormattedTextField textField) throws ParseException {
        MaskFormatter mask;
        mask = new MaskFormatter("##:##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        dff = new DefaultFormatterFactory(mask);
        textField.setFormatterFactory(dff);

        return mask;
    }
}
