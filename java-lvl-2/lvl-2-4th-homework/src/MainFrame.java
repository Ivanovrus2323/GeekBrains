import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel messagesContainer;

    private JPanel sendContainer;
    private JTextField newMessageField;
    private JButton sendButton;

    MainFrame() {

        setLayout(null);

        this.messagesContainer                 = new JPanel();
        messagesContainer.setLayout(new BoxLayout(messagesContainer, BoxLayout.Y_AXIS));
        JScrollPane jScrollPane                = new JScrollPane(messagesContainer);

        this.sendContainer                     = new JPanel();
        sendContainer.setLayout(new GridBagLayout());

        GridBagConstraints sendMessageLayoutConstraints = new GridBagConstraints();
        sendMessageLayoutConstraints.fill      = GridBagConstraints.HORIZONTAL;
        sendMessageLayoutConstraints.gridy     = 0;


        this.newMessageField = new JTextField();
        newMessageField.setToolTipText("Введите сообщение");

        sendMessageLayoutConstraints.ipady     = 40;
        sendMessageLayoutConstraints.weightx   = 0.9;
        sendContainer.add(newMessageField, sendMessageLayoutConstraints);


        this.sendButton = new JButton("Отправить");
        sendButton.addActionListener(new AddMessage(messagesContainer, newMessageField));

        sendMessageLayoutConstraints.ipady     = 40;
        sendMessageLayoutConstraints.weightx   = 0.1;
        sendContainer.add(sendButton, sendMessageLayoutConstraints);

        
        setLayout(new GridBagLayout());

        GridBagConstraints mainFrameLayoutConstraints = new GridBagConstraints();
        mainFrameLayoutConstraints.fill        = GridBagConstraints.BOTH;
        mainFrameLayoutConstraints.weightx     = 1;
        mainFrameLayoutConstraints.gridx       = 0;
        mainFrameLayoutConstraints.gridwidth   = 1;


        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainFrameLayoutConstraints.weighty     = 1;
        mainFrameLayoutConstraints.gridheight  = 9;
        mainFrameLayoutConstraints.gridy       = 0;
        add(jScrollPane, mainFrameLayoutConstraints);

        mainFrameLayoutConstraints.weighty     = 0;
        mainFrameLayoutConstraints.gridheight  = 1;
        mainFrameLayoutConstraints.gridy       = 9;
        add(sendContainer, mainFrameLayoutConstraints);


        setTitle("Test app");
        setSize(1366, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AddMessage implements ActionListener {
        JPanel panel;
        JTextField textField;

        AddMessage(JPanel panel, JTextField textField) {
            this.panel = panel;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JLabel newMessageJLabel = new JLabel(textField.getText());

            panel.add(newMessageJLabel);
            textField.setText("");
            panel.validate();
        }
    }
}