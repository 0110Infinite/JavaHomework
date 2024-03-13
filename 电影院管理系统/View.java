package project;

// View类，继承自CustomerView，提供主菜单界面
public class View extends CustomerView {

    // 覆盖menu方法，提供主菜单的用户界面
    public void menu() {
        System.out.println("===============电影院购票系统===============");
        System.out.println("1 顾客登录\n2 管理员登录\n3 退出");
        // 根据用户输入，调用不同的功能
        switch (getKey()) {
            case 1:
                new CustomerView().menu();// 顾客登录后进入顾客菜单
                break;
            case 2:
                if (password()) {
                    new AdminView().menu();// 密码正确，进入管理员菜单
                }
                break;
            case 3:
                if (exit()) {// 确认退出
                    System.out.println("确认退出");
                    scanner.close();
                    return;
                }
            default:
                System.out.println("输入有误，请重新输入(1-3)");
        }
    }

    // 覆盖getKey方法，获取用户输入的数字选项
    @Override
    public int getKey() {
        System.out.print("请选择(1-3):");
        return scanner.nextInt();
    }

    // password方法，用于验证管理员密码
    public boolean password() {
        System.out.print("请输入密码(密码错误自动退出)：");
        String password = scanner.next();
        return password.equals("root");
    }
}
