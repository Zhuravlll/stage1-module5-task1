package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            String regex = "[A-Z]";
            Pattern pattern = Pattern.compile(regex);
            int i = 0;
            for (String e : x) {
                Matcher matcher = pattern.matcher(e);
                if (matcher.find()) {
                    i++;
                }
            }
            return i == x.size();
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenList = new LinkedList<>();
            for (Integer e : x) {
                if (e % 2 == 0) {
                    evenList.add(e);
                }
            }
            x.addAll(evenList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            String beginning = "[A-Z]";
            Pattern patternB = Pattern.compile(beginning);
            String ending = "[.]";
            Pattern patternE = Pattern.compile(ending);
            int tokenAmount = 0;
            for (String e : values) {
                StringTokenizer tokenizer = new StringTokenizer(e);
                Matcher matcherB = patternB.matcher(tokenizer.nextToken());
                Matcher matcherE = patternE.matcher(e);
                tokenAmount = 0;
                while (tokenizer.hasMoreTokens()) {
                    tokenizer.nextToken();
                    tokenAmount++;
                }
                if (matcherE.find() && matcherB.find() && tokenAmount >= 3) {
                    result.add(e);
                }
            }
            System.out.println(result.toString());
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            HashMap<String, Integer> result = new HashMap<>();
            for (String e : x) {
                result.put(e, e.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
