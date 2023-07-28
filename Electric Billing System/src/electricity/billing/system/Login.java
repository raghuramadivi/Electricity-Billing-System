package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JTextField userText,passwordText;//We are declaring globally becoz we need to access user input,password and store in the database(BackEnd)
    Choice loginChoice;

    JButton loginButton,cancelButton,signupButton;

    Login()
    {
        super("Login");//This is the heading of the frame and super() must be the first statement inside the constructor otherwise it will show error if u write anywhere down
        getContentPane().setBackground(Color.white);
        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300,140,100,20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne =  new ImageIcon(ClassLoader.getSystemResource("icon/splash/profile.png"));
        Image profileTow = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLable = new JLabel(fprofileOne);//Inorder to show the image we have to use JLabel
        profileLable.setBounds(5,5,250,250);
        add(profileLable);



        setSize(640,300);
        setLocation(400,200);
        setLayout(null);//It will remove the border layout so that we can make changes.
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==loginButton){
            String susername = userText.getText();//Here we are storing inside the String(susername) wht we have entered username textfield in the login page
            String spassword = passwordText.getText();
            String suser = loginChoice.getSelectedItem();

            try{
                database c = new database();
                //checking whether password or username matched or not
                String queryy = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype ='"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(queryy);//here we r extracting data from signup table from database that's y we are using executeQuery and finally we r storing inside resultSet.

                //If we want to know whether the data is there inside the resultset we use resultSet.next()
                if (resultSet.next())//If the data is present then we will close the login page and redirect to main_class
                {
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new main_class(suser,meter); //suser is account type
                }else //If either username or password that u entered inside login page if it is not found inside database then it shows "Invalid login"
                {
                    JOptionPane.showMessageDialog(null ,"Invalid Login");
                }

            }catch (Exception E)
            {
                E.printStackTrace();
            }
        } else if (e.getSource()==cancelButton) {
            setVisible(false);
        } else if (e.getSource()==signupButton) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args)
    {
        new Login();
    }
}