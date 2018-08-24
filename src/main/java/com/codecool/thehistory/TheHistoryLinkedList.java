package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        List<String> textArray = Arrays.asList(text.split("\\W+"));
        wordsLinkedList.addAll(textArray);

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        Iterator<String> itrArray = wordsLinkedList.iterator();
        while (itrArray.hasNext()) {
            if (itrArray.next().equalsIgnoreCase(wordToBeRemoved)) {
                itrArray.remove();
            }
        }

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> iterator = wordsLinkedList.listIterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(from)) {
                iterator.set(to);
            }
        }
    }


    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
