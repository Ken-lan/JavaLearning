package extend;

import java.text.SimpleDateFormat;
import java.util.Date;
//java.sql.Date, JDBC

public class Food extends Product {


    private Date expireDate;

    public Food(String name, int price, Date expireDate) {
        super(name, price);
        this.expireDate = expireDate;
    }

    @Override
    public String desc() {
        String description = super.desc();
        //2023/01/06, y:year , M:month , m:minutes, h:hour
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        description = description +",到期日："+f.format(expireDate);
        return description;
    }
}
