package FourRowSolitaire;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class TopTimes extends JDialog implements ActionListener, KeyListener {
	private final int NUM_OF_RECORDS = 10;
	private final JTextField[] names = new JTextField[10];
	private final JLabel[] times = new JLabel[10];
	private final JLabel[] jLabel = new JLabel[10];
	private final JSeparator[] jSeparator = new JSeparator[10];
	private int pos;
	private JButton jButton;
	private final Component parent;

	public TopTimes(Component paramComponent) {
		this.parent = paramComponent;
		initComponents();
	}

	private void initComponents() {
		for (int i = 0; i < this.names.length; i++) {
			this.jSeparator[i] = new JSeparator();
			this.jLabel[i] = new JLabel(i + 1 + ".");
			this.names[i] = new JTextField();
			this.names[i].setBorder(null);
			this.names[i].setColumns(10);
			this.names[i].setEditable(false);
			this.times[i] = new JLabel();
			this.times[i].setText(" ");
		}
		loadData();

		this.jButton = new JButton("Clear Times");
		this.jButton.addActionListener(this);

		setDefaultCloseOperation(2);
		setTitle("Best Times");
		toFront();
		setAlwaysOnTop(true);
		requestFocus();

		GroupLayout localGroupLayout = new GroupLayout(getContentPane());
		getContentPane().setLayout(localGroupLayout);
		localGroupLayout.setHorizontalGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.jSeparator[0]).addComponent(this.jSeparator[1])
				.addComponent(this.jSeparator[2], GroupLayout.Alignment.TRAILING)
				.addGroup(localGroupLayout.createSequentialGroup()
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jSeparator[3])
								.addComponent(this.jSeparator[6], GroupLayout.Alignment.LEADING, -1, 483, 32767)
								.addComponent(this.jSeparator[5], GroupLayout.Alignment.LEADING)
								.addComponent(this.jSeparator[4], GroupLayout.Alignment.LEADING)))
				.addComponent(this.jSeparator[7], GroupLayout.Alignment.TRAILING)
				.addComponent(this.jSeparator[8], GroupLayout.Alignment.TRAILING)
				.addGroup(localGroupLayout.createSequentialGroup().addContainerGap()
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[0])
										.addGap(18, 18, 18).addComponent(this.names[0], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[0]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[1])
										.addGap(18, 18, 18).addComponent(this.names[1], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[1]).addGap(37, 37, 37))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[2])
										.addGap(18, 18, 18).addComponent(this.names[2], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[2]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[3])
										.addGap(18, 18, 18).addComponent(this.names[3], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[3]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[4])
										.addGap(18, 18, 18).addComponent(this.names[4], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[4]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[5])
										.addGap(18, 18, 18).addComponent(this.names[5], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[5]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[6])
										.addGap(18, 18, 18).addComponent(this.names[6], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[6]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[7])
										.addGap(18, 18, 18).addComponent(this.names[7], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[7]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[8])
										.addGap(18, 18, 18).addComponent(this.names[8], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[8]).addGap(38, 38, 38))
								.addGroup(localGroupLayout.createSequentialGroup().addComponent(this.jLabel[9])
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.names[9], -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.times[9]).addGap(38, 38, 38))))
				.addComponent(this.jSeparator[9]).addGroup(localGroupLayout.createSequentialGroup()
						.addGap(185, 185, 185).addComponent(this.jButton).addGap(0, 0, 32767)));
		localGroupLayout.setVerticalGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				localGroupLayout.createSequentialGroup().addContainerGap()
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[0]).addComponent(this.times[0])
								.addComponent(this.names[0], -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[0], -2, 11, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[1]).addComponent(this.times[1])
								.addComponent(this.names[1], -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[1], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[2]).addComponent(this.times[2])
								.addComponent(this.names[2], -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[2], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[3]).addComponent(this.times[3])
								.addComponent(this.names[3], -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[3], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[4]).addComponent(this.times[4])
								.addComponent(this.names[4], -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[4], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[5]).addComponent(this.names[5], -2, -1, -2)
								.addComponent(this.times[5]))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[5], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[6]).addComponent(this.names[6], -2, -1, -2)
								.addComponent(this.times[6]))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[6], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[7]).addComponent(this.names[7], -2, -1, -2)
								.addComponent(this.times[7]))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[7], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[8]).addComponent(this.names[8], -2, -1, -2)
								.addComponent(this.times[8]))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[8], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel[9]).addComponent(this.names[9], -2, -1, -2)
								.addComponent(this.times[9]))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jSeparator[9], -2, 10, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton)
						.addContainerGap(13, 32767)));

		pack();
		setLocationRelativeTo(this.parent);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	}

	public void loadData() {
		String str1 = System.getProperty("user.home") + System.getProperty("file.separator") + "frs-topTimes.dat";

		int i = 0;
		try {
			FileReader localFileReader = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(localFileReader);
			while (i < 10) {
				String str2 = localBufferedReader.readLine();
				this.names[i].setText(str2);
				str2 = localBufferedReader.readLine();
				this.times[i].setText(str2 == null ? " " : str2);
				i++;
			}
			localBufferedReader.close();
		} catch (IOException localIOException) {
		}
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		if (paramActionEvent.getSource() == this.jButton) {
			clearData();
			repaint();
		}
	}

	private void clearData() {
		String str = System.getProperty("user.home") + System.getProperty("file.separator") + "frs-topTimes.dat";
		try {
			FileWriter localFileWriter = new FileWriter(str);
			PrintWriter localPrintWriter = new PrintWriter(localFileWriter);
			for (int i = 0; i < 10; i++) {
				localPrintWriter.println(" ");
				localPrintWriter.println(" ");
				this.names[i].setText(" ");
				this.times[i].setText(" ");
			}
			localPrintWriter.close();
		} catch (IOException localIOException) {
		}
	}

	private void saveData() {
		String str = System.getProperty("user.home") + System.getProperty("file.separator") + "frs-topTimes.dat";
		try {
			FileWriter localFileWriter = new FileWriter(str);
			PrintWriter localPrintWriter = new PrintWriter(localFileWriter);
			for (int i = 0; i < 10; i++) {
				localPrintWriter.println(this.names[i].getText());
				localPrintWriter.println(this.times[i].getText());
			}
			localPrintWriter.close();
		} catch (IOException localIOException) {
		}
	}

	public void setProperties(int paramInt) {
		for (int i = 9; (i >= 1) && (i > this.pos); i--) {
			this.names[i].setText(this.names[(i - 1)].getText());
			this.times[i].setText(this.times[(i - 1)].getText());
		}
		this.names[this.pos].setEditable(true);
		this.names[this.pos].getCaret().moveDot(this.names[this.pos].getText().length());
		this.names[this.pos].setBorder(BorderFactory.createLineBorder(Color.black));
		this.times[this.pos].setText(paramInt + "");
		this.names[this.pos].getCaret().setVisible(true);
		this.names[this.pos].requestFocus();
		this.names[this.pos].select(0, this.names[this.pos].getText().length());
		this.names[this.pos].addKeyListener(this);
		this.jButton.setEnabled(false);
	}

	public void keyTyped(KeyEvent paramKeyEvent) {
	}

	public void keyPressed(KeyEvent paramKeyEvent) {
		if (paramKeyEvent.getKeyCode() == 10) {
			this.names[this.pos] = ((JTextField) paramKeyEvent.getSource());
			this.names[this.pos].setEditable(false);
			this.names[this.pos].setBorder(null);
			this.names[this.pos].getCaret().setVisible(false);
			this.names[this.pos].removeKeyListener(this);
			saveData();
		}
	}

	public void keyReleased(KeyEvent paramKeyEvent) {
	}

	public int IsTopTime(int paramInt) {
		for (int i = 0; i < 10; i++) {
			if (!this.times[i].getText().isEmpty()) {
				if (paramInt < (this.times[i].getText().equals(" ") ? Integer.MAX_VALUE
						: Integer.valueOf(this.times[i].getText()).intValue())) {
					this.pos = i;
					return i;
				}
			} else {
				this.pos = i;
				return i;
			}
		}
		this.pos = -1;
		return -1;
	}
}
