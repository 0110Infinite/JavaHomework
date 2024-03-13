package project;

// CustomerView类，继承自AdminView，用于购票和退票界面
public class CustomerView extends AdminView {
    //属性
    private int count = 0;//已购买票数
    private String[] movieTicket = new String[2];//已购买票的信息

    // 方法：显示购票系统菜单并响应用户操作
    public void menu() {
        while (true) {
            System.out.println("===============购票系统===============");
            System.out.println("1 购票\n2 退票\n3 退出");
            // 根据用户输入执行相应的操作
            switch (getKey()) {
                case 1:
                    ticketing();// 购票
                    break;
                case 2:
                    refundTicket(); // 退票
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
    }

    @Override
    public int getKey() {
        System.out.print("请选择(1-3):");
        return scanner.nextInt();
    }

    // 购票方法
    public void ticketing() {
        System.out.println("1.购票");
        // 显示所有电影及其票价和余票
        for (int i = 0; i < moviesCount; i++) {
            System.out.printf("%d.%s\t票价\t%.1f 元\t余票%d\n",
                    i,
                    super.movieDbs[i].getMovieName(),
                    super.movieDbs[i].getTicketPrice(),
                    super.movieDbs[i].getTicketCount());
        }
        System.out.println("请选择电影的序号：");
        int key = scanner.nextInt(); // 获取用户选择的电影序号
        if (count == 2) {
            System.out.println("一个人只能买两张票");
            return;// 如果已经买了两张票，就不允许再买
        }
        super.movieDbs[key].setTicketCount();// 减少相应电影的余票数量
        movieTicket[count] = String.format("%s\t票一张\n", super.movieDbs[key].getMovieName());
        count++;
    }

    // 退票方法
    public void refundTicket() {
        System.out.println("2.退票");
        // 显示已购票信息
        for (int i = 0; i < count; i++) {
            System.out.println(i + "\t" + movieTicket[i]);
        }
        System.out.println("请选择电影的序号：");
        int key = scanner.nextInt();// 获取用户选择的票序号
        if (key == 0) {// 如果退第一张票，将第二张票移到第一张的位置
            movieTicket[0] = movieTicket[1];
        }
        movieTicket[1] = "";// 清空最后一张票的信息
        count--; // 减少已购票数
    }
}
