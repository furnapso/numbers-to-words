package io.github.furnapso.numberstowordsbackend.parse;

import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsConstants.getBaseWordFromString;
import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsConstants.getTensWordFromString;

@Data
public class Node {
    private NodeType type;
    private String value;
    private Integer intValue;

    public Node(String s) {
        value = s;
        intValue = NumberUtils.toInt(s);
        type = NodeType.fromString(s);
    }

    public String toBaseWord() {
        return getBaseWordFromString(value);
    }

    public String toTensWord() {
        return getTensWordFromString(value);
    }
}
