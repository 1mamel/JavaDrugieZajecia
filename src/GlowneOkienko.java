import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mamel on 11.10.2016.
 */
public class GlowneOkienko extends JFrame {

    private JPanel panel1;
    private JTextField imieTextField;
    private JTextField nazwiskoTextField;
    private JTextField miejscowoscTextField;
    private JButton zatwierdźButton;
    private JTextArea outputTextArea;
    private JTextField rokTextField;

    public GlowneOkienko(){
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!isNumeric(rokTextField.getText()))
                    {
                        throw new NotNumericException();
                    }
                    outputTextArea.append("\n" + imieTextField.getText() + " " + nazwiskoTextField.getText() + " " + miejscowoscTextField.getText() + " " + rokTextField.getText() );
                }
                catch(NotNumericException ex)  {
                    outputTextArea.append("\n" + ex.getMessage() );
                }
                finally {
                    imieTextField.setText("");
                    nazwiskoTextField.setText("");
                    miejscowoscTextField.setText("");
                    rokTextField.setText("");
                }
            }
        });

        this.setVisible(true);
    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
