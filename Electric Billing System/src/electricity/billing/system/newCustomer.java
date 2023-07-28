package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener
{
    JLabel heading,meterNum,meternumText,city,state,email,phone; //We r declaring globally
    JButton next,cancel;
    TextField nameText,customerName,addressText,cityText,stateText,emailText,phoneText;
    newCustomer()
    {
        super("New Customer");
        setSize(700,500);
        setLocation(400,200);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);


        JLabel heading=new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        JLabel customerName=new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText=new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        JLabel meterNum=new JLabel("Meter Number"); //this meter num will be generated randomly(6 digits)
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meternumText=new JLabel(""); //By using jlabel we cannot edit the meter number
        meternumText.setBounds(180,120,150,20);
        panel.add(meternumText);

        Random ran=new Random();
        long number=ran.nextLong()%100000;
        meternumText.setText(""+Math.abs(number));//It creates random numbers inside meter number text.

        JLabel address=new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText=new TextField("");
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        JLabel city=new JLabel("City");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText=new TextField("");
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        JLabel state =new JLabel("State");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText=new TextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        JLabel email =new JLabel("Email");
        email.setBounds(50,280,100,20); //difference of spacing in y axis is 40(difference)120,160,200,240,280...
        panel.add(email);

        emailText=new TextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        JLabel phone =new JLabel("Phone");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText=new TextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);//This is background color for letters
        next.setForeground(Color.WHITE);//This is color of letters
        next.addActionListener(this);
        panel.add(next);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.BLACK);//This is background color for letters
        cancel.setForeground(Color.WHITE);//This is color of letters
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/splash/boy.png"));
        Image i2=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imgLabel=new JLabel(i3);
        add(imgLabel,"West");


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            String sname=nameText.getText();// Here we are storing all text fields inside String tht we are typing inside new customer
            String smeter=meternumText.getText();
            String saddress=addressText.getText();
            String scity=cityText.getText();
            String sstate=stateText.getText();
            String eemail=emailText.getText();
            String sphone=phoneText.getText();

            //After filling details inside new_customer page,Now we are storing inside the database table named "new_customer"
            String query_customer="insert into new_customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+eemail+"','"+sphone+"')";

            //Here inside singup table we r only passing "smeter" &"sname" and remaining are empty('')
            String query_signup="insert into Signup values('"+smeter+"','','"+sname+"','','')";

            //If we want to execute the query then it shd be inside try & catch block
            try
            {
                //Now we are creating object for database
                database c=new database();
                //With the help of statement we have to run the query
                c.statement.executeUpdate(query_customer); //Here we are updating/storing the tables by executeUpdate()
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                //After showing this msg we have to close newCustomer window
                setVisible(false);
                //After closing newCustomer window it shd redirect to meterInfo.
                new meterInfo(smeter);//After filling details inside "newCustomer" page we are passing the meterno to metrInfo class becoz we need tht meternumber
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else{
            setVisible(false); //If we r clicking the cancel button then the frame will be closed
        }


    }

    public static void main(String[] args)
    {
        new newCustomer();
    }
}
