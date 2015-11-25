package net.miginfocom.examples;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class VisualPaddingWindows extends JFrame
{
	public VisualPaddingWindows()
	{
		super("MigLayout Test");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new MigLayout("nogrid, debug"));

		String cc = "";
		add(createButton(), cc);

		add(createIconButton(), cc + ", newline");

		add(createToggleButton(), cc + ", newline");

		add(createBorderButton("button", null), cc + ", newline");
		add(createBorderButton("button", new LineBorder(Color.BLACK)), cc);
		add(createBorderButton("button", new MatteBorder(3, 3, 3, 3, Color.BLACK)), cc);

		add(createCombo(false), cc + ", newline");

		add(createCombo(true), cc + ", newline");

		JTextField ta = new JTextField("No Border");
		ta.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(ta, cc + ", newline");
		add(new JTextArea("A text"), cc);
		add(new JTextField("A text"), cc);
		add(new JScrollPane(new JTextPane()), cc);
		add(new JScrollPane(new JTextArea("A text", 1, 20)), cc);
		JList list = new JList(new Object[] {"A text"});
		list.setVisibleRowCount(1);
		add(new JScrollPane(list), cc);

		add(new JTextField("Compared to"), cc + ", newline");
		add(new JSpinner(new SpinnerNumberModel(1, 1, 10000, 1)), cc);
		add(new JSpinner(new SpinnerDateModel()), cc);
		add(new JSpinner(new SpinnerListModel(new Object[]{"One", "Two", "Fifteen"})), cc);
		JSpinner spinner = new JSpinner();
		spinner.setEditor(new JTextField());
		add(spinner, cc);

		add(createToggle("toggle", true, new EmptyBorder(0, 0, 0, 0), false), cc + ", newline");
		add(createToggle("toggle", true, null, false), cc);
		add(createToggle("toggle", true, null, true), cc);
		add(createToggle("toggle", false, new EmptyBorder(0, 0, 0, 0), false), cc);
		add(createToggle("toggle", false, null, false), cc);
		add(createToggle("toggle", false, null, true), cc);

		add(createTabbedPane(), cc + ", newline, growx");

		pack();
		setLocationRelativeTo(null);
	}

	private JToggleButton createToggle(String name, boolean radio, Border border, boolean borderPainted)
	{
		JToggleButton button = radio ? new JRadioButton(name) : new JCheckBox(name);
		button.setFocusable(false);

		if (border != null)
			button.setBorder(border);
		button.setBorderPainted(borderPainted);

		return button;
	}

	private JButton createButton()
	{
		JButton button = new JButton("Button");
		button.setDefaultCapable(false);
		button.setFocusable(false);
		return button;
	}

	private JButton createIconButton()
	{
		JButton button = new JButton("Icon Button");
		button.setIcon(new ImageIcon(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB)));
		button.setDefaultCapable(false);
		button.setFocusable(false);
		return button;
	}

	private JToggleButton createToggleButton()
	{
		JToggleButton button = new JToggleButton("Toggle Button");
		button.setFocusable(false);
		return button;
	}

	private JButton createBorderButton(String name, Border border)
	{
		JButton button = new JButton(name);
		button.setDefaultCapable(false);
		button.setFocusable(false);
		button.setBorder(border);
		return button;
	}

	private JComboBox createCombo(boolean editable)
	{
		JComboBox comboBox = new JComboBox(new Object[]{ "combo"});
		comboBox.setFocusable(editable);
		comboBox.setEditable(editable);
		return comboBox;
	}

	private JTabbedPane createTabbedPane()
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("tab1", new JLabel("tab1"));
		tabbedPane.addTab("tab2", new JLabel("tab2"));
		return tabbedPane;
	}

	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch( Exception ex ) {
			ex.printStackTrace();
		}

		VisualPaddingWindows migTest = new VisualPaddingWindows();
		migTest.setVisible(true);
	}
}