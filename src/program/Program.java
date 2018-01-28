package program;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Program {
	private Szkola szkola = new Szkola();
	

	private JFrame frame;
	private JTextField name;
	private JTextField surname;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name1 = new JLabel("Imi\u0119:");
		name1.setBounds(10, 11, 72, 14);
		frame.getContentPane().add(name1);
		
		JLabel surname1 = new JLabel("Nazwisko:");
		surname1.setBounds(10, 36, 72, 14);
		frame.getContentPane().add(surname1);
		
		name = new JTextField();
		name.setBounds(84, 8, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(84, 36, 86, 20);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		JLabel lblPe = new JLabel("P\u0142e\u0107:");
		lblPe.setBounds(10, 77, 46, 14);
		frame.getContentPane().add(lblPe);
		
		final JRadioButton male = new JRadioButton("Ucze\u0144");
		buttonGroup.add(male);
		male.setBounds(10, 98, 109, 23);
		frame.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("Uczennica");
		buttonGroup.add(female);
		female.setBounds(10, 124, 109, 23);
		frame.getContentPane().add(female);
		
		JLabel lblRokUrodzenia = new JLabel("Rok urodzenia");
		lblRokUrodzenia.setBounds(10, 166, 72, 14);
		frame.getContentPane().add(lblRokUrodzenia);
		
		final JComboBox year = new JComboBox();
		year.setBounds(84, 163, 86, 20);
		frame.getContentPane().add(year);
		for(int i=1994;i<=1996;i++)
			year.addItem(i);
		
		JLabel lblMiejsceUrodzenia = new JLabel("Miejsce urodzenia");
		lblMiejsceUrodzenia.setBounds(10, 202, 109, 14);
		frame.getContentPane().add(lblMiejsceUrodzenia);
		
		final String[] miasta = {"Kraków", "Radom", "Wroc³aw", "Gdañsk", "Zakopane"};
		final JList city = new JList(miasta);
		city.setBounds(10, 227, 160, 120);
		frame.getContentPane().add(city);
		
		JLabel lblUczniowie = new JLabel("Uczniowie:");
		lblUczniowie.setBounds(180, 11, 97, 14);
		frame.getContentPane().add(lblUczniowie);
		
		final DefaultListModel model = new DefaultListModel();
		final JList students = new JList(model);
		students.setBounds(180, 35, 231, 341);
		frame.getContentPane().add(students);
		
		
		JButton addButton = new JButton("Dodaj>>");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypeOfStudent type = (male.isSelected()) ?
						TypeOfStudent.Male : TypeOfStudent.Female;
				int date = (int) year.getSelectedItem();
				String place = (String) city.getSelectedValue();
				Student student = new Student(name.getText(),surname.getText(), type, date, place);
				
				szkola.Add(student);
				model.addElement(student.GetInfo());
				frame.setTitle("Panel uczniów: " + szkola.GetCount());
			}
		});
		addButton.setBounds(10, 358, 160, 23);
		frame.getContentPane().add(addButton);

		
	}
}
