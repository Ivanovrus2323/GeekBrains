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
        JScrollPane jScrollPane                = new JScrollPane(messagesContainer);

        JLabel newMessageJLabel = new JLabel("newMessage");
        newMessageJLabel.setSize(100, 50);
        messagesContainer.add(newMessageJLabel);

        this.sendContainer                     = new JPanel();
        sendContainer.setLayout(new GridBagLayout());

        GridBagConstraints sendMessageLayoutConstraints = new GridBagConstraints();
        sendMessageLayoutConstraints.fill      = GridBagConstraints.HORIZONTAL;
        sendMessageLayoutConstraints.gridy     = 0;

        // Добавление элементов в панель создания сообщения
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


        // Добавление элементов в главное окно
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


        fillMessages();


        setTitle("Test app");
        setSize(1366, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Добавить новое сообщение
    private void addMessage(String newMessage) {
        JLabel newMessageJLabel = new JLabel();

        newMessageJLabel.setText(newMessage);
        newMessageJLabel.setSize(100, 50);
        messagesContainer.add(newMessageJLabel);
    }

    // Метод будет заполнять панель сообщений по данным в бд
    private void fillMessages() {

        String[] messages = new String[1]; // Будет заменено

        for (String messageText : messages) {
            JLabel newMessageJLabel = new JLabel(messageText);
            newMessageJLabel.setSize(100, 50);
            messagesContainer.add(newMessageJLabel);
        }
    }

    private class AddMessage implements ActionListener {
        JPanel messContainer;
        JTextField messField;

        AddMessage (JPanel messContainer, JTextField messField) {
            this.messContainer = messContainer;
            this.messField = messField;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this.messContainer.add(new JLabel(newMessageField.getText()));

            this.messField.setText("");
        }
    }
}