package io.github.furnapso.numberstowordsbackend.parse;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static io.github.furnapso.numberstowordsbackend.parse.NodeType.DECIMAL;
import static io.github.furnapso.numberstowordsbackend.parse.NodeType.ZERO;

public class NumberToWordParser {
    private BigDecimal number;
    private String numberAsString;
    private ArrayDeque<String> wordStack = new ArrayDeque<>();
    private List<Node> nodes;
    private boolean addCents = false;
    private int length;
    private ZeroesContext zeroesContext = new ZeroesContext();
    private int cents;
    private int dollars;
    private boolean hasCents;
    private boolean hasDollars;
    private boolean lastWasZero = false;

    public NumberToWordParser(Float number) {
        this.number = BigDecimal.valueOf(number).setScale(2, RoundingMode.HALF_UP);
        this.numberAsString = this.number.toString();
        this.nodes = Arrays.stream(numberAsString.split("")).map(Node::new).toList();
        this.length = nodes.size();
        var elements = numberAsString.split("\\.");
        this.dollars = NumberUtils.toInt(elements[0]);
        this.cents = NumberUtils.toInt(elements[1]);
        this.hasCents = cents != 0;
        this.hasDollars = dollars != 0;
    }

    public String parse() {
        for (int i = 0; i < length; i++) {
            var node = nodes.get(i);
            var nodeType = node.getType();

            if (i == 0) {
                wordStack.push(node.toBaseWord());
                continue;
            }

            if (nodeType.equals(DECIMAL)) {
                continue;
            }

            if (!nodeType.equals(ZERO) && zeroesContext.hasCurrentContext()) {
                wordStack.push(zeroesContext.toString());
                zeroesContext.reset();
            }

            if (!List.of(ZERO, DECIMAL).contains(nodeType)) {
                zeroesContext.setTensCurrent(node.toTensWord());
            }

            switch (node.getType()) {
                case DECIMAL -> {
                    if (hasDollars) {
                        wordStack.push("DOLLARS");
                    }
                }
                case ZERO -> {
                    zeroesContext.increment();

                    if (lastWasZero) {
                        wordStack.pop();
                    }

                    lastWasZero = true;

                    wordStack.push(zeroesContext.toString());
                }
            }
        }
        return String.join(" ", wordStack);
    }

    private void handleZeros(Node currentNode, Node nextNode) {
        var zeroesContext = new ZeroesContext();
        int index = nodes.indexOf(nextNode);
        while (nextNode.getType() == ZERO && index + 1 < length) {
            zeroesContext.increment();
            index++;
        }
        var zeroesWord = zeroesContext.toString();
        if (zeroesWord.equals("TEN")) {
            zeroesWord = currentNode.toTensWord();
        } else {
            wordStack.push(currentNode.toBaseWord());
        }
        wordStack.push(zeroesWord);
    }
}
