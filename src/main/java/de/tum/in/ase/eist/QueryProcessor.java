package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "konstantin";
        } else if (query.contains("plus")) {
            //what is 5 plus 13
            String one = query.substring(query.indexOf("what is")+"what is".length());
            one = one.replace(" ", "");
            String[] split = one.split("plus");
            return String.valueOf(Integer.parseInt(split[0])+Integer.parseInt(split[1]));
        } else if (query.contains("largest")) {
            // 08de9f90: which of the following numbers is the largest: 44, 15
            String one = query.substring(query.indexOf("largest") + "largest".length());
            one = one.replace(":", "");
            one = one.replace(" ", "");
            String[] split = one.split(",");
            return String.valueOf(Arrays.stream(split).mapToInt(Integer::parseInt).max().getAsInt());
        } else {
            // TODO extend the programm here
            return "";
        }
    }
}
