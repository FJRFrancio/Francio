public class MyDate {

    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    int year;
    int month;
    int day;

    @Override
    public boolean equals(Object obj) {
        int flag = 1;//通过此技巧，第一个if过不去或者内部数据不相等均会返回false

        if(obj instanceof MyDate){
            MyDate md = (MyDate) obj;
            //here has a little trick
            flag = 0;

            if(this.year != md.year){
                flag += 1;
            }

            if (this.month != md.month){
                flag += 1;
            }

            if (this.day != md.day){
                flag += 1;
            }

        }

        if (flag == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        
        String str = this.year + "-" + this.month + "-" + this.day;

        return str;
    }


}