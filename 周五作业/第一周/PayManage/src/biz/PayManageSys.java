package biz;

import entity.Employee;

import java.util.Scanner;

/**
 * 工资管理系统
 */
public class PayManageSys {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        PayManage manage = new PayManage();
        Scanner input = new Scanner(System.in);
        System.out.println(">>工资管理系统：");
        System.out.println("1. 普通员工   2.销售人员    3.经理");
        System.out.print("请选择类型：");
        int typeId = input.nextInt();
        String type = "";
        //todo判断类型
        if (typeId == 1) {
            type = "CommonEmployee";
        } else if (typeId == 2) {
            type = "SellMan";
        } else if (typeId == 3) {
            type = "DeptManager";
        } else {
            System.out.println("输入错误！");
            System.exit(1);
        }


        Employee emp = PayManage.getEmployee(type);//finish 需要计算工资的员工对象
        float pay = emp.getPay();//员工工资
        System.out.println(emp.getEmployeeName() + "(" + emp.getEmployeeId() + ")" + "的工资是：" + pay + "元");
    }
}
