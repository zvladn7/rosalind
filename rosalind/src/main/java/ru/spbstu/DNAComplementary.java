package ru.spbstu;

import org.apache.commons.lang3.StringUtils;

/**
 * https://rosalind.info/problems/revc/
 */
public class DNAComplementary {

    public static String complement(String dna) {
        if (StringUtils.isBlank(dna)) {
            throw new IllegalArgumentException("No DNA data provided");
        }
        return processDNA(dna);
    }

    private static String processDNA(String dna) {
        StringBuilder result = new StringBuilder();
        for (int i = dna.length() - 1; i >= 0; --i) {
            char symbol = dna.charAt(i);
            char mappedSymbol = changeComplementaryDNASymbol(symbol);
            result.append(mappedSymbol);
        }
        return result.toString();
    }

    private static char changeComplementaryDNASymbol(char symbol) throws IllegalArgumentException {
        return switch (symbol) {
            case 'A' -> 'T';
            case 'T' -> 'A';
            case 'C' -> 'G';
            case 'G' -> 'C';
            default -> throw new IllegalArgumentException("Wrong DNA symbol");
        };
    }

}

