import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {
    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaStudents;

    public AddStudentGUI() {
        setTitle("Add Student Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel pInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblName = new JLabel("Name:");
        txtName = new JTextField(20);
        lblMatric = new JLabel("Matric:");
        txtMatric = new JTextField(20);

        pInput.add(lblName);
        pInput.add(txtName);
        pInput.add(lblMatric);
        pInput.add(txtMatric);

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
        lblStudents = new JLabel("Students:");
        txtAreaStudents = new JTextArea(6, 30);
        txtAreaStudents.setEditable(false);

        pBottom.add(lblStudents, BorderLayout.NORTH);
        pBottom.add(new JScrollPane(txtAreaStudents), BorderLayout.CENTER);

        add(pTop, BorderLayout.NORTH);
        add(pBottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                MainMenuGUI.studentList.add(new Student(name, matric));
                txtName.setText("");
                txtMatric.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaStudents.setText("");
            for (Student s : MainMenuGUI.studentList) {
                txtAreaStudents.append("Name : " + s.toString() + "\n");
            }
        }
    }
}
