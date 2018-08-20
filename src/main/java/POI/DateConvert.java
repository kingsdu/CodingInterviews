package POI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

    private static DateConvert dateConvert = new DateConvert();

    private DateConvert(){}

    public static DateConvert getInstance(){
        return dateConvert;
    }


    public String getDate(){
        String chinese[] = {"0","一","二","三","四","五","六","七","八","九","十"};
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String d = sdf.format(date);

        StringBuffer sb = new StringBuffer();
        String y = d.substring(0, 4);
        for(int i=0; i<y.length(); i++){
            sb.append(chinese[Integer.parseInt(d.substring(i,i+1))]);
        }
        sb.append("年");
        String m = d.substring(4,6);
        if(Integer.parseInt(m)>10){
            sb.append("十");
            sb.append(chinese[Integer.parseInt(m.substring(1,2))]);
            sb.append("月");
        }else if(Integer.parseInt(m)==10){
            sb.append("十月");
        }else{
            sb.append(chinese[Integer.parseInt(m.substring(1,2))]);
            sb.append("月");
        }
        String dd = d.substring(6);
        if(Integer.parseInt(dd)==10){
            sb.append("十日");
        }else if(Integer.parseInt(dd)==20){
            sb.append("二十日");
        }else if(Integer.parseInt(dd)==30){
            sb.append("三十日");
        }else if(Integer.parseInt(dd)>10 && Integer.parseInt(dd)<20){
            sb.append("十");
            sb.append(chinese[Integer.parseInt(dd.substring(1,2))]);
            sb.append("日");
        }else if(Integer.parseInt(dd)>20 && Integer.parseInt(dd)!=30){
            sb.append(chinese[Integer.parseInt(dd.substring(0,1))]);
            sb.append("十");
            sb.append(chinese[Integer.parseInt(dd.substring(1,2))]);
            sb.append("日");
        }else {
            sb.append(chinese[Integer.parseInt(dd.substring(1,2))]);
            sb.append("日");
        }
        return sb.toString();
    }
}
