package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener
{
    String acctype;
    String meter_pass;
    main_class(String acctype,String meter_pass)
    {
        this.acctype=acctype;
        this.meter_pass=meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);//Our frame will be appeared as same as our screen

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash/ebs.png"));
        Image image=imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image);
        JLabel imagelable=new JLabel(imageIcon2);
        add(imagelable);

        JMenuBar menuBar=new JMenuBar();//At the top menu bar will be created
        setJMenuBar(menuBar);

        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem newcustomer=new JMenuItem("New Customer"); //By using JMenuItem we can items inside menu.
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        newcustomer.addActionListener(this);
        menu.add(newcustomer); //now by clicking menu we can see "New Customer"

        JMenuItem customerdetails=new JMenuItem("Customer Details"); //By using JMenuItem we can items inside menu.
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/customerDetails.png"));
        Image customerdetailsImage=customerdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerdetailsImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails); //now by clicking menu we can see "Customer Details"

        JMenuItem depositdetails=new JMenuItem("Deposit Details"); //By using JMenuItem we can items inside menu.
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/depositdetails.png"));
        Image depositdetailsImage=depositdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails); //now by clicking menu we can see "Deposit Details"

        JMenuItem calculatebill=new JMenuItem("Calculate Bill"); //By using JMenuItem we can items inside menu.
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatebillImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculatorbills.png"));
        Image calculateImage=calculatebillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(calculateImage));
        calculatebill.addActionListener(this);
        menu.add(calculatebill); //now by clicking menu we can see "Calculate Bill"

        JMenu info=new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem upinfo=new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon upinfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/refresh.png"));
        Image upinfoImage=upinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoImage));
        upinfo.addActionListener(this);
        info.add(upinfo); //now by clicking info we can see "Upadate Information"

        JMenuItem viewinfo=new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewinfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/information.png"));
        Image viewinfoImage=viewinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoImage));
        viewinfo.addActionListener(this);
        info.add(viewinfo); //now by clicking info we can see "View Information"

        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem paybill=new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon paybillImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/pay.png"));
        Image paybillImage=paybillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillImage));
        paybill.addActionListener(this);
        user.add(paybill); //now by clicking user we can see "Pay Bill"

        JMenuItem billdetails=new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon billdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/detail.png"));
        Image billdetailsImage=billdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.addActionListener(this);
        user.add(billdetails); //now by clicking user we can see "Bill Details"

        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem genBill=new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon genBillImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/bill.png"));
        Image genBillImage=genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill); //now by clicking bill we can see "Generate Bill"

        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/notepad.png"));
        Image notepadImage=notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad); //now by clicking utility we can see "Notepad"

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatorImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculator.png"));
        Image calculatorImage=calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        utility.add(calculator); //now by clicking utility we can see "calculator"

        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,15));

        JMenuItem eexit=new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon eexitImg=new ImageIcon(ClassLoader.getSystemResource("icon/splash/exit.png"));
        Image eexitImage=eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit); //now by clicking Exit we can see "EXIT"

        if (acctype.equals("Admin"))
        {
            menuBar.add(menu);//Inside that bar we are adding menu option.
        }else
        {
            menuBar.add(bill);//Inside that bar we are adding "Bill" option.
            menuBar.add(user);//Inside that bar we are adding "User" option.
            menuBar.add(info);//Inside that bar we are adding Information option.
        }

        menuBar.add(utility);//Inside that bar we are adding "Utility" option.
        menuBar.add(exit);//Inside that bar we are adding "Exit" option.

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer"))
        {
            new newCustomer();
        } else if (msg.equals("Customer Details"))
        {
            new customer_details();
        } else if (msg.equals("Deposit Details"))
        {
            new deposit_details();
        } else if (msg.equals("Calculate Bill"))
        {
            new calculate_bill();
        } else if (msg.equals("View Information"))
        {
            new view_information(meter_pass);
        }else if (msg.equals("Update Information"))
        {
            new update_information(meter_pass);
        }else if (msg.equals("Bill Details"))
        {
            new bill_details(meter_pass);
        }else if (msg.equals("Calculator"))
        {
            try //If we are running outside functions(calc.exe) we need to take inside try & catch
            {
                Runtime.getRuntime().exec("calc.exe"); //Our calculator is already installed on our windows it is in .exe file
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else if (msg.equals("Notepad"))
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");//We have to open it on runtime
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else if (msg.equals("Exit"))
        {
            setVisible(false);
            new Login();
        }else if (msg.equals("Pay Bill"))
        {
            new pay_bill(meter_pass);
        }else if (msg.equals("Generate Bill"))
        {
            new generate_bill(meter_pass);
        }
    }

    public static void main(String[] args)
    {

        new main_class("","");
    }
}
