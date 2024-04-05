package hotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JButton add,cancel;
	JTextField tfroomno ,tfprice;
	JComboBox typecombo,availablecombo,cleancombo;
	
	
	AddRooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("serif",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("serif",Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(200,80,150,30);
		add(tfroomno);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("serif",Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String availableOptions[] = {"Available","Occupied"};
		availablecombo = new JComboBox(availableOptions);
		availablecombo.setBounds(200 , 130,150,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("serif",Font.PLAIN,16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		String cleanOptions[] = {"Cleaned","Dirty"};
		cleancombo = new JComboBox(cleanOptions);
		cleancombo.setBounds(200 , 180,150,30);
		cleancombo.setBackground(Color.WHITE);
		add(cleancombo);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("serif",Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Bed Type");
		lbltype.setFont(new Font("serif",Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String typeOptions[] = {"Single Bed","Double Bed"};
		typecombo = new JComboBox(typeOptions);
		typecombo.setBounds(200 , 280,150,30);
		typecombo.setBackground(Color.WHITE);
		add(typecombo);
		
		add = new JButton("Add Room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel Image = new JLabel(i1);
		Image.setBounds(400,30,500,370);
        add(Image);
		
		setBounds(330,200,940,470);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
               
            if(ae.getSource() == add){
                String room = tfroomno.getText();
                String available = (String)availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String type = (String)typecombo.getSelectedItem();
                
             try { 
                Conn c = new Conn();
                String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
               
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(ae.getSource() == cancel){
                this.setVisible(false);
            }
        
    }
	
	public static void main(String[] args) {
		new AddRooms();
	}
}
