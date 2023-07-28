package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Signup extends JFrame implements ActionListener
{
    Choice loginAsCho;
    JTextField meterText,EmployerText,usernameText,nameText,passwordText;
    JButton create,back;
    Statement statement;
    Signup()
    {
        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs=new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho=new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,120,20);
        add(loginAsCho);

        JLabel meterNo=new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText=new JTextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Employer=new JLabel("Employer ID");
        Employer.setBounds(30,100,125,20);
        Employer.setVisible(true);
        add(Employer);

        EmployerText=new JTextField();
        EmployerText.setBounds(170,100,125,20);
        EmployerText.setVisible(true);
        add(EmployerText);

        JLabel userName=new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

        usernameText=new JTextField();
        usernameText.setBounds(170,140,125,20);
        add(usernameText);

        JLabel name=new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText=new JTextField("");
        nameText.setBounds(170,180,125,20);
        add(nameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {

            }

            @Override
            public void focusLost(FocusEvent e) //After entering the meternumber and if we click or focus on other textfield then our name appears automatically.
            {
                try
                {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup  where meter_no = '"+meterText.getText()+"'");
                    if (resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                    }

                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JLabel password=new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText=new JTextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String user=loginAsCho.getSelectedItem();//storing whether user selecting Admin or Customer.
                if(user.equals("Customer")){
                    Employer.setVisible(false);
                    nameText.setEditable(false);//Here we are disabling(we cant edit) the nameText field in signup page after entering the meternum manually.
                    EmployerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }else{
                    Employer.setVisible(true);
                    EmployerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        create=new JButton("Create");
        create.setBounds(50,285,100,25);
        create.setBackground(new Color(66,127,219)); //We can get these values by using google picker
        create.setForeground(Color.BLACK);
        create.addActionListener(this);
        add(create);

        back=new JButton("Back");
        back.setBackground(new Color(66,127,219));
        back.setForeground(Color.BLACK);
        back.setBounds(180,285,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash/boy.png"));
        Image boyImg=boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2=new ImageIcon(boyImg);// Now we have to convert it into JLabel
        JLabel boyLabel=new JLabel(boyIcon2);
        boyLabel.setBounds(320,30,250,250);
        add(boyLabel);

        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==create){
            String sloginAs=loginAsCho.getSelectedItem();
            String susername=usernameText.getText();
            String sname=nameText.getText();
            String spassword=passwordText.getText();
            String smeter=meterText.getText();
            try
            {
                database c=new database();
                String query=null;
                if(loginAsCho.getSelectedItem()=="Admin") //After filling all admin details inside Signup page and we are storing it into database.
                {
                    query = "insert into Signup value('" + smeter + "','" + susername + "','" + sname + "','" + spassword + "','" + sloginAs + "')";
                }else //If we are creating as Customer then we need to type meternumber manually if it is matched then it goes to else block & name will be appeared automatically if it is there inside database & finally we have type our username and password so that it will updated or stored inside our database
                {
                    query = "update Signup set username = '"+susername+"', password = '"+spassword+"', usertype = '"+sloginAs+"' where meter_no = '"+smeter+"'";//Here we r updating the values if the meternumber is matched
                }

                c.statement.executeUpdate(query); //Here we are updating or adding our data inside the Signup table that's y we r using executeUpdate(query)

                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();
            }catch (Exception E)
            {
               E.printStackTrace();
            }
        }else if(e.getSource()==back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args)
    {
        new Signup();
    }
}
