package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener
{
    Choice meterlocCho,metertypeCho,phasecodeCho,billtypeCho;
    JButton submit;
    String meterNumber;
    meterInfo(String meterNumber) //We are getting this meter number from "newCustomer" class.
    {
        this.meterNumber=meterNumber;

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        JLabel meternumber=new JLabel("Meter Number");
        meternumber.setBounds(50,80,100,20);
        panel.add(meternumber);

        JLabel meternumberText=new JLabel(meterNumber); //So we are storing the meterNumber inside meternumberText tht we got from "newCustomer" class
        meternumberText.setBounds(180,80,150,20);
        panel.add(meternumberText);

        JLabel meterloc=new JLabel("Meter Location");
        meterloc.setBounds(50,120,100,20);
        panel.add(meterloc);

        meterlocCho=new Choice();
        meterlocCho.add("Outside");
        meterlocCho.add("Inside");
        meterlocCho.setBounds(180,120,150,20);
        panel.add(meterlocCho);

        JLabel metertype=new JLabel("Meter Type");
        metertype.setBounds(50,160,100,20);
        panel.add(metertype);

        metertypeCho=new Choice();
        metertypeCho.add("Electric Meter");
        metertypeCho.add("Solar Meter");
        metertypeCho.add("Smart Meter");
        metertypeCho.setBounds(180,160,150,20);
        panel.add(metertypeCho);

        JLabel phasecode=new JLabel("Meter Type");
        phasecode.setBounds(50,200,100,20);
        panel.add(phasecode);

        phasecodeCho=new Choice();
        phasecodeCho.add("011");
        phasecodeCho.add("022");
        phasecodeCho.add("033");
        phasecodeCho.add("044");
        phasecodeCho.add("055");
        phasecodeCho.add("066");
        phasecodeCho.add("077");
        phasecodeCho.add("088");
        phasecodeCho.add("099");
        phasecodeCho.setBounds(180,200,150,20);
        panel.add(phasecodeCho);

        JLabel billtype=new JLabel("Bill Type");
        billtype.setBounds(50,240,100,20);
        panel.add(billtype);

        billtypeCho=new Choice();
        billtypeCho.add("Normal");
        billtypeCho.add("Industrial");
        billtypeCho.setBounds(180,240,150,20);
        panel.add(billtypeCho);

        JLabel day=new JLabel("30 Days Billing Time...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note=new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1=new JLabel("By default Bill is calculated for 30days only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        submit=new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/splash/details.png"));
        Image i2=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imgLabel=new JLabel(i3);
        add(imgLabel,"East");

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)//Now we r storing inside these strings
        {
            String smeterNUm=meterNumber; //This meterNumber is cmg directly from newCustomer table but not from meterNumberText(In this page we r entering or generating the meternum inside the meterNumText).
            String sloc=meterlocCho.getSelectedItem();
            String smeterType=metertypeCho.getSelectedItem();
            String sphaseCode=phasecodeCho.getSelectedItem();
            String sbillType=billtypeCho.getSelectedItem();
            String sday="30";//Here we r created this string by our own

            //Here we r storing/inserting inside the database table named "meter_info"
            String query_meterInfo="insert into meter_info values('"+smeterNUm+"','"+sloc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sday+"')";

            //To execute this query we have to run inside try & catch block
            try
            {
                database c=new database(); //We r creating the object for database

                //With the help of statement we have to run the query
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null,"Meter Information Submitted Successfully");
                setVisible(false); //After showing the msg we have to close the window
            }catch(Exception E)
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
        new meterInfo(""); //Here we have to pass empty string becoz we r passing string inside the constructor(meterInfo()) as meterNumber tht is coming frm "newCustomer" class
    }
}
