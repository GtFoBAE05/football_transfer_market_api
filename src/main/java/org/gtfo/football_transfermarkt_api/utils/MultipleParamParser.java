package org.gtfo.football_transfermarkt_api.utils;

import org.antlr.v4.runtime.misc.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class MultipleParamParser {

    private static final List<String> listOfFilterName = List.of("e", "lt", "lte", "gt", "gte");
    private static final String regexDash = "^[^-]*-[^-]*$";
    private static final String regexColon = "^[^:]*:[^:]*$";

    public static Pair<String, Pair<Integer, Integer>> multipleParamIntegerChecker(String q) {
        try {
            if (q.matches(regexColon)) {
                return parseSingleIntegerParam(q);
            }

            if (q.matches(regexDash)) {
                return parseMinMaxIntegerParam(q);
            }

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
        } catch (PatternSyntaxException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
        }
    }

    private static Pair<String, Pair<Integer, Integer>> parseSingleIntegerParam(String q) {
        String[] splitStrings = q.split(":");

        if (listOfFilterName.contains(splitStrings[0])) {
            return new Pair<String, Pair<Integer, Integer>>(splitStrings[0], new Pair<>(Integer.parseInt(splitStrings[1]), null));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
    }

    private static Pair<String, Pair<Integer, Integer>> parseMinMaxIntegerParam(String q) {
        String[] splitStrings = q.split("-");

        return new Pair<String, Pair<Integer, Integer>>("bte", new Pair<>(Integer.parseInt(splitStrings[0]), Integer.parseInt(splitStrings[1])));
    }

    public static Pair<String, Pair<BigDecimal, BigDecimal>> multipleParamBigDecimalChecker(String q) {
        try {
            if (q.matches(regexColon)) {
                return parseSingleBigDecimalParam(q);
            }

            if (q.matches(regexDash)) {
                return parseMinMaxBigDecimalParam(q);
            }

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
        } catch (PatternSyntaxException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
        }
    }

    private static Pair<String, Pair<BigDecimal, BigDecimal>> parseSingleBigDecimalParam(String q) {
        String[] splitStrings = q.split(":");

        if (listOfFilterName.contains(splitStrings[0])) {
            BigDecimal value = new BigDecimal(splitStrings[1].trim());
            return new Pair<String, Pair<BigDecimal, BigDecimal>>(splitStrings[0], new Pair<>(value, null));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invaid pattern");
    }

    private static Pair<String, Pair<BigDecimal, BigDecimal>> parseMinMaxBigDecimalParam(String q) {
        String[] splitStrings = q.split("-");

        BigDecimal minValue = new BigDecimal(splitStrings[1].trim());
        BigDecimal maxValue = new BigDecimal(splitStrings[1].trim());
        return new Pair<String, Pair<BigDecimal, BigDecimal>>("bte", new Pair<>(minValue, maxValue));
    }

    public static List<Pair<String, String>> sortByParser(String q) {
        String[] outerSplitStrings = q.split(",");

        ArrayList<Pair<String, String>> pairsOfResult = new ArrayList<>();

        for (String s : outerSplitStrings) {
            if (!s.isEmpty()) {
                String parameterName = s.substring(1);
                if (s.charAt(0) == ' ') {
                    pairsOfResult.add(new Pair<>("asc", parameterName));
                } else if (s.charAt(0) == '-') {
                    pairsOfResult.add(new Pair<>("desc", parameterName));
                } else {
                    throw new RuntimeException( "Invalid pattern");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.OK, "Invalid character");
            }
        }
        return pairsOfResult;
    }
}
