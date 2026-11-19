import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuGUI extends JFrame implements ActionListener {
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    private JButton btnAddStudent, btnAddBook, btnBorrow;

    public MainMenuGUI() {
        setTitle("Main Menu");
        setSize(320, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 8, 8));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblHeader = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        add(lblHeader);
        add(btnAddStudent);
        add(btnAddBook);
        add(btnBorrow);

        btnAddStudent.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudent) {
            new AddStudentGUI().setVisible(true);
        } else if (e.getSource() == btnAddBook) {
            new AddBookGUI().setVisible(true);
        } else if (e.getSource() == btnBorrow) {
            new BorrowBookGUI().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MainMenuGUI().setVisible(true);
    }
}
