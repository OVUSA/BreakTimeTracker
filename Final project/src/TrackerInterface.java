import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TrackerInterface  {
	private JFrame frame;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackerInterface window = new TrackerInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	
		// Create the application.
		public TrackerInterface() {
		initialize();
	}
		
		/*JTextField txtInput = new JTextField(""); FIXME

		public class txtInputListener implements ActionListener
		{
		    public void actionPerformed(ActionEvent event)
		    {
		    System.out.println("What's your name?");
		      String  input = txtInput.getText();   
		        System.out.println(input);
		        Tracker2.setName(input);
		    }
		}*/

		//Initialize the contents of the frame.
		private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(150, 150, 751, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btn_START = new JButton(" START");
		btn_START.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_START.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Tracker1.StartWork();
				
							
			}	
		});
		
		btn_START.setBounds(73, 353, 160, 110);
		frame.getContentPane().add(btn_START);
		
		
		
		
		JButton btn_STOP = new JButton("STOP");
		btn_STOP.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_STOP.setBounds(257, 353, 160, 110);
		frame.getContentPane().add(btn_STOP);
		btn_STOP.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { // FIXME
				Tracker1.StopWork();
				//Tracker1.Duration();
				//Tracker1.Duration();
				//System.out.println(Tracker1.Duration());
				
			//Label.setText(Tracker1.Duration());
				
			}	
		});
		
		
		JTextArea label = new JTextArea(10, 15);	
		
		label.setEditable(true);
		label.setBackground(Color.WHITE);;
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(56, 39, 548, 289);
		
		
		frame.getContentPane().add(label);
		 PrintStream ps = new PrintStream(
			    new OutputStream() {
			        public void write(int c){
			           label.setText(label.getText() + (char) c );
			           
			        }
			    }
			);
		 System.out.println();
			System.setOut(ps);
			
		
		JButton btn_Break = new JButton("BREAK");
		btn_Break.addActionListener(new ActionListener() {
			
					
			public void actionPerformed(ActionEvent e) {
					
				Tracker1.StartBreak();
				
			}
		});
		btn_Break.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_Break.setBounds(442, 353, 160, 110);
		frame.getContentPane().add(btn_Break);
		
		JButton EXIT = new JButton("EXIT");
		EXIT.setFont(new Font("Tahoma", Font.BOLD, 17));
		EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("You chose to end the session, here is a daily report: \n");
				Tracker2.report();
			}
		});
		EXIT.setBounds(73, 494, 531, 46);
		frame.getContentPane().add(EXIT);

		//Label.add( Tracker1.myLoop(5)
		
		
		
		
		
		}
	}

