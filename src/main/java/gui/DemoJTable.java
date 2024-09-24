/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */

public class DemoJTable extends JFrame{
    private JTable tblTaiKhoan;
    private JLabel lbTen,lbTien;
    private JTextField txtTen,txtTien;
    private JButton btThem,btXoa;
    
    public DemoJTable(){
        super("Demo JTable");
        cretaGUI();
        processEvent();
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void cretaGUI(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        //Tao JTable
        String[] columnName={"Ten tai khoan","So tien"};
        Object[][] data=new Object[][]{
            {"Le Quang Bao",34000000},
            {"Le Bao",36000000}
        };
        DefaultTableModel model=new DefaultTableModel(data,columnName);
        tblTaiKhoan=new JTable(model);
        JScrollPane srollPaneTable=new JScrollPane(tblTaiKhoan);
        
        p.add(srollPaneTable);
        
        JPanel pNhapLieu=new JPanel();
        pNhapLieu.add(lbTen=new JLabel("Ten Tai Khoan"));
        pNhapLieu.add(txtTen=new JTextField(15));
        pNhapLieu.add(lbTien=new JLabel("So tien"));
        pNhapLieu.add(txtTien=new JTextField(10));
        pNhapLieu.add(btThem=new JButton("Them"));
        pNhapLieu.add(btXoa=new JButton("Xoa"));
        
        p.add(pNhapLieu,BorderLayout.NORTH);
        add(p);
    }
    public static void main(String[] args){
        DemoJTable frm=new DemoJTable();
        frm.setVisible(true);
    }
    private void processEvent(){
        btThem.addActionListener((e)->{
            DefaultTableModel model=(DefaultTableModel)tblTaiKhoan.getModel();
            model.addRow(new Object[]{txtTen.getText(),txtTien.getText()});
        });
    }
}
