package second_shape_drawing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DrawingProg2 extends JFrame implements ActionListener{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;
	DrawingPanel dp = new DrawingPanel();
	JCheckBox filled = new JCheckBox("filled");
	JRadioButton rectangle, oval, line, scribble;
	
	public DrawingProg2() {
		super("Second Shape Drawing");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String [] colors = {"red", "green", "blue"};
		String [] shapes1 = {"rectangle", "oval", "line", "scribble"};
		
		layout (shapes1, colors);
		setVisible(true);
	}
	
	private void layout(String [] shapes, String [] colors) {
		//sets defaults
		dp.drawing.setColor(Color.RED);
		dp.drawing.setDrawType(DrawType.rectangle);
		setLayout (new BorderLayout ());
		add(dp, BorderLayout.CENTER);
		
		//JPanel with flow layout for the North which will have the filled JCheckBox and necessary radio buttons 
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		ButtonGroup shapeNames = new ButtonGroup();
		
		north.add(filled);
		filled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(filled.isSelected()) {
					dp.drawing.setFilled(true);
				} else {
					dp.drawing.setFilled(false);
				}
			}
		});
		
		rectangle = new JRadioButton (shapes[0]);
		north.add(rectangle);
		shapeNames.add(rectangle);
		rectangle.addActionListener(this);
		
		oval = new JRadioButton(shapes[1]);
		north.add(oval);
		shapeNames.add(oval);
		oval.addActionListener(this);
		
		line = new JRadioButton(shapes[2]);
		north.add(line);
		shapeNames.add(line);
		line.addActionListener(this);
		
		scribble = new JRadioButton(shapes[3]);
		north.add(scribble);
		shapeNames.add(scribble);
		scribble.addActionListener(this);
		
		add(north, BorderLayout.NORTH);
	}
	
	@Override 
	public void actionPerformed (ActionEvent e) {
		Object source = e.getSource();
		if (source == rectangle) {
			dp.drawing.setDrawType(DrawType.rectangle);
		} else if (source == oval) {
			dp.drawing.setDrawType(DrawType.oval);
		} else if (source == line) {
			dp.drawing.setDrawType(DrawType.line);
		} else if (source == scribble) {
			dp.drawing.setDrawType(DrawType.scribble);
		}
	}
	
	public static void main (String [] args) {
		DrawingProg2 gui = new DrawingProg2 ();
		gui.setVisible(true);
	}
}


