/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ISHIKA MITTAL
 */

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JFontChooser extends JDialog implements ListSelectionListener
{
	JPanel pan1, pan2, pan3;
	JLabel fontLabel, sizeLabel, typeLabel, previewLabel;
	JTextField label, fontText, sizeText, typeText;
	JScrollPane fontScroll, typeScroll, sizeScroll;
	JList fontList, sizeList, typeList;
	JButton Ok, Cancel;
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public JFontChooser()
	{
		setTitle("Choose Font"); 
                                        //setModal(true);
		setSize(300,400);
		setResizable(false);
		gbl = new GridBagLayout();
		setLayout(gbl);
		gbc = new GridBagConstraints();

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		fontLabel = new JLabel("Fonts: ");
		getContentPane().add(fontLabel,gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		sizeLabel = new JLabel("Sizes:");
		getContentPane().add(sizeLabel,gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		typeLabel = new JLabel("Types:");
		getContentPane().add(typeLabel,gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		fontText = new JTextField("Arial",12); //Default font and size
		getContentPane().add(fontText,gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		sizeText = new JTextField("8",4);
		getContentPane().add(sizeText,gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		typeText = new JTextField("Regular",6); //Default font and size
		getContentPane().add(typeText,gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontList = new JList(fonts);
		fontList.setFixedCellWidth(110);
		fontList.addListSelectionListener(this);
		fontList.setSelectedIndex(0);
		fontScroll = new JScrollPane(fontList);
		getContentPane().add(fontScroll,gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] sizes = {"8","10","12","16","18","20","24","28","32","48","72"};
		sizeList = new JList(sizes);
		sizeList.setFixedCellWidth(40);
		sizeList.addListSelectionListener(this);
		sizeList.setSelectedIndex(0);
		sizeScroll = new JScrollPane(sizeList);
		getContentPane().add(sizeScroll,gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		String[] types = {"Regular","Bold","Italic","Bold Italic"};
		typeList = new JList(types);
		typeList.setFixedCellWidth(60);
		typeList.addListSelectionListener(this);
		typeList.setSelectedIndex(0);
		typeScroll = new JScrollPane(typeList);
		getContentPane().add(typeScroll,gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		pan1 = new JPanel();
		pan1.setLayout(new FlowLayout());
		previewLabel = new JLabel("Preview: ");
		pan1.add(previewLabel);
		getContentPane().add(pan1,gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		label = new JTextField("AaBbCcDdEeFfGgHhIi");
		label.setEditable(false);
		label.setBorder(BorderFactory.createEtchedBorder());
		label.setFont(new Font("Arial",Font.PLAIN,20));
		pan2.add(label);
		getContentPane().add(pan2,gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		pan3 = new JPanel();
		pan3.setLayout(new FlowLayout());
		Ok = new JButton("OK");
		Cancel = new JButton("Cancel");
		pan3.add(Ok);
		pan3.add(Cancel);
		getContentPane().add(pan3,gbc);

	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		try
		{
			if(e.getSource()==fontList)
			{
				Font f1 = new Font(String.valueOf(fontList.getSelectedValue()),typeList.getSelectedIndex(),Integer.parseInt(String.valueOf((sizeList.getSelectedValue()))));
				fontText.setText(String.valueOf(fontList.getSelectedValue()));
				label.setFont(f1);
			}
			else if(e.getSource()==sizeList)
			{
				Font f2 = new Font(String.valueOf(fontList.getSelectedValue()),typeList.getSelectedIndex(),Integer.parseInt(String.valueOf((sizeList.getSelectedValue()))));
				sizeText.setText(String.valueOf(sizeList.getSelectedValue()));
				label.setFont(f2);
			}
			else
			{
				Font f3 = new Font(String.valueOf(fontList.getSelectedValue()),typeList.getSelectedIndex(),Integer.parseInt(String.valueOf((sizeList.getSelectedValue()))));
				typeText.setText(String.valueOf(typeList.getSelectedValue()));
				label.setFont(f3);
			}
		}catch(Exception ee)
		{
		}
	}
	public Font font()
	{
		Font font = new Font(String.valueOf(fontList.getSelectedValue()),typeList.getSelectedIndex(),Integer.parseInt(String.valueOf((sizeList.getSelectedValue()))));
		return font;
	}
	public JButton getOk()
	{
		return Ok;
	}
	public JButton getCancel()
	{
		return Cancel;
	}

}
