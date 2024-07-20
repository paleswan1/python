/**
 * Class BankGUI is the class responsible to create the GUI fopr debit card and credit card
 * 
 * @author(22067699 Kshitiz Shrestha)
 * @version(1.0.0)
 */

//required imports
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BankGUI implements ActionListener {
    //attributes declaration with private access
    private JFrame debitFrame, creditFrame;

    private JPanel addDebitPanel, withdrawDebitPanel, addCreditPanel, setCreditPanel, cancelCreditPanel;

    private JButton addDebitButton, displayDebitButton, clearDebitButton, withdrawDebitButton, addCreditButton, cancelCreditButton, setCreditButton, displayCreditButton, clearCreditButton;

    private JLabel heading, id, issuerBank, bankAccount, balanceAmount, clientName, pinNumber, cvcNumber, interestRate, creditLimit, gracePeriod, expirationDate, idForSetCredit, idForCancelCredit, dateOfWithdrawal, withdrawalAmount, withdrawPIN, withdrawID;

    private JComboBox<Integer> withdrawDay, withdrawMonth, withdrawYear, expirationDay, expirationMonth, expirationYear;

    private JTextField idText, issuerBankText, clientNameText, bankAccountText, balanceAmountText, pinNumberText, withdrawIDText, withdrawalAmountText, cvcNumberText, idForCreditText, interestRateText, creditLimitText, gracePeriodText, withdrawPINText, idForSetCreditText, idForCancelCreditText;

    private ArrayList<BankCard> bank = new ArrayList<>();

    private DebitCard addedDebit;

    private CreditCard addedCredit;

    //Constructor BankGUI created which creates a GUI
    public BankGUI() {
        //array initialization for options to choose from
        String[] options = {"DebitCard", "CreditCard"};
        var selection = JOptionPane.showOptionDialog(null, "Choose an interface to continue with its respective operations", "Interface", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("/Users/kshitizshrestha/IdeaProjects/Testing/src/debit-card.png"), options, options[0]);

        //if the selection made has index 0 then GUI for debit card is shown
        if (selection == 0) {
            /*
               initialization of all required elements and components
               also setting their bounds, font, color, background  and foreground
               */
            heading = new JLabel("Debit Card");
            heading.setBounds(421, 35, 136, 47);
            heading.setFont(new Font("Arial", Font.PLAIN, 28));
            heading.setForeground(Color.WHITE);

            Border panelBorder = BorderFactory.createTitledBorder("Add Debit Card");

            id = new JLabel("Card ID: ");
            id.setBounds(78, 80, 75, 23);
            id.setFont(new Font("Arial", Font.PLAIN, 16));
            id.setForeground(Color.WHITE);

            idText = new JTextField();
            idText.setBounds(156, 75, 231, 36);
            idText.setColumns(15);
            idText.setCaretColor(Color.WHITE);
            idText.setFont(new Font("Arial", Font.PLAIN, 16));
            idText.setForeground(Color.WHITE);
            idText.setBackground(new Color(0x141414));

            issuerBank = new JLabel("Issuer bank: ");
            issuerBank.setBounds(46, 155, 91, 23);
            issuerBank.setFont(new Font("Arial", Font.PLAIN, 16));
            issuerBank.setForeground(Color.WHITE);


            issuerBankText = new JTextField();
            issuerBankText.setColumns(32);
            issuerBankText.setBounds(156, 150, 231, 36);
            issuerBankText.setCaretColor(Color.WHITE);
            issuerBankText.setFont(new Font("Arial", Font.PLAIN, 16));
            issuerBankText.setForeground(Color.WHITE);
            issuerBankText.setBackground(new Color(0x141414));


            clientName = new JLabel("Client Name: ");
            clientName.setBounds(43, 230, 100, 23);
            clientName.setFont(new Font("Arial", Font.PLAIN, 16));
            clientName.setForeground(Color.WHITE);


            clientNameText = new JTextField();
            clientNameText.setColumns(32);
            clientNameText.setBounds(156, 225, 231, 36);
            clientNameText.setCaretColor(Color.WHITE);
            clientNameText.setFont(new Font("Arial", Font.PLAIN, 16));
            clientNameText.setForeground(Color.WHITE);
            clientNameText.setBackground(new Color(0x141414));


            bankAccount = new JLabel("Bank Account: ");
            bankAccount.setBounds(472, 85, 107, 23);
            bankAccount.setFont(new Font("Arial", Font.PLAIN, 16));
            bankAccount.setForeground(Color.WHITE);


            bankAccountText = new JTextField();
            bankAccountText.setBounds(607, 80, 231, 36);
            bankAccountText.setColumns(22);
            bankAccountText.setCaretColor(Color.WHITE);
            bankAccountText.setFont(new Font("Arial", Font.PLAIN, 16));
            bankAccountText.setForeground(Color.WHITE);
            bankAccountText.setBackground(new Color(0x141414));


            balanceAmount = new JLabel("Balance Amount: ");
            balanceAmount.setBounds(457, 160, 130, 23);
            balanceAmount.setFont(new Font("Arial", Font.PLAIN, 16));
            balanceAmount.setForeground(Color.WHITE);


            balanceAmountText = new JTextField();
            balanceAmountText.setBounds(607, 155, 231, 36);
            balanceAmountText.setColumns(22);
            balanceAmountText.setCaretColor(Color.WHITE);
            balanceAmountText.setFont(new Font("Arial", Font.PLAIN, 16));
            balanceAmountText.setForeground(Color.WHITE);
            balanceAmountText.setBackground(new Color(0x141414));

            pinNumber = new JLabel("PIN: ");
            pinNumber.setBounds(548, 235, 60, 23);
            pinNumber.setFont(new Font("Arial", Font.PLAIN, 16));
            pinNumber.setForeground(Color.WHITE);

            pinNumberText = new JTextField();
            pinNumberText.setBounds(607, 230, 231, 36);
            pinNumberText.setColumns(22);
            pinNumberText.setCaretColor(Color.WHITE);
            pinNumberText.setFont(new Font("Arial", Font.PLAIN, 16));
            pinNumberText.setForeground(Color.WHITE);
            pinNumberText.setBackground(new Color(0x141414));


            addDebitButton = new JButton("ADD DEBIT CARD");
            addDebitButton.setFocusable(false);
            addDebitButton.setBackground(new Color(0xEE7828));
            addDebitButton.setBorderPainted(false);
            addDebitButton.setOpaque(true);
            addDebitButton.setBounds(303, 452, 186, 45);
            addDebitButton.setFont(new Font("Arial", Font.PLAIN, 16));
            addDebitButton.setForeground(Color.WHITE);
            //Action listener to handle the event, that is, clicking addDebitButton
            addDebitButton.addActionListener(this);

            displayDebitButton = new JButton("DISPLAY");
            displayDebitButton.setFocusable(false);
            displayDebitButton.setBackground(Color.WHITE);
            displayDebitButton.setBorderPainted(false);
            displayDebitButton.setOpaque(true);
            displayDebitButton.setBounds(537, 452, 186, 45);
            displayDebitButton.setFont(new Font("Arial", Font.PLAIN, 16));
            //Action listener to handle the event, that is, clicking displayDebitButton
            displayDebitButton.addActionListener(this);

            withdrawDebitButton = new JButton("WITHDRAW");
            withdrawDebitButton.setFocusable(false);
            withdrawDebitButton.setBackground(new Color(0xEE7828));
            withdrawDebitButton.setBorderPainted(false);
            withdrawDebitButton.setOpaque(true);
            withdrawDebitButton.setBounds(766, 573, 186, 45);
            withdrawDebitButton.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawDebitButton.setForeground(Color.WHITE);
            //Action listener to handle the event, that is, clicking withdrawDebitButton
            withdrawDebitButton.addActionListener(this);

            clearDebitButton = new JButton("CLEAR");
            clearDebitButton.setFocusable(false);
            clearDebitButton.setBackground(Color.WHITE);
            clearDebitButton.setBorderPainted(false);
            clearDebitButton.setOpaque(true);
            clearDebitButton.setBounds(766, 658, 186, 45);
            clearDebitButton.setFont(new Font("Arial", Font.PLAIN, 16));
            //Action listener to handle the event, that is, clicking clearDebitButton
            clearDebitButton.addActionListener(this);

            withdrawID = new JLabel("Card ID: ");
            withdrawID.setBounds(35, 39, 63, 25);
            withdrawID.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawID.setForeground(Color.WHITE);

            withdrawIDText = new JTextField();
            withdrawIDText.setBounds(112, 35, 126, 36);
            withdrawIDText.setColumns(10);
            withdrawIDText.setCaretColor(Color.WHITE);
            withdrawIDText.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawIDText.setForeground(Color.WHITE);
            withdrawIDText.setBackground(new Color(0x141414));

            withdrawPIN = new JLabel("PIN: ");
            withdrawPIN.setBounds(55, 110, 39, 25);
            withdrawPIN.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawPIN.setForeground(Color.WHITE);

            withdrawPINText = new JTextField();
            withdrawPINText.setBounds(112, 106, 126, 36);
            withdrawPINText.setColumns(10);
            withdrawPINText.setCaretColor(Color.WHITE);
            withdrawPINText.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawPINText.setForeground(Color.WHITE);
            withdrawPINText.setBackground(new Color(0x141414));

            withdrawalAmount = new JLabel("Withdrawal Amount: ");
            withdrawalAmount.setBounds(258, 39, 154, 25);
            withdrawalAmount.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawalAmount.setForeground(Color.WHITE);

            withdrawalAmountText = new JTextField();
            withdrawalAmountText.setBounds(422, 35, 177, 36);
            withdrawalAmountText.setColumns(22);
            withdrawalAmountText.setCaretColor(Color.WHITE);
            withdrawalAmountText.setFont(new Font("Arial", Font.PLAIN, 16));
            withdrawalAmountText.setForeground(Color.WHITE);
            withdrawalAmountText.setBackground(new Color(0x141414));

            dateOfWithdrawal = new JLabel("Date of Withdrawal: ");
            dateOfWithdrawal.setBounds(256, 114, 152, 25);
            dateOfWithdrawal.setFont(new Font("Arial", Font.PLAIN, 16));
            dateOfWithdrawal.setForeground(Color.WHITE);

            Integer[] days = {};
            ArrayList<Integer> arrayListDays = new ArrayList<>(Arrays.asList(days));
            for (int i = 0; i < 31; i++) {
                arrayListDays.add(i + 1);
            }
            days = arrayListDays.toArray(days);
            withdrawDay = new JComboBox<>(days);
            withdrawDay.setBounds(422, 110, 67, 36);
            withdrawDay.setFont(new Font("Arial", Font.PLAIN, 12));

            Integer[] months = {};
            ArrayList<Integer> arrayListMonths = new ArrayList<>(List.of());
            for (int j = 0; j < 12; j++) {
                arrayListMonths.add(j + 1);
            }
            months = arrayListMonths.toArray(months);
            withdrawMonth = new JComboBox<>(months);
            withdrawMonth.setBounds(499, 110, 67, 36);
            withdrawMonth.setFont(new Font("Arial", Font.PLAIN, 12));

            Integer[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
            withdrawYear = new JComboBox<>(years);
            withdrawYear.setBounds(573, 110, 80, 36);
            withdrawYear.setFont(new Font("Arial", Font.PLAIN, 12));

            // withdraw Debit Panel which contains all components for withdrawal
            withdrawDebitPanel = new JPanel();
            withdrawDebitPanel.setLayout(null);
            withdrawDebitPanel.setBounds(60, 539, 663, 202);
            withdrawDebitPanel.setBorder(BorderFactory.createTitledBorder(panelBorder, " Withdraw Amount", 0, 0, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
            withdrawDebitPanel.setBackground(new Color(0x2C2C2C));
            withdrawDebitPanel.add(withdrawID);
            withdrawDebitPanel.add(withdrawIDText);
            withdrawDebitPanel.add(withdrawPIN);
            withdrawDebitPanel.add(withdrawPINText);
            withdrawDebitPanel.add(withdrawalAmount);
            withdrawDebitPanel.add(withdrawalAmountText);
            withdrawDebitPanel.add(dateOfWithdrawal);
            withdrawDebitPanel.add(withdrawDay);
            withdrawDebitPanel.add(withdrawMonth);
            withdrawDebitPanel.add(withdrawYear);

            // add debit panel which contains all the components for adding debit card
            addDebitPanel = new JPanel();
            addDebitPanel.setLayout(null);
            addDebitPanel.setBounds(59, 109, 881, 317);
            addDebitPanel.setBackground(new Color(0x2C2C2C));
            addDebitPanel.setBorder(BorderFactory.createTitledBorder(panelBorder, "Add Debit Card", 0, 0, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
            addDebitPanel.add(id);
            addDebitPanel.add(idText);
            addDebitPanel.add(issuerBank);
            addDebitPanel.add(issuerBankText);
            addDebitPanel.add(clientName);
            addDebitPanel.add(clientNameText);
            addDebitPanel.add(bankAccount);
            addDebitPanel.add(bankAccountText);
            addDebitPanel.add(balanceAmount);
            addDebitPanel.add(balanceAmountText);
            addDebitPanel.add(pinNumber);
            addDebitPanel.add(pinNumberText);

            /*
             * the main farme for debit card which consists of all the components
             * panels, labels and buttons for all debit card operations are added within this frame
             */
            debitFrame = new JFrame();
            debitFrame.setVisible(true);
            debitFrame.setSize(1000, 800);
            debitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            debitFrame.getContentPane().setBackground(new Color(0x141414));
            debitFrame.setLayout(null);
            debitFrame.setTitle("Debit Card");
            debitFrame.setResizable(false);
            debitFrame.add(heading);
            debitFrame.add(addDebitPanel);
            debitFrame.add(addDebitButton);
            debitFrame.add(displayDebitButton);
            debitFrame.add(withdrawDebitPanel);
            debitFrame.add(withdrawDebitButton);
            debitFrame.add(clearDebitButton);
            //WindowAdapter() provides empty implementations for other WindowListener Methods
            debitFrame.addWindowListener(new WindowAdapter() {
                // following code is executed on closing the window
                @Override
                public void windowClosing(WindowEvent ev) {
                    //setting a boolean flag variable true
                    boolean continuationFlag = true;
                    // usage of do-while loop to have the option to run gui even after closing the window
                    do {
                        //continuation prompt displayed
                        int continuation = JOptionPane.showConfirmDialog(null, "Do you want to continue? ", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (continuation == JOptionPane.YES_OPTION) {
                            continuationFlag = false;
                            new BankGUI();
                        } else if (continuation == JOptionPane.NO_OPTION) {
                            continuationFlag = false;
                            System.exit(0);
                        }

                    } while (continuationFlag);
                }
            });


        }
        //if the selection made has index 1 then GUI for credit card is shown
        if (selection == 1) {
            /*
               initialization of all required elements and components
               also setting their bounds, font, color, background  and foreground
               */
            heading = new JLabel("Credit Card");
            heading.setBounds(421, 35, 145, 47);
            heading.setFont(new Font("Arial", Font.PLAIN, 28));
            heading.setForeground(Color.WHITE);

            Border panelBorder = BorderFactory.createTitledBorder("Add Debit Card");

            id = new JLabel("Card ID: ");
            id.setBounds(88, 51, 75, 25);
            id.setFont(new Font("Arial", Font.PLAIN, 16));
            id.setForeground(Color.WHITE);

            idForCreditText = new JTextField();
            idForCreditText.setBounds(168, 43, 231, 36);
            idForCreditText.setColumns(15);
            idForCreditText.setFont(new Font("Arial", Font.PLAIN, 16));
            idForCreditText.setCaretColor(Color.WHITE);
            idForCreditText.setForeground(Color.WHITE);
            idForCreditText.setBackground(new Color(0x141414));

            issuerBank = new JLabel("Issuer bank: ");
            issuerBank.setBounds(56, 113, 91, 25);
            issuerBank.setFont(new Font("Arial", Font.PLAIN, 16));
            issuerBank.setForeground(Color.WHITE);


            issuerBankText = new JTextField();
            issuerBankText.setColumns(32);
            issuerBankText.setBounds(168, 103, 231, 36);
            issuerBankText.setFont(new Font("Arial", Font.PLAIN, 16));
            issuerBankText.setCaretColor(Color.WHITE);
            issuerBankText.setForeground(Color.WHITE);
            issuerBankText.setBackground(new Color(0x141414));


            clientName = new JLabel("Client Name: ");
            clientName.setBounds(53, 180, 120, 25);
            clientName.setFont(new Font("Arial", Font.PLAIN, 16));
            clientName.setForeground(Color.WHITE);


            clientNameText = new JTextField();
            clientNameText.setColumns(32);
            clientNameText.setBounds(168, 170, 231, 36);
            clientNameText.setFont(new Font("Arial", Font.PLAIN, 16));
            clientNameText.setCaretColor(Color.WHITE);
            clientNameText.setForeground(Color.WHITE);
            clientNameText.setBackground(new Color(0x141414));


            bankAccount = new JLabel("Bank Account: ");
            bankAccount.setBounds(466, 45, 120, 25);
            bankAccount.setFont(new Font("Arial", Font.PLAIN, 16));
            bankAccount.setForeground(Color.WHITE);


            bankAccountText = new JTextField();
            bankAccountText.setBounds(594, 40, 231, 36);
            bankAccountText.setColumns(22);
            bankAccountText.setFont(new Font("Arial", Font.PLAIN, 16));
            bankAccountText.setCaretColor(Color.WHITE);
            bankAccountText.setForeground(Color.WHITE);
            bankAccountText.setBackground(new Color(0x141414));


            balanceAmount = new JLabel("Balance Amount: ");
            balanceAmount.setBounds(446, 105, 128, 25);
            balanceAmount.setFont(new Font("Arial", Font.PLAIN, 16));
            balanceAmount.setForeground(Color.WHITE);


            balanceAmountText = new JTextField();
            balanceAmountText.setBounds(594, 100, 231, 36);
            balanceAmountText.setColumns(22);
            balanceAmountText.setFont(new Font("Arial", Font.PLAIN, 16));
            balanceAmountText.setCaretColor(Color.WHITE);
            balanceAmountText.setForeground(Color.WHITE);
            balanceAmountText.setBackground(new Color(0x141414));

            cvcNumber = new JLabel("CVC Number: ");
            cvcNumber.setBounds(466, 172, 120, 25);
            cvcNumber.setFont(new Font("Arial", Font.PLAIN, 16));
            cvcNumber.setForeground(Color.WHITE);

            cvcNumberText = new JTextField();
            cvcNumberText.setBounds(594, 167, 231, 36);
            cvcNumberText.setColumns(22);
            cvcNumberText.setFont(new Font("Arial", Font.PLAIN, 16));
            cvcNumberText.setCaretColor(Color.WHITE);
            cvcNumberText.setForeground(Color.WHITE);
            cvcNumberText.setBackground(new Color(0x141414));


            interestRate = new JLabel("Interest Rate: ");
            interestRate.setBounds(48, 239, 120, 25);
            interestRate.setFont(new Font("Arial", Font.PLAIN, 16));
            interestRate.setForeground(Color.WHITE);

            interestRateText = new JTextField();
            interestRateText.setBounds(168, 237, 231, 36);
            interestRateText.setColumns(10);
            interestRateText.setFont(new Font("Arial", Font.PLAIN, 16));
            interestRateText.setCaretColor(Color.WHITE);
            interestRateText.setForeground(Color.WHITE);
            interestRateText.setBackground(new Color(0x141414));

            expirationDate = new JLabel("Expiration Date: ");
            expirationDate.setBounds(452, 245, 130, 25);
            expirationDate.setFont(new Font("Arial", Font.PLAIN, 16));
            expirationDate.setForeground(Color.WHITE);

            Integer[] days = {};
            ArrayList<Integer> arrayListDays = new ArrayList<>(Arrays.asList(days));
            for (int i = 0; i < 31; i++) {
                arrayListDays.add(i + 1);
            }
            days = arrayListDays.toArray(days);
            expirationDay = new JComboBox<>(days);
            expirationDay.setBounds(594, 241, 72, 36);
            expirationDay.setFont(new Font("Arial", Font.PLAIN, 14));

            Integer[] months = {};
            ArrayList<Integer> arrayListMonths = new ArrayList<>(List.of());
            for (int j = 0; j < 12; j++) {
                arrayListMonths.add(j + 1);
            }
            months = arrayListMonths.toArray(months);
            expirationMonth = new JComboBox<>(months);
            expirationMonth.setBounds(686, 241, 72, 36);
            expirationMonth.setFont(new Font("Arial", Font.PLAIN, 14));

            Integer[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
            expirationYear = new JComboBox<>(years);
            expirationYear.setBounds(773, 241, 83, 36);
            expirationYear.setFont(new Font("Arial", Font.PLAIN, 14));


            addCreditButton = new JButton("ADD CREDIT CARD");
            addCreditButton.setFocusable(false);
            addCreditButton.setBackground(new Color(0x3d8c40));
            addCreditButton.setBorderPainted(false);
            addCreditButton.setOpaque(true);
            addCreditButton.setBounds(160, 440, 200, 45);
            addCreditButton.setFont(new Font("Arial", Font.PLAIN, 16));
            addCreditButton.setForeground(new Color(0xFFFFFF));
            //Action listener to handle the event, that is, clicking addCreditButton
            addCreditButton.addActionListener(this);

            displayCreditButton = new JButton("DISPLAY");
            displayCreditButton.setFocusable(false);
            displayCreditButton.setBackground(new Color(0xF6F6F6));
            displayCreditButton.setBorderPainted(false);
            displayCreditButton.setOpaque(true);
            displayCreditButton.setBounds(400, 440, 200, 45);
            displayCreditButton.setFont(new Font("Arial", Font.PLAIN, 16));
            //Action listener to handle the event, that is, clicking displayCreditButton
            displayCreditButton.addActionListener(this);

            clearCreditButton = new JButton("CLEAR");
            clearCreditButton.setBounds(640, 440, 200, 45);
            clearCreditButton.setFocusable(false);
            clearCreditButton.setBackground(new Color(0xF6F6F6));
            clearCreditButton.setBorderPainted(false);
            clearCreditButton.setOpaque(true);
            clearCreditButton.setFont(new Font("Arial", Font.PLAIN, 16));
            //Action listener to handle the event, that is, clicking clearCreditButton
            clearCreditButton.addActionListener(this);

            cancelCreditButton = new JButton("CANCEL CREDIT CARD");
            cancelCreditButton.setBounds(620, 710, 250, 45);
            cancelCreditButton.setFocusable(false);
            cancelCreditButton.setBackground(new Color(0x3d8c40));
            cancelCreditButton.setBorderPainted(false);
            cancelCreditButton.setOpaque(true);
            cancelCreditButton.setFont(new Font("Arial", Font.PLAIN, 16));
            cancelCreditButton.setForeground(new Color(0xFFFFFF));
            //Action listener to handle the event, that is, clicking cancelCreditButton
            cancelCreditButton.addActionListener(this);

            setCreditButton = new JButton("SET CREDIT LIMIT");
            setCreditButton.setBounds(137, 710, 250, 45);
            setCreditButton.setFocusable(false);
            setCreditButton.setBackground(new Color(0x3d8c40));
            setCreditButton.setBorderPainted(false);
            setCreditButton.setOpaque(true);
            setCreditButton.setFont(new Font("Arial", Font.PLAIN, 16));
            setCreditButton.setForeground(new Color(0xFFFFFF));
            //Action listener to handle the event, that is, clicking setCreditButton
            setCreditButton.addActionListener(this);

            //addCreditPanel which contains all the components foe adding credit card
            addCreditPanel = new JPanel();
            addCreditPanel.setLayout(null);
            addCreditPanel.setBounds(59, 109, 881, 317);
            addCreditPanel.setBorder(BorderFactory.createTitledBorder(panelBorder, "Add or Cancel Credit Card", 0, 0, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
            addCreditPanel.setBackground(new Color(0x2C2C2C));
            addCreditPanel.add(id);
            addCreditPanel.add(idForCreditText);
            addCreditPanel.add(issuerBank);
            addCreditPanel.add(issuerBankText);
            addCreditPanel.add(clientName);
            addCreditPanel.add(clientNameText);
            addCreditPanel.add(bankAccount);
            addCreditPanel.add(bankAccountText);
            addCreditPanel.add(balanceAmount);
            addCreditPanel.add(balanceAmountText);
            addCreditPanel.add(cvcNumber);
            addCreditPanel.add(cvcNumberText);
            addCreditPanel.add(interestRate);
            addCreditPanel.add(interestRateText);
            addCreditPanel.add(expirationDate);
            addCreditPanel.add(expirationDay);
            addCreditPanel.add(expirationMonth);
            addCreditPanel.add(expirationYear);

            idForSetCredit = new JLabel("Card ID: ");
            idForSetCredit.setBounds(91, 31, 63, 25);
            idForSetCredit.setFont(new Font("Arial", Font.PLAIN, 16));
            idForSetCredit.setForeground(Color.WHITE);

            idForSetCreditText = new JTextField();
            idForSetCreditText.setBounds(200, 23, 126, 36);
            idForSetCreditText.setColumns(10);
            idForSetCreditText.setFont(new Font("Arial", Font.PLAIN, 16));
            idForSetCreditText.setCaretColor(Color.WHITE);
            idForSetCreditText.setForeground(Color.WHITE);
            idForSetCreditText.setBackground(new Color(0x141414));

            creditLimit = new JLabel("Credit Limit: ");
            creditLimit.setBounds(65, 85, 90, 25);
            creditLimit.setFont(new Font("Arial", Font.PLAIN, 16));
            creditLimit.setForeground(Color.WHITE);

            creditLimitText = new JTextField();
            creditLimitText.setBounds(200, 81, 126, 36);
            creditLimitText.setColumns(10);
            creditLimitText.setFont(new Font("Arial", Font.PLAIN, 16));
            creditLimitText.setCaretColor(Color.WHITE);
            creditLimitText.setForeground(Color.WHITE);
            creditLimitText.setBackground(new Color(0x141414));

            gracePeriod = new JLabel("Grace Period: ");
            gracePeriod.setBounds(49, 145, 103, 25);
            gracePeriod.setFont(new Font("Arial", Font.PLAIN, 16));
            gracePeriod.setForeground(Color.WHITE);

            gracePeriodText = new JTextField();
            gracePeriodText.setBounds(200, 139, 126, 36);
            gracePeriodText.setColumns(10);
            gracePeriodText.setFont(new Font("Arial", Font.PLAIN, 16));
            gracePeriodText.setCaretColor(Color.WHITE);
            gracePeriodText.setForeground(Color.WHITE);
            gracePeriodText.setBackground(new Color(0x141414));

            // setCreditPanel which contains all components for setting credit limit
            setCreditPanel = new JPanel();
            setCreditPanel.setLayout(null);
            setCreditPanel.setBorder(BorderFactory.createTitledBorder(panelBorder, "Set Credit Card", 0, 0, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
            setCreditPanel.setBackground(new Color(0x2C2C2C));
            setCreditPanel.setBounds(80, 500, 360, 202);
            setCreditPanel.add(idForSetCredit);
            setCreditPanel.add(idForSetCreditText);
            setCreditPanel.add(creditLimit);
            setCreditPanel.add(creditLimitText);
            setCreditPanel.add(gracePeriod);
            setCreditPanel.add(gracePeriodText);

            idForCancelCredit = new JLabel("Card ID: ");
            idForCancelCredit.setBounds(65, 85, 90, 25);
            idForCancelCredit.setFont(new Font("Arial", Font.PLAIN, 16));
            idForCancelCredit.setForeground(Color.WHITE);

            idForCancelCreditText = new JTextField();
            idForCancelCreditText.setBounds(200, 81, 126, 36);
            idForCancelCreditText.setColumns(10);
            idForCancelCreditText.setFont(new Font("Arial", Font.PLAIN, 16));
            idForCancelCreditText.setCaretColor(Color.WHITE);
            idForCancelCreditText.setForeground(Color.WHITE);
            idForCancelCreditText.setBackground(new Color(0x141414));

            // cancelCreditPanel which contains all components for cancelling credit card
            cancelCreditPanel = new JPanel();
            cancelCreditPanel.setLayout(null);
            cancelCreditPanel.setBorder(BorderFactory.createTitledBorder(panelBorder, "Cancel Credit Card", 0, 0, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
            cancelCreditPanel.setBackground(new Color(0x2C2C2C));
            cancelCreditPanel.setBounds(560, 500, 360, 202);
            cancelCreditPanel.add(idForCancelCredit);
            cancelCreditPanel.add(idForCancelCreditText);

            /*
             * the main farme for credit card which consists of all the components
             * panels, labels and buttons for all credit card operations are added within this frame
             */
            creditFrame = new JFrame();
            creditFrame.setVisible(true);
            creditFrame.setSize(1000, 800);
            creditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            creditFrame.getContentPane().setBackground(new Color(0x141414));
            creditFrame.setLayout(null);
            creditFrame.setTitle("Credit Card");
            creditFrame.setResizable(false);
            creditFrame.add(heading);
            creditFrame.add(addCreditPanel);
            creditFrame.add(addCreditButton);
            creditFrame.add(cancelCreditButton);
            creditFrame.add(setCreditPanel);
            creditFrame.add(setCreditButton);
            creditFrame.add(displayCreditButton);
            creditFrame.add(clearCreditButton);
            creditFrame.add(cancelCreditPanel);
            //WindowAdapter() provides empty implementations for other WindowListener Methods
            creditFrame.addWindowListener(new WindowAdapter() {
                // following code executed on closing the window
                @Override
                public void windowClosing(WindowEvent ev) {
                    //setting a boolean flag variable true 
                    boolean continuationFlag = true;
                    // usage of do-while loop to have the option to run gui even after closing the window
                    do {
                        int continuation = JOptionPane.showConfirmDialog(null, "Do you want to continue? ", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (continuation == JOptionPane.YES_OPTION) {
                            continuationFlag = false;
                            new BankGUI();
                        } else if (continuation == JOptionPane.NO_OPTION) {
                            continuationFlag = false;
                            System.exit(0);
                        }

                    } while (continuationFlag);
                }
            });


        }
    }

    // main method
    // creates the instance of the BankGUI which calls the constructor creating GUI
    public static void main(String[] args) {
        new BankGUI();
    }


    // actionPerformed method used to handle the events triggered within the GUI
    @Override
    public void actionPerformed(ActionEvent e) {
        // event handling for addDebitButton
        if (e.getSource() == addDebitButton) {
            // checking if any tetx fields are empty
            if(balanceAmountText.getText().isEmpty() || idText.getText().isEmpty() || bankAccountText.getText().isEmpty() || issuerBankText.getText().isEmpty() || clientNameText.getText().isEmpty() || pinNumberText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                // implementation of exception handling
                try {
                    // conversion of input into integer
                    int convertedBalanceAmount = Integer.parseInt(balanceAmountText.getText());
                    int convertedID = Integer.valueOf(idText.getText());
                    int PIN = Integer.valueOf(pinNumberText.getText());
                    
                    //validating the length of PIN and card id
                    if (pinNumberText.getText().length() != 4) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid PIN", "Debit Card", JOptionPane.ERROR_MESSAGE);
                    } 
                    else if (idText.getText().length() != 4) {
                        JOptionPane.showMessageDialog(null, "Card ID can only be 4 digits", "Debit Card", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean debitExist = false;
                        
                        // iterating over arraylist
                        for (BankCard bc : bank) {
                            //checking the card id
                            if (bc.getCardID() == convertedID) {
                                JOptionPane.showMessageDialog(null, "Card with this ID is already present", "Debit Card", JOptionPane.ERROR_MESSAGE);
                                debitExist = true;
                                break;
                            }
                        }
                        
                        // if debitcard with that id doesnt exist then add in arraylist
                        if (!debitExist) {
                            addedDebit = new DebitCard(convertedBalanceAmount, convertedID, bankAccountText.getText(), issuerBankText.getText(), clientNameText.getText(), PIN);
                            bank.add(addedDebit);
                            JOptionPane.showMessageDialog(null, "The Debit Card has been added", "Debit Card", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Invalid data format to add ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

        // event handling for displayDebitButton
        if (e.getSource() == displayDebitButton) {
            //implementation of exception handling
            try {
                try {
                    // if arraylist is empty then throw NullPointerException
                    if (bank.isEmpty()) {
                        throw new NullPointerException();
                    } else {
                        // Iterate over array list to display all details
                        for (BankCard bc : bank) {
                            int index = bank.indexOf(bc);
                            DebitCard displayDebit = (DebitCard) bank.get(index);
                            System.out.println();
                            System.out.println("=========For Card " + displayDebit.getCardID() + "=========");
                            displayDebit.display();
                            System.out.println("===============================");
                        }

                    }
                    
                } catch (NullPointerException err6) {
                    JOptionPane.showMessageDialog(null, "The debit card hasn't been added yet","Debit Card", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (NumberFormatException err7) {
                JOptionPane.showMessageDialog(null, "Enter the respective data","Debit Card", JOptionPane.ERROR_MESSAGE);
            }
        }

        // event handling for clearDebitButton
        if (e.getSource() == clearDebitButton) {
            // set all text fields "" and combo box's index to be 0
            balanceAmountText.setText("");
            idText.setText("");
            bankAccountText.setText("");
            issuerBankText.setText("");
            clientNameText.setText("");
            pinNumberText.setText("");
            withdrawIDText.setText("");
            withdrawPINText.setText("");
            withdrawalAmountText.setText("");
            withdrawDay.setSelectedIndex(0);
            withdrawMonth.setSelectedIndex(0);
            withdrawYear.setSelectedIndex(0);

        }

        // event handling for withdrawDebitButton
        if (e.getSource() == withdrawDebitButton) {
            // checks if any text fields are empty
            if(withdrawIDText.getText().isEmpty() || withdrawPINText.getText().isEmpty() || withdrawalAmountText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                // implementation of exception handling
                try {
                    // conversion into integer and concatenating the date
                    int idForWithdraw = Integer.valueOf(withdrawIDText.getText());
                    int PIN = Integer.valueOf(withdrawPINText.getText());
                    int withdrawalAmount = Integer.parseInt(withdrawalAmountText.getText());
                    String withdrawStringDay = withdrawDay.getSelectedItem().toString();
                    String withdrawStringMonth = withdrawMonth.getSelectedItem().toString();
                    String withdrawStringYear = withdrawYear.getSelectedItem().toString();
                    String date = withdrawStringDay + "/" + withdrawStringMonth + "/" + withdrawStringYear;

                    try {
                        boolean found = false;
                        // checks if the arrayList is empty and according throws NullPointerException
                        if (bank.isEmpty()) {
                            throw new NullPointerException();
                        }
                        // iterating over the array list
                        for (BankCard bc : bank) {
                            if (bc.getCardID() == idForWithdraw) {

                                int index = bank.indexOf(bc);
                                
                                //Down Cast
                                DebitCard withdrawMethod = (DebitCard) bank.get(index);
                                
                                //validating the length of the pin
                                if (withdrawMethod.getPINnumber() != PIN) {
                                    JOptionPane.showMessageDialog(null, "Invalid PIN entered", "Debit Card", JOptionPane.ERROR_MESSAGE);
                                    found = true;
                                } else {
                                    // withdraw method with the particular instance
                                    withdrawMethod.Withdraw(withdrawalAmount, date, PIN);
                                    found = true;
                                    
                                    // checking for if amount has been withdrawn using the getter method from DebitCard class
                                    if (withdrawMethod.getHasWithdrawn()) {
                                        JOptionPane.showMessageDialog(null, "Amount Successfully Withdrawn");
                                        JOptionPane.showMessageDialog(null, "Card ID: " + idForWithdraw + "\nWithdrawal Amount: " + withdrawalAmount + "\nDate Of Withdrawal: " + date + "\nPIN: " + PIN);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Insufficient Balance \nAmount cannot be Withdrawn");
                                    }
                                    break;
                                }
                            }
                        }
                        
                        // if card is not found then respective message is displayed
                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Invalid Card ID entered", "Debit Card", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } catch (NullPointerException err1) {
                        JOptionPane.showMessageDialog(null, "Debit Card not added ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Invalid data format", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        // event handling for addCreditButton
        if (e.getSource() == addCreditButton) {
            // checks if any text field is empty
            if(balanceAmountText.getText().isEmpty() || idForCreditText.getText().isEmpty() || bankAccountText.getText().isEmpty() || issuerBankText.getText().isEmpty() || clientNameText.getText().isEmpty() || cvcNumberText.getText().isEmpty() || interestRateText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    // conversion of text fields to integer and concatenating the dates as string
                    int creditCardID = Integer.valueOf(idForCreditText.getText());
                    int balanceAmountForCredit = Integer.parseInt(balanceAmountText.getText());
                    int cvc = Integer.parseInt(cvcNumberText.getText());
                    double interest = Double.parseDouble(interestRateText.getText());

                    String expirationStringDay = expirationDay.getSelectedItem().toString();
                    String expirationStringMonth = expirationMonth.getSelectedItem().toString();
                    String expirationStringYear = expirationYear.getSelectedItem().toString();
                    String expirationDate = expirationStringDay + "/" + expirationStringMonth + "/" + expirationStringYear;

                    // validating the length of id entered
                    if (idForCreditText.getText().length() != 4) {
                        JOptionPane.showMessageDialog(null, "Card ID should be 4 digits", "Credit Card", JOptionPane.ERROR_MESSAGE);
                    } 
                    //validating the maximum interest rate that can be entered
                    else if (interest > 20) {
                        JOptionPane.showMessageDialog(null, "Interest Rate too high", "Credit Card", JOptionPane.ERROR_MESSAGE);
                    }
                    // validating the length of cvc entered
                    else if (cvcNumberText.getText().length() != 3) {
                        JOptionPane.showMessageDialog(null, "CVC must be 3 digits", "Credit Card", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean creditExist = false;
                        
                        // iterating over the arraylist
                        for (BankCard bc : bank) {
                            // checking if card id matches
                            if (bc.getCardID() == creditCardID) {
                                JOptionPane.showMessageDialog(null, "Card with this ID is already present", "Credit Card", JOptionPane.ERROR_MESSAGE);
                                creditExist = true;
                                break;
                            }
                        }
                        
                        // if matching card id is not found then add the credit card in the arraylist after creating instance of ther CreditCard class
                        if (!creditExist) {
                            addedCredit = new CreditCard(creditCardID, clientNameText.getText(), issuerBankText.getText(), bankAccountText.getText(), balanceAmountForCredit, cvc, interest, expirationDate);
                            bank.add(addedCredit);
                            JOptionPane.showMessageDialog(null, "The Credit Card has been added", "Credit Card", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Invalid data format to add", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }

        }


        // event handling for the clearCreditButton
        if (e.getSource() == clearCreditButton) {
            // sets text field to "" and combo box's index to be 0
            balanceAmountText.setText("");
            idForCreditText.setText("");
            bankAccountText.setText("");
            issuerBankText.setText("");
            clientNameText.setText("");
            cvcNumberText.setText("");
            interestRateText.setText("");
            creditLimitText.setText("");
            gracePeriodText.setText("");
            expirationDay.setSelectedIndex(0);
            expirationMonth.setSelectedIndex(0);
            expirationYear.setSelectedIndex(0);
            idForSetCreditText.setText("");
            idForCancelCreditText.setText("");
        }

        //event handling for displayCreditButton
        if (e.getSource() == displayCreditButton) {
            // implementation of exception handling
            try {
                try {
                    // checking if array list is empty and if so NullPointerException is thrown
                    if (bank.isEmpty()) {
                        throw new NullPointerException();

                    } else {
                        // iterating over arrayList, downcast each instance and display
                        for (BankCard bc : bank) {
                            int index = bank.indexOf(bc);
                            CreditCard displayCredit = (CreditCard) bank.get(index);
                            System.out.println();
                            System.out.println("=========For Card " + displayCredit.getCardID() + "=========");
                            displayCredit.display();
                            System.out.println("===============================");

                        }
                    }

                } catch (NullPointerException err6) {
                    JOptionPane.showMessageDialog(null, "The credit card hasn't been added yet");
                }
                
            } catch (NumberFormatException err7) {
                JOptionPane.showMessageDialog(null, "Enter the respective data");
            }

        }

        // event handling for setCreditButton
        if (e.getSource() == setCreditButton) {
            // checks if any text field is empty
            if(idForSetCreditText.getText().isEmpty() || creditLimitText.getText().isEmpty() || gracePeriodText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                // implementation of exception handling
                try {
                    // conversion of input into Integer
                    int setCardID = Integer.valueOf(idForSetCreditText.getText());
                    double creditLimit = Double.parseDouble(creditLimitText.getText());
                    int gracePeriod = Integer.parseInt(gracePeriodText.getText());

                    try {
                        boolean found = false;
                        // checks if bank arraylist is empty and throws NullPointerException if so
                        if (bank.isEmpty()) {
                            throw new NullPointerException();
                        }
                        // iterating over arraylist
                        for (BankCard bc : bank) {
                            // checking if card id matches
                            if (bc.getCardID() == setCardID) {
                                int index = bank.indexOf(bc);
                                //Down cast
                                CreditCard setCredit = (CreditCard) bank.get(index);

                                // setCreditLimit method called from CreditCard class
                                setCredit.setCreditLimit(creditLimit, gracePeriod);
                                found = true;
                                
                                // checking granted status from CreditCard class
                                if (setCredit.getIsGranted()) {
                                    JOptionPane.showMessageDialog(null, " Credit Limit has been successfully set");
                                    JOptionPane.showMessageDialog(null, "Card ID: " + setCardID + "\nCredit Limit: " + creditLimit + "\ngracePeriod: " + gracePeriod + " days");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Credit Limit cannot be set");
                                }
                                break;
                            }
                        }
                        
                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Invalid Card ID entered", "Credit Card", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } catch (NullPointerException err3) {
                        JOptionPane.showMessageDialog(null, "Credit Card not added ", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    
                } catch (NumberFormatException err2) {
                    JOptionPane.showMessageDialog(null, "Invalid data format ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

        //event handling for cancelCreditButton
        if (e.getSource() == cancelCreditButton) {
            // check if the card id field is empty
            if(idForCancelCreditText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    // conversion of input into integer
                    int cancelCreditCardID = Integer.valueOf(idForCancelCreditText.getText());
                    
                    // implementation of exception handling
                    try {
                        boolean found = false;
                        // checks if bank arraylist is empty and throws NullPointerException
                        if (bank.isEmpty()) {
                            throw new NullPointerException();
                        }
                        // iterating over the arraylist
                        for (BankCard bc : bank) {
                            if (bc.getCardID() == cancelCreditCardID) {
                                int index = bank.indexOf(bc);
                                //Down cast
                                CreditCard cancelCredit = (CreditCard) bank.get(index);

                                //calling cancelCreditCard from CreditCard class
                                cancelCredit.cancelCreditCard();
                                found = true;
                                
                                if (!cancelCredit.getIsGranted()) {
                                    JOptionPane.showMessageDialog(null, "Credit Card has been successfully cancelled");
                                }
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Invalid Card ID entered", "Credit Card", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NullPointerException err4) {
                        JOptionPane.showMessageDialog(null, "Credit Card not added ", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException err5) {
                    JOptionPane.showMessageDialog(null, "Invalid data format ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

    }
}



