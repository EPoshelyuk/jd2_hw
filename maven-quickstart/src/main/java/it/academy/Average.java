package it.academy;

import java.util.List;

public class Average {

    public double count(List<Integer> list) {
        double res = 0;
        int length = list.size();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + list.get(i);
        }
        res=(double)sum/length;
        return res;
    }

}
