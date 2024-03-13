package project;

// 表示电影院中电影数据库条目的类
public class MovieDb {
    //属性：电影名，余票，票价
    private String movieName;//电影名
    private int ticketCount = 10;//余票，默认初始化为10
    private double ticketPrice;//单张票价

    //电影院正在上映的电影
    int moviesCount = 4;//当前上映的电影数量
    MovieDb[] movieDbs = new MovieDb[moviesCount];//用于存储MovieDb实例的数组，


    // 方法：初始化电影列表
    public void setMovieDbs() {
        // 直接操作父类的protected属性movieDbs来添加电影
        movieDbs[0] = new MovieDb("战狼1", 15);
        movieDbs[1] = new MovieDb("战狼2", 18);
        movieDbs[2] = new MovieDb("流浪地球1", 20);
        movieDbs[3] = new MovieDb("流浪地球2", 25);
        System.out.println("已成功添加电影");
    }

    //构造方法、setter方法、getter方法
    public MovieDb() {
    }

    public MovieDb(String movieName, double ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount() {
        if (ticketCount <= 0) {
            System.out.println("已经没有票了");
            return;
        }
        this.ticketCount--;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
