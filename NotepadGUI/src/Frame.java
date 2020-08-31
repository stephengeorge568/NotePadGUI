import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private static TextArea textArea;
	private static StoredData data;
	/**
	 * Launch the application.
	 * Set TextArea to StoredData object's saved string.
	 */
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Frame frame = new Frame();
					frame.setVisible(true);
					data = new StoredData();
					setText(data.getSavedText());
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Declare and initalize GUI components.
	 */
	public Frame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("FileOrganizer");
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel todoListJLabel = new JLabel("Todo List");
		horizontalBox.add(todoListJLabel);
		todoListJLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		todoListJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);
		
		JButton saveJButton = new JButton("Save");
		saveJButton.addActionListener(this);
		horizontalBox.add(saveJButton);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel moronJLabel = new JLabel("Dont be a moron, just do it.");
		moronJLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		horizontalBox_1.add(moronJLabel);
		moronJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_4);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_1);
		
		textArea = new TextArea();
		horizontalBox_2.add(textArea);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3);
		
		JProgressBar progressBar = new JProgressBar();
		verticalBox.add(progressBar);
	}
	
	/**
	 * Set the text of the GUI component textArea to str.
	 * @param str - The string value that textArea's contained string is being set to.
	 */
	public static void setText(String str)
	{
		textArea.setText(str);
	}
	
	/**
	 * Detect button press on the Save button ONLY.
	 * Save string contained in TextArea to StoredData object.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		data.writeText(textArea.getText());
    }
}
