
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
	Container c;
    JLabel label1,label2;
    JTextField user;
    JPasswordField pass;
    JButton btn;
	OnlineTest(){
        setTitle("LoginForm");
        setVisible(true );
        setSize(400,300);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c=getContentPane();
		c.setLayout(null);
		
		
		this.addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) 
            { 
				
                System.exit(0); 
            } 
        }); 
        label1=new JLabel("username");
        label2=new JLabel("password");
        label1.setBounds(10,50,100,20);
        label2.setBounds(10,100,100,20);
        c.add(label1);
        c.add(label2);
        user=new JTextField();
        user.setBounds(120,50,120,20);
        c.add(user);
        pass = new JPasswordField();
        pass.setBounds(120,100,120,20);
        c.add(pass);
        btn=new JButton("login");
        btn.setBounds(100,150,70,20);
        c.add(btn);
        btn.addActionListener(this);
        setVisible(true);

		
		
		
		

    }
    
	
	JButton btnNext, btnBookmark,btn2;
	JLabel label;
	ButtonGroup bg;
	private int start = 1;
private JButton jbtn; 
private Timer swingtimer;
	int m[] = new int[15];
	JRadioButton radioButton[] = new JRadioButton[5];
	int current = 0,count = 0, x = 1, y = 1, now = 0;
	

	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		
		
		btnNext = new JButton("Next Question");
		btnBookmark = new JButton("Bookmark Question");
		btn2= new JButton("Log Out");
		jbtn = new JButton("Starting Timer...2 min");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		btn2.addActionListener(this);
		jbtn.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
        add(btn2);
		add(jbtn);
		
		 start += 60;
		 set();
		
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 150, 30);
		btnBookmark.setBounds(270, 240, 200, 30);
		btn2.setBounds(1100,10,200,20);
         jbtn.setBounds(800,10,200,20);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(700,600); 
		Color c = new Color(173,216,230);
		getContentPane().setBackground(c); 
		

	}

     
      public void actionPerformed(ActionEvent e) {

		
		start--;
		if(start>=1)
		{
		jbtn.setText("Time : "+start);//changing the label of button as the timer decrases
		
		}else{
			jbtn.setText("Timeout... Now,Close the Window");
			swingtimer.stop();
			}
		
		
		
		if(e.getSource()==btn2){
			System.exit(0);
		}
		if (e.getSource() == btnNext) {
			if (qcheck())
				count = count + 1;
			current++;
			set();
			if (current == 14) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		
		if (e.getActionCommand().equals("Bookmark Question")) {
			JButton bk = new JButton("Bookmark " + x);
			bk.setBounds(480, 20 + 30 * x, 150, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 14)
				btnBookmark.setText("Score");
			setVisible(false);
			setVisible(true);
		}
		
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (qcheck())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}
		
		if (e.getActionCommand().equals("Result")) {
			if (qcheck())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(null, count, "your result is out of 15", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
			
        
		}
	
		System.out.println("username"+user.getText());
		System.out.println("password"+pass.getText());
		dispose();
		
	
		
		
	}
	

	/* SET Questions with options */
	void set() {
		swingtimer = new Timer(2222,this);
         swingtimer.start(); 
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Which of the following is not a Java features?");
			radioButton[0].setText("Dynamic");
			radioButton[1].setText("Architecture Neutral");
			radioButton[2].setText("Use of pointers");
			radioButton[3].setText("Object-oriented");
		}
		if (current == 1) {
			label.setText("Que2: Which package contains the Random class?");
			radioButton[0].setText("java.util package");
			radioButton[1].setText("java.lang package");
			radioButton[2].setText("java.awt package");
			radioButton[3].setText("java.io package");
		}
		if (current == 2) {
			label.setText("Que3:  An interface with no fields or methods is known as a ______.");
			radioButton[0].setText("Runnable Interface");
			radioButton[1].setText("Marker Interface");
			radioButton[2].setText("Abstract Interface");
			radioButton[3].setText(" CharSequence Interface");
		}
		if (current == 3) {
			label.setText("Que4: Wrapping data and its related functionality into a single entity is known as _____________");
			radioButton[0].setText(" Abstraction");
			radioButton[1].setText("Encapsulation");
			radioButton[2].setText("Polymorphism");
			radioButton[3].setText("Modularity");
		}
		if (current == 4) {
			label.setText("Que5:  Which option is false about the final keyword?");
			radioButton[0].setText(" package");
			radioButton[1].setText("import");
			radioButton[2].setText("extends");
			radioButton[3].setText("export");
		}
		if (current == 5) {
			label.setText("Que6:  How many threads can be executed at a time?");
			radioButton[0].setText("Only one thread");
			radioButton[1].setText(" Multiple threads");
			radioButton[2].setText("Only main (main() method) thread");
			radioButton[3].setText("Two threads");
		}
		if (current == 6) {
			label.setText("Que7:  Which component is used to compile, debug and execute the java programs?");
			radioButton[0].setText("JRE");
			radioButton[1].setText("JIT");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JVM");
		}
		if (current == 7) {
			label.setText("Que8:  Which one of the following is not a Java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("Portable");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (current == 8) {
			label.setText("Que9: Which of these cannot be used for a variable name in Java?");
			radioButton[0].setText("identifier & keyword");
			radioButton[1].setText("identifier");
			radioButton[2].setText("keyword");
			radioButton[3].setText("none of the mentioned");
		}
		if (current == 9) {
			label.setText("Que10: What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
		}
		if (current == 10) {
			label.setText("Que11: Which is more effective while calling the C++ functions?");
			radioButton[0].setText("call by object");
			radioButton[1].setText("call by pointer");
			radioButton[2].setText("call by value");
			radioButton[3].setText("call by reference");
		}
		if (current == 11) {
			label.setText("Que12: Which of the following is used to terminate the function declaration in C++?");
			radioButton[0].setText(";");
			radioButton[1].setText("]");
			radioButton[2].setText(")");
			radioButton[3].setText(":");
		}
		if (current == 12) {
			label.setText("Que13: Which keyword is used to define the macros in c++?");
			radioButton[0].setText(" #macro");
			radioButton[1].setText("#define");
			radioButton[2].setText("macro");
			radioButton[3].setText("define");
		}
		if (current == 13) {
			label.setText("Que14:  The C++ code which causes abnormal termination/behaviour of a program should be written under _________ block.");
			radioButton[0].setText("catch");
			radioButton[1].setText(" throw");
			radioButton[2].setText("try");
			radioButton[3].setText("finally");
		}
		if (current == 14) {
			label.setText("Que15: Which of the following symbol is used to declare the preprocessor directives in C++?");
			radioButton[0].setText("$");
			radioButton[1].setText("^");
			radioButton[2].setText("#");
			radioButton[3].setText("*");
		}
		
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	/* declare right answers. */
	boolean qcheck() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[0].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());
		if(current == 10)  
			return(radioButton[3].isSelected()); 
		if(current == 11)  
			return(radioButton[0].isSelected());
		if(current == 12)  
			return(radioButton[1].isSelected());
		if(current == 13)  
			return(radioButton[2].isSelected());
		if(current == 14)  
			return(radioButton[2].isSelected());                    
		return false; 
	}

	public static void main(String s[]) {
		
	
	
		new OnlineTest("Online Exam Portal");
		
		OnlineTest o=new OnlineTest();
		try {
			Thread. sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		o.setVisible(false);
	}


	
}