import java.util.HashMap;
import java.util.Map;

public class reformat_date {
    public String reformatDateBruteForce(String date) {
        String day = "";
        String month = "";
        String year = "";
        String res = "";
        int index = 0;
        String zero = "0";
        for (int i = index; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                index = i;
                break;
            } else {
                if (Character.isDigit(date.charAt(i))) {
                    day += date.charAt(i);
                }
            }
        }
        if (day.length() == 1) {
            zero += day;
            day = zero;
        }
        
        for (int i = index+1; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                index = i;
                break;
            } else {
                month += date.charAt(i);
            }
        }
        switch(month) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
            default:
                break;
        }
        for (int i = index+1; i < date.length(); i++) {
            year += date.charAt(i);
        }
        res += year + "-" + month + "-" + day;
        return res;
    }

    public String reformatDateMap(String date) {
        String[] split = date.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 12; ++i) {
            map.put(months[i-1], (i < 10 ? "0" : "") + (i));    
        }
                
        sb.append(split[2]);
        sb.append("-");
        sb.append(map.get(split[1]));
        sb.append("-");
        if (split[0].length() == 3) {
            sb.append("0" + date.substring(0,1));
        } else {
            sb.append(date.substring(0,2));
        }
        return sb.toString();
    }

    private String getMonth(String month) {
        switch(month) {
            case "Jan": return "01";
            case "Feb": return "02";
            case "Mar": return "03";
            case "Apr": return "04";
            case "May": return "05";
            case "Jun": return "06";
            case "Jul": return "07";
            case "Aug": return "08";
            case "Sep": return "09";
            case "Oct": return "10";
            case "Nov": return "11";
            default: return "12";
        }
    
    }
    
    public String reformatDate(String date) {
        String[] reformat = date.split(" ");
        String year = reformat[2];
        String month = reformat[1];
        String day = reformat[0];
        return year + "-" + getMonth(month) + "-" + (day.length() == 3 ? "0" + day.substring(0,1) : day.substring(0,2));
    }
}

/*
Explanation

Classic Dirty Brute Force Way, do 3 loops, and break when you see the first space, then start the next loop at spaceIndex + 1;
Second one is simlar to the last one, except you use a hash map to store the month
Last one is the cleanest and easy to read

Since the input is valid, if the day length is 3, that means we need to add a trailing 0 at the beginning, else we can just get the 0 and 1 substring index

Time: O(N), for looping or for split
Space: O(1)
*/