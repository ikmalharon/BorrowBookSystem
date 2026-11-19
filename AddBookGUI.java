import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {
    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaBooks;

    public AddBookGUI() {
        setTitle("Add Book Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel pInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblTitle = new JLabel("Book Title:");
        txtTitle = new JTextField(20);
        lblAuthor = new JLabel("Author:");
        txtAuthor = new JTextField(20);

        pInput.add(lblTitle);
        pInput.add(txtTitle);
        pInput.add(lblAuthor);
        pInput.add(txtAuthor);

        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        pButtons.add(btnAdd);
        pButtons.add(btnList);

        JPanel pTop = new JPanel(new BorderLayout(5, 5));
        pTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        pTop.add(pInput, BorderLayout.NORTH);
        pTop.add(pButtons, BorderLayout.SOUTH);

        JPanel pBottom = new JPanel(new BorderLayout(5, 5));
        pBottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        lblBooks = new JLabel("Books:");
        txtAreaBooks = new JTextArea(6, 30);
        txtAreaBooks.setEditable(false);

        pBottom.add(lblBooks, BorderLayout.NORTH);
        pBottom.add(new JScrollPane(txtAreaBooks), BorderLayout.CENTER);

        add(pTop, BorderLayout.NORTH);
        add(pBottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                MainMenuGUI.bookList.add(new Book(title, author));
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaBooks.setText("");
            for (Book b : MainMenuGUI.bookList) {
                txtAreaBooks.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }
}
