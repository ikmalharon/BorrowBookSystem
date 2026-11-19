import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {
    private JLabel lblStudent, lblBook, lblInfoTitle, lblInfoOutput;
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;

    public BorrowBookGUI() {
        setTitle("Borrow Book");
        setSize(480, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel pSelect = new JPanel(new GridLayout(2, 2, 5, 5));
        lblStudent = new JLabel("Student Name & Matric:");
        cmbStudent = new JComboBox<>();
        for (Student s : MainMenuGUI.studentList) {
            cmbStudent.addItem(s);
        }

        lblBook = new JLabel("Book Title & Author:");
        cmbBook = new JComboBox<>();
        for (Book b : MainMenuGUI.bookList) {
            cmbBook.addItem(b);
        }

        pSelect.add(lblStudent);
        pSelect.add(cmbStudent);
        pSelect.add(lblBook);
        pSelect.add(cmbBook);

        JPanel pButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnBorrow = new JButton("Borrow");
        pButton.add(btnBorrow);

        JPanel pTop = new JPanel(new BorderLayout(5, 10));
        pTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        pTop.add(pSelect, BorderLayout.NORTH);
        pTop.add(pButton, BorderLayout.SOUTH);

        JPanel pBottom = new JPanel(new GridLayout(2, 1, 2, 2));
        pBottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        lblInfoTitle = new JLabel("Borrow Information :");
        lblInfoOutput = new JLabel(" ");
        pBottom.add(lblInfoTitle);
        pBottom.add(lblInfoOutput);

        add(pTop, BorderLayout.NORTH);
        add(pBottom, BorderLayout.SOUTH);

        btnBorrow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrow) {
            Student selectedStudent = (Student) cmbStudent.getSelectedItem();
            Book selectedBook = (Book) cmbBook.getSelectedItem();

            if (selectedStudent == null || selectedBook == null) {
                JOptionPane.showMessageDialog(this, "Please add student and book info first.");
                return;
            }

            if (selectedStudent.getBorrowedBook() != null) {
                JOptionPane.showMessageDialog(this, selectedStudent.getName() + " has already borrowed a book.");
            } else if (selectedBook.getBorrower() != null) {
                JOptionPane.showMessageDialog(this, selectedBook.getTitle() + " is already borrowed.");
            } else {
                String msg = selectedBook.borrowBy(selectedStudent);
                lblInfoOutput.setText(msg);
            }
        }
    }
}
