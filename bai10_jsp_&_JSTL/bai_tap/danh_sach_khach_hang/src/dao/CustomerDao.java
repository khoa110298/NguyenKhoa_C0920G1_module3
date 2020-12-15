package dao;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Mai Văn Hoàng","1983-08-20","Hà Nội","anh/anh1.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","anh/anh2.png"));
        customerList.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","anh/anh3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","anh/anh4.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","anh/anh5.jpg"));
    }
    public static List<Customer> listCustomer(){
        return customerList;
    }
}
