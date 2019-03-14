//import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Body implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JButton b1, b2;
	private JComboBox cb1;
	private TextArea ta;
	private JTextField tf;

	static String myAssort(List<Tea> assort) {
		String text = "Ассортимент: \n";
		int i = 0;
		for (Tea tea : assort) {
			i++;
			text += "" + i + ") " + tea.toString() + "\n";
		}
		return text;
	}

	// Creation graphics interface program

	void interfaceGUI() {

		frame = new JFrame("Coffe & Tea");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		ta = new TextArea();
		ta.setBounds(20, 20, 550, 200);
		ta.setVisible(true);
		panel.add(ta);

		tf = new JTextField();
		tf.setBounds(20, 250, 500, 20);
		panel.add(tf);

		b1 = new JButton("Вывести список");
		b1.setActionCommand("create");
		b1.setBounds(80, 320, 180, 20);
		b1.addActionListener(this);
		panel.add(b1);

		b2 = new JButton("Купить");
		b2.setActionCommand("buy");
		b2.setBounds(300, 320, 180, 20);
		b2.addActionListener(this);
		panel.add(b2);

		String[] index = { "1", "2", "3", "4" };
		cb1 = new JComboBox(index);
		cb1.setActionCommand("box1");
		cb1.addActionListener(this);
		cb1.setBounds(260, 280, 120, 20);
		panel.add(cb1);

		frame.setVisible(true);
	}

	List<Tea> assort = new LinkedList<>();

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "create":
			assort = new LinkedList<>();
			String[] names = { "Ромашковый чай", "Мятный чай", "чай Каркаде",
					"Кофе" };
			String[] packagings = { "Мягкая", "Твёрдая", "Бумажная",
					"Фирменная" };
			for (int i = 0; i < 4; i++) {
				Tea tea;
				Random r = new Random();
				String name = names[r.nextInt(names.length)];

				String weight = "" + r.nextInt(50);
				String packaging = packagings[r.nextInt(packagings.length)];

				if (Math.random() > 0.5) {
					tea = new Coffe(name, weight, packaging);
				} else {
					tea = new Tea(name, weight, packaging);
				}
				assort.add(tea);
				ta.setText(myAssort(assort));
			}
			break;

		case "box1":
			tf.setText(assort.get(
					Integer.parseInt(cb1.getSelectedItem().toString()) - 1)
					.toString());

			break;
		}
	}

}