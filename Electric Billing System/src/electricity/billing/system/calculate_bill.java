package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculate_bill extends JFrame implements ActionListener
{
    Choice meternumCho,monthCho; //Here we are declaring globally becoz we want to store inside the database
    JLabel nameText,addressText;
    JTextField unitText;
    JButton submit, cancel;

    calculate_bill()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null); //We kept null becoz we have to make changes.
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meternum=new JLabel("Meter Number");
        meternum.setBounds(50,80,100,20);
        panel.add(meternum);

        meternumCho=new Choice();
        try
        {
            database c=new database();

            // Here we need to take the meternumber from "new_Customer" class
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer"); //Now in resultSet we are storing the values of new_customer table from the database

            //If we want to check if the data is there are not we use resultSet.next();
            while(resultSet.next())
            {
                meternumCho.add(resultSet.getString("meterno")); //"meterno" is the column inside the database table named "new_customer" that we r getting the value of meternumber
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        meternumCho.setBounds(180,80,100,20);
        panel.add(meternumCho);

        JLabel name=new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText=new JLabel(""); //we are accessing name from the database table named "new_customer"
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        JLabel address=new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText=new JLabel("");//Here we have to pass empty string becoz we want to store the address data from the database named "new_customer"
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        try
        {
            database c=new database();
            //Now we r storing the meternumber selected data inside resultSet.
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meterno='"+meternumCho.getSelectedItem()+"'");
            while(resultSet.next())
            {
                nameText.setText(resultSet.getString("name")); //Now it will store the values inside nametext that we have given empty string("") inside JLabel now it replaced with "name" tht is stored inside database of "new_customer"
                addressText.setText(resultSet.getString("address"));
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        meternumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) //If we click other meter number then it changes name and address according to database
            {
                try
                {
                    database c=new database();
                    //Now we r storing the meternumber selected data inside resultSet.
                    ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meterno='"+meternumCho.getSelectedItem()+"'");
                    while(resultSet.next())
                    {
                        nameText.setText(resultSet.getString("name")); //Now it will store the values inside nametext that we have given empty string("") inside JLabel now it replaced with "name" tht is stored inside database of "new_customer"
                        addressText.setText(resultSet.getString("address"));
                    }
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JLabel unitconsumed=new JLabel("Unit Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitText=new JTextField();
        unitText.setBounds(180,200,100,20);
        panel.add(unitText);

        JLabel month=new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho = new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(180,240,150,20);
        panel.add(monthCho);

        submit = new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel,"East");

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit)
        {
            String smeterNo = meternumCho.getSelectedItem();
            String sunit = unitText.getText();
            String smonth = monthCho.getSelectedItem();
            int totalBill =0;
            int units=Integer.parseInt(sunit);
            String query_tax = "select * from tax";//NOW all the values inside tax will be stored inside query_tax
            try
            {
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_tax);
                while (resultSet.next()){
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("swach_bharat"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));

                }
            }catch (Exception E)
            {
                E.printStackTrace();
            }
            String query_total_bill = "insert into bill values('"+smeterNo+"', '"+smonth+"','"+sunit+"', '"+totalBill+"','Not Paid')";
            try
            {
                database c = new database();
                c.statement.executeUpdate(query_total_bill);//Here we r storing/updating the values inside the database table named "bill"

                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                setVisible(false);
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new calculate_bill();
    }
}
