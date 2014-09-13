package Gallhp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class Demo {

	private JFrame frame;
	private JTextField textField_dimen;
	private JTextField textField_top;
	private JTextField textField_bot;
	private JTextField textField_left;
	private JTextField textField_right;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
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
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {184, 400};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Dimension");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		textField_dimen = new JTextField();
		textField_dimen.setText("3");
		textField_dimen.setColumns(10);
		GridBagConstraints gbc_textField_dimen = new GridBagConstraints();
		gbc_textField_dimen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dimen.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dimen.gridx = 1;
		gbc_textField_dimen.gridy = 0;
		panel.add(textField_dimen, gbc_textField_dimen);
		
		JLabel label_1 = new JLabel("Top");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		textField_top = new JTextField();
		textField_top.setText("0");
		textField_top.setColumns(10);
		GridBagConstraints gbc_textField_top = new GridBagConstraints();
		gbc_textField_top.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_top.insets = new Insets(0, 0, 5, 0);
		gbc_textField_top.gridx = 1;
		gbc_textField_top.gridy = 1;
		panel.add(textField_top, gbc_textField_top);
		
		JLabel label_2 = new JLabel("Bottom");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		textField_bot = new JTextField();
		textField_bot.setText("0");
		textField_bot.setColumns(10);
		GridBagConstraints gbc_textField_bot = new GridBagConstraints();
		gbc_textField_bot.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_bot.insets = new Insets(0, 0, 5, 0);
		gbc_textField_bot.gridx = 1;
		gbc_textField_bot.gridy = 2;
		panel.add(textField_bot, gbc_textField_bot);
		
		JLabel label_3 = new JLabel("Left");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		textField_left = new JTextField();
		textField_left.setText("0");
		textField_left.setColumns(10);
		GridBagConstraints gbc_textField_left = new GridBagConstraints();
		gbc_textField_left.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_left.insets = new Insets(0, 0, 5, 0);
		gbc_textField_left.gridx = 1;
		gbc_textField_left.gridy = 3;
		panel.add(textField_left, gbc_textField_left);
		
		JLabel label_4 = new JLabel("Right");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);
		
		textField_right = new JTextField();
		textField_right.setText("0");
		textField_right.setColumns(10);
		GridBagConstraints gbc_textField_right = new GridBagConstraints();
		gbc_textField_right.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_right.insets = new Insets(0, 0, 5, 0);
		gbc_textField_right.gridx = 1;
		gbc_textField_right.gridy = 4;
		panel.add(textField_right, gbc_textField_right);
		
		JLabel label_5 = new JLabel("Simulation Type");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		panel.add(label_5, gbc_label_5);
		
		JComboBox SimType_comboBox = new JComboBox();
		SimType_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Twdahp", "Tpdahp", "Tpfahp", "Tpdohp"}));
		GridBagConstraints gbc_SimType_comboBox = new GridBagConstraints();
		gbc_SimType_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_SimType_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_SimType_comboBox.gridx = 1;
		gbc_SimType_comboBox.gridy = 5;
		panel.add(SimType_comboBox, gbc_SimType_comboBox);
		
		JLabel label_6 = new JLabel("Iteration");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 6;
		panel.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("0");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 6;
		panel.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("Speed");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 7;
		panel.add(label_8, gbc_label_8);
		
		JSlider speed_slider = new JSlider();
		GridBagConstraints gbc_speed_slider = new GridBagConstraints();
		gbc_speed_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_speed_slider.insets = new Insets(0, 0, 5, 0);
		gbc_speed_slider.gridx = 1;
		gbc_speed_slider.gridy = 7;
		panel.add(speed_slider, gbc_speed_slider);
		
		JButton button = new JButton("Play/Pause");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 8;
		panel.add(button, gbc_button);
		
		JCheckBox checkBox = new JCheckBox("Loop?");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 8;
		panel.add(checkBox, gbc_checkBox);
		
		DrawnGrid drawnGrid = new DrawnGrid(0, 0, 0, 0, 3, 3);
		GridBagConstraints gbc_drawnGrid = new GridBagConstraints();
		gbc_drawnGrid.fill = GridBagConstraints.BOTH;
		gbc_drawnGrid.gridx = 1;
		gbc_drawnGrid.gridy = 0;
		frame.getContentPane().add(drawnGrid, gbc_drawnGrid);
	}

}
