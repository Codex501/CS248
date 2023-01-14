import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class close extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.out.println("Good game, nerd!");
		System.exit(0);
	}
}

class tic extends JFrame implements ActionListener
{
	JButton TL,TM,TR,ML,MM,MR,BL,BM,BR;
	JTextField winner;	
	boolean  booleanArray[] = new boolean[9];
	boolean  AIArray[] = new boolean[9];
	JButton COMPUTER;
	
	class art extends JPanel
	{
		public art()
		{
			setSize(800,700);
			for (int i = 0; i < 9; i++)
				{ booleanArray[i] = true; AIArray[i] = true; } // clicked = false; unclicked = true
		}
		
		// whenever a specfic button is clicked, we'll signify within our array
		public void TLclicked() { booleanArray[0]=false; }
		public void TMclicked() { booleanArray[1]=false; }
		public void TRclicked() { booleanArray[2]=false; }
		public void MLclicked() { booleanArray[3]=false; }
		public void MMclicked() { booleanArray[4]=false; }
		public void MRclicked() { booleanArray[5]=false; }
		public void BLclicked() { booleanArray[6]=false; }
		public void BMclicked() { booleanArray[7]=false; }
		public void BRclicked() { booleanArray[8]=false; }
		
		// call this function to check if predetermined combinations of keys are satisfied.
		public void whowon( boolean [] booleanArray, boolean [] AIArray) 
		{
			JFrame frame;
			frame = new JFrame("tictak! - our first gui program!");
			frame.addWindowListener(new close());
			frame.setSize(500,500);
			JPanel p=new JPanel();
			p.setBounds(224,233, 250,250);
			p.setBorder(BorderFactory.createBevelBorder(0));
			frame.add(p);
		
			// checking selections of all winning combinations... highly efficient, i know.
			// checking user's array
			if((booleanArray[0] == false)&&(booleanArray[1] == false) && (booleanArray[2] == false))
				{	winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);} // not sure why this is printing on terminal rather than the gameboard.
			else if((booleanArray[0] == false)&&(booleanArray[4] == false) && (booleanArray[8] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[0] == false)&&(booleanArray[3] == false) && (booleanArray[7] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[1] == false)&&(booleanArray[3] == false) && (booleanArray[6] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[1] == false)&&(booleanArray[5] == false) && (booleanArray[8] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[2] == false)&&(booleanArray[4] == false) && (booleanArray[6] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[2] == false)&&(booleanArray[5] == false) && (booleanArray[7] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[3] == false)&&(booleanArray[4] == false) && (booleanArray[5] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((booleanArray[6] == false)&&(booleanArray[7] == false) && (booleanArray[8] == false))
				{ winner = new JTextField("You won!"); winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((AIArray[0] == false)&&(AIArray[1] == false) && (AIArray[2] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center"); frame.setVisible(true);}
			else if((AIArray[0] == false)&&(AIArray[4] == false) && (AIArray[8] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[0] == false)&&(AIArray[3] == false) && (AIArray[7] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[1] == false)&&(AIArray[3] == false) && (AIArray[6] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[1] == false)&&(AIArray[5] == false) && (AIArray[8] == false))
				{ winner = new JTextField("You lost - CPU wins!"); winner.setSize(500,500);p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[2] == false)&&(AIArray[4] == false) && (AIArray[6] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[2] == false)&&(AIArray[5] == false) && (AIArray[7] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[3] == false)&&(AIArray[4] == false) && (AIArray[5] == false))
				{ winner = new JTextField("You lost - CPU wins!"); winner.setSize(500,500);p.add(winner, "Center");frame.setVisible(true);}
			else if((AIArray[6] == false)&&(AIArray[7] == false) && (AIArray[8] == false))
				{ winner = new JTextField("You lost - CPU wins!");winner.setSize(500,500); p.add(winner, "Center");frame.setVisible(true);}
			
		} 
		
		// generates the position that our cpu opponent will select
		public void randomnum()
		{
			int rand = (int)(0+9*Math.random());
			while((booleanArray[rand] == false) || (AIArray[rand] == false))
				{ rand = (int)(0+9*Math.random()); } // regenerate whenever initial is an already-clicked button
			AIArray[rand] = false;
		}
		
	private int x,y,w,h,z,c;			
		public void paintComponent(Graphics g)
		{
			// the basics of our board design
			g.setColor(Color.white);
				g.fillRect(0,0,800,700);
			x = 75; y = 75; w = 330; h = 365; z = 375; c = 75;
			g.setColor(Color.black);
				g.fillRect(75,425,625,1); //B straight line
				g.fillRect(75,85,670,1); //T straight line
				g.fillRect(215,250,350,1); //M straight line
				g.drawLine(x, y, x+w, y+h);//TL to BM diagonal
				g.drawLine(x,y+h,x+w,y); //BL to TM diagonal
				g.drawLine(z,c,z+w,c+h); //TM to BR diagonal
				g.drawLine(z,c+h,z+w,c); //BM to TR diagonal
				g.drawLine(x,y,z+w,c+h); //TL to BR diagonal
				g.drawLine(x,y+h,z+w,c); //BL to TR diagonal
			
			// each time there is an action called, we'll adjust the color of all buttons based on if they've beeen clicked already or not. If unclicked, keep it black; if clicked by user, make it pink; if "clicked" by cpu, make it red.
			if(booleanArray[0] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[0] == false) {g.setColor(Color.red);}
			g.fillOval(50,50, 75,75);//TL
			
			if(booleanArray[1] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[1]== false) {g.setColor(Color.red);}
			g.fillOval(350,50, 75,75);//TM
			
			if(booleanArray[2] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[2]== false) {g.setColor(Color.red);}
			g.fillOval(670,50,75,75);//TR
			
			if(booleanArray[3] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[3]== false) {g.setColor(Color.red);}
			g.fillOval(205,215, 75,75);//ML
			
			if(booleanArray[4] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[4]== false) {g.setColor(Color.red);}
			g.fillOval(350,215, 75,75);//MM
			
			if(booleanArray[5] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[5]== false) {g.setColor(Color.red);}
			g.fillOval(505,215, 75,75);//MR
			
			if(booleanArray[6] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[6] == false) {g.setColor(Color.red);}
			g.fillOval(50,390, 75,75);//BL
			
			if(booleanArray[7] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[7]== false) {g.setColor(Color.red);}
			g.fillOval(350,390, 75,75);//BM
			
			if(booleanArray[8] == true) {g.setColor(Color.black);}	
			else {g.setColor(Color.pink);}
			if(AIArray[8]== false) {g.setColor(Color.red);}
			g.fillOval(660,390, 75,75);//BR
		}
	}
	
	art beautiful;
	int clickCount = 0;
	public void actionPerformed(ActionEvent e)
	{
		// based on action taken on board, represent via our functions & increase the number of buttons clicked
		if(e.getSource() == TL) { beautiful.TLclicked(); clickCount ++; }
		if(e.getSource() == TM) { beautiful.TMclicked(); clickCount ++; }
		if(e.getSource() == TR) { beautiful.TRclicked(); clickCount ++; }
		if(e.getSource() == ML) { beautiful.MLclicked(); clickCount ++; }
		if(e.getSource() == MM) { beautiful.MMclicked(); clickCount ++; }
		if(e.getSource() == MR) { beautiful.MRclicked(); clickCount ++; }
		if(e.getSource() == BL) { beautiful.BLclicked(); clickCount ++; }
		if(e.getSource() == BM) { beautiful.BMclicked(); clickCount ++; }
		if(e.getSource() == BR) { beautiful.BRclicked(); clickCount ++; }
		
		// we don't want to try to fill more boxes than exist; also assumes that user won't click same button more than once. Given more time, we'd develop an alternative method to ensure just that.
		if(clickCount < 9) { beautiful.randomnum(); clickCount++; } 
		beautiful.repaint();
		beautiful.whowon(booleanArray, AIArray); // check for a winner after every click
	}
	
	public tic()
	{
		setTitle("Jerry Tac Toe");
		setSize(800,700);
		addWindowListener(new close());
		
		// get the content pane and put stuff in
		java.awt.Container glass=getContentPane();
		TL = new JButton(""); TM = new JButton(""); TR = new JButton("");
		ML = new JButton(""); MM = new JButton(""); MR = new JButton("");
		BL = new JButton(""); BM = new JButton(""); BR = new JButton("");
		COMPUTER = new JButton("Make your move or tell us to! Click for CPU's move.");
		TL.setBounds(69,70, 75/2,75/2); TM.setBounds(370,70, 75/2,75/2); TR.setBounds(690,70, 75/2,75/2);
		ML.setBounds(224,233, 75/2,75/2); MM.setBounds(370,233, 75/2,75/2); MR.setBounds(525,233, 75/2,75/2);
		BL.setBounds(69,407,75/2,75/2); BM.setBounds(365,407, 75/2,75/2); BR.setBounds(678,407, 75/2,75/2); 
		//HUMAN.setBounds(20, 700, 40, 700); COMPUTER.setBounds(550, 700, 570, 700);
		add(TL); add(TM); add(TR); 
		add(ML); add(MM); add(MR);
		add(BL); add(BM); add(BR); 
		add(COMPUTER);
		TL.addActionListener(this); TM.addActionListener(this); TR.addActionListener(this);
		ML.addActionListener(this); MM.addActionListener(this); MR.addActionListener(this);
		BL.addActionListener(this); BM.addActionListener(this); BR.addActionListener(this);
		COMPUTER.addActionListener(this);
		beautiful=new art();
		glass.add( beautiful,"Center" );
		glass.add(COMPUTER, "South");
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		String goesFirst; char first;
		Scanner cin = new Scanner(System.in);
		char condition = ' ';
		do
		{
			tic jello=new tic();
			System.out.print("Would you like to play this fun, fun game again? (Y/N) ");
			
			// Create a keyboard scanner to create the option to repeat
			Scanner cinrepeat=new Scanner(System.in);
			char repeat=cinrepeat.next().charAt(0);
			// store the variable so we can pass it as though it's by-reference
			condition = repeat;
			
			// casual conversation with a CPU.. what about it?
			if(condition == 'y' || condition == 'Y')
				System.out.print("Fantastic. \n");
			else if (condition == 'n' || condition == 'N')
				System.out.print("Bummer. \n");
			else
				System.out.print("Sorry I didn't quite catch that. \n");
			System.out.println(" ");
			
		}while(condition == 'Y' || condition == 'y');
		
	}
}