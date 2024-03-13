package project;

import java.util.Scanner;


// AdminView类，继承自MovieDb，用于后台管理界面
public class AdminView extends MovieDb {
    // 创建一个Scanner对象用于
    Scanner scanner = new Scanner(System.in);



    // 方法：显示管理菜单并响应用户操作
    public void menu() {
        while (true) {
            System.out.println("===============管理系统===============");
            System.out.println("1 查看余票\n2 修改票价\n3 添加电影\n4 退出\n");
            // 根据用户输入执行相应的操作
            switch (getKey()) {
                case 1:
                    ticketCount();
                    break;
                case 2:
                    tickPrice();
                    break;
                case 3:
                    setMovieDbs();
                    break;
                case 4:
                    if (exit()) {
                        System.out.println("确认退出");
                        scanner.close();
                        return;
                    }
                default:
                    System.out.println("输入有误，请重新输入(1-4)");

            }
        }
    }

    // 获取用户输入的选项
    public int getKey() {
        System.out.print("请选择(1-4):");
        return scanner.nextInt();
    }

    // 显示所有电影的余票
    public void ticketCount() {
        System.out.println("1.查看余票");
        for (int i = 0; i < moviesCount; i++) {
            System.out.printf("%s\t剩余 %d 张票\n", movieDbs[i].getMovieName(), movieDbs[i].getTicketCount());
        }

    }

    // 修改指定电影的票价
    public void tickPrice() {
        System.out.println("2.修改票价");
        for (int i = 0; i < moviesCount; i++) {
            System.out.printf("%d.%s\t票价\t%.1f\t元\n", i, movieDbs[i].getMovieName(), movieDbs[i].getTicketPrice());
        }
        System.out.print("请输入要修改的序号：");
        int key = scanner.nextInt();
        System.out.print("请输入修改后的价格：");
        double price = scanner.nextDouble();
        movieDbs[key].setTicketPrice(price);
    }

    // 确认是否退出程序
    public boolean exit() {
        System.out.println("是否确认退出(y/n)");
        return scanner.next().charAt(0) == 'y';
    }

    public AdminView() {
        super。setMovieDbs();
    }
}
